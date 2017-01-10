package org.elasticsearch.services.demo;

import org.elasticsearch.services.demo.businessobjects.*;
import org.elasticsearch.services.demo.businessobjects.bulk.BulkIndexRequest;

public class TweetBulkIndexRequest {

    private BulkIndexRequest tweetBulkIndexRequest;
    private TweetEntity tweet;

    public TweetEntity gettweet() {
        return tweet;
    }

    public void setTweet(TweetEntity tweet) {
        this.tweet = tweet;
    }

    public BulkIndexRequest getTweetBulkIndexRequest() {
        return tweetBulkIndexRequest;
    }

    public void setTweetBulkIndexRequest(BulkIndexRequest tweetBulkIndexMetaData) {
        this.tweetBulkIndexRequest = tweetBulkIndexMetaData;
    }

}
