package org.elasticsearch.services.demo.businessobjects.bulk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//{ "index" : { "_index" : "test", "_type" : "type1", "_id" : "1" } }
public class BulkIndexRequest {
    @SerializedName("index")
    @Expose
    private BulkDocumentMetaData index;

    public BulkDocumentMetaData getIndex() {
        return index;
    }

    public void setBulkDocumentMetaData(BulkDocumentMetaData index) {
        this.index = index;
    }
}
