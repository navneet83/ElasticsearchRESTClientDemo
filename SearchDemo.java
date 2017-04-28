package org.elasticsearch.services.demo.businessobjects;

//import com.google.gson.Gson;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.services.demo.RestClientSingleton;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

public class SearchDemo {

    public static void main(String args[]){
        try {
            performSearch();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static void performSearch() throws UnsupportedEncodingException {
        Response response;
        RestClient restClient = RestClientSingleton.getClient();
//        Gson gson = new Gson();
        StringEntity query =  new StringEntity("{\"query\":{\"match\":{\"user\":\"user1\"}}}", ContentType.APPLICATION_JSON);

        try{

            response = restClient.performRequest("GET", "/bulktest/_search", Collections.singletonMap("pretty", "true"), query);
            System.out.println(EntityUtils.toString(response.getEntity()));

//           SearchResponse response = gson.fromJson(EntityUtils.toString(response.getEntity()), SearchResponse.class);

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

//    private static

}
