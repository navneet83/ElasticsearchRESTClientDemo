package org.elasticsearch.services.demo;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.services.demo.businessobjects.ClusterHealthEntity;

import java.io.IOException;
import java.util.Collections;

public class RestClientSingleton {

    private static RestClient restClient;
    private static Gson gson = new Gson();
    public static RestClient getClient()  {
        if (restClient == null) {
            restClient = createRestClient();
        }
        return restClient;
    }

    public static void closeRestClient() throws IOException {
        try {
            restClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static RestClient createRestClient() {
        restClient = RestClient.builder(
                new HttpHost("localhost", 9200, "http")).build();
        return restClient;
    }

    public static boolean verifyConnection() {
        boolean result = false;
        Response response = null;
        try {
            response = RestClientSingleton.getClient().performRequest("GET", "/_cluster/health",
                    Collections.singletonMap("pretty", "true"));
            ClusterHealthEntity clusterhealth = gson.fromJson(EntityUtils.toString(response.getEntity()), ClusterHealthEntity.class);
            if(!(clusterhealth.getClusterName()==null || clusterhealth.getClusterName().trim().equals("")))
                result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }

}