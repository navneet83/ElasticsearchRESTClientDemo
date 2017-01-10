package org.elasticsearch.services.demo;

import com.google.gson.Gson;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.services.demo.businessobjects.*;
import org.elasticsearch.services.demo.businessobjects.bulk.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BulkOperationDemo {

    public static void main(String[] args) {
        BulkResponse bulkresponse = null;
        List<TweetBulkIndexRequest> failedDocuments;
        List<TweetBulkIndexRequest> failedDocumentsRetryable;

        //verify connectivity with Elasticsearch and proceed
        if(RestClientSingleton.verifyConnection()){

            //generate random tweet bulk request objects
            ArrayList<TweetBulkIndexRequest> randomTweetBulkRequests = generateRandomTweetBulkRequests(10);

            try {
                //perform bulk indexing.
                bulkresponse = performBulkRequest(randomTweetBulkRequests);

                //print status response for each document in bulk request.
                printBulkResponseStatusCode (bulkresponse);

            } catch (IOException e) {
                e.printStackTrace();
                //any exception here should bubble up the stack
            }

            //if there are failures, it can be transient or non-transient
            if (bulkresponse.hasErrors())
            {
                System.out.println("bulk response has failures:");

                //this will store those documents which failed and can not be retried (eg, mapping error)
                failedDocuments = new ArrayList<TweetBulkIndexRequest>();

                //this will store those documents which can be retried
                // for example - es_rejected_execution_exception because bulk queue was full
                failedDocumentsRetryable = new ArrayList<TweetBulkIndexRequest>();

                //we now go through each bulk response
                for (int i = 0; i<bulkresponse.getBulkResponseItems().size(); i++)
                {
                    BulkResponseItem item = bulkresponse.getBulkResponseItems().get(i).getItems();

                    //if bulk response has errors
                    if (item.hasError()) {
                        //if the error type is retryable
                        if (item.getError().getType().equalsIgnoreCase("es_rejected_execution_exception")){
                            failedDocumentsRetryable.add(randomTweetBulkRequests.get(i));
                        }
                        //else store it as non-retryable error
                        else {

                            failedDocuments.add(randomTweetBulkRequests.get(i));
                        }
                    }
                }
                System.out.println("Total bulk errors = " + (failedDocumentsRetryable.size()+failedDocuments.size()));
                System.out.println("Total retryable bulk errors = " + (failedDocumentsRetryable.size()));
                // retry bulk indexing for those documents which
                // failed with retryable bulk error
                //performBulkRequest(failedDocumentsRetryable);
            }
        }

        try {
            //close rest client
            RestClientSingleton.closeRestClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printBulkResponseStatusCode(BulkResponse bulkresponse) {
        for (int i = 0; i<bulkresponse.getBulkResponseItems().size(); i++){
            System.out.println(bulkresponse.getBulkResponseItems().get(i).getItems().getStatus());
        }
    }

    private static BulkResponse performBulkRequest(List<TweetBulkIndexRequest> randomTweetBulkRequests) throws IOException {
        Response response;
        BulkResponse bulkresponse;
        Gson gson = new Gson();
        StringEntity entity;
        StringBuilder bulkRequests = new StringBuilder();

        //create bulk indexing request string by appending all bulk requests in randomTweetBulkRequests object
        for (TweetBulkIndexRequest tweet : randomTweetBulkRequests){
            bulkRequests.append(gson.toJson(tweet.getTweetBulkIndexRequest()));
            bulkRequests.append("\r\n");
            bulkRequests.append(gson.toJson(tweet.gettweet()));
            bulkRequests.append("\r\n");
        }

        entity = new StringEntity(bulkRequests.toString(), Charset.defaultCharset());
        //get rest client from singleton
        RestClient restClient = RestClientSingleton.getClient();

        //perform bulk request
        try {
            response = restClient.performRequest("POST", "/_bulk", Collections.<String, String>emptyMap(), entity);
            bulkresponse = gson.fromJson(EntityUtils.toString(response.getEntity()), BulkResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
            //bubble up the exception in the stack as we can not handle it here
        }
        //return response
        return bulkresponse;
    }

    private static ArrayList<TweetBulkIndexRequest> generateRandomTweetBulkRequests (int count) {
        //generate random data for indexing
        ArrayList<TweetBulkIndexRequest> tweets = new ArrayList<TweetBulkIndexRequest>();
        for (int i=0; i<count; i++){
            TweetBulkIndexRequest tweet = new TweetBulkIndexRequest();
            tweet.setTweet(new TweetEntity("Random tweet text " + i, new Date(), "user1"));
            BulkIndexRequest req = new BulkIndexRequest();
            BulkDocumentMetaData meta = new BulkDocumentMetaData();
            meta.setIndex("bulktest");
            meta.setType("mytype");
            meta.setId(""+i);
            req.setBulkDocumentMetaData(meta);
            tweet.setTweetBulkIndexRequest(req);
            tweets.add(i, tweet);
        }
        return tweets;
    }

}
