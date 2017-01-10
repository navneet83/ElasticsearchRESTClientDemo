package org.elasticsearch.services.demo.businessobjects.bulk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BulkResponseItems {

    @SerializedName("index")
    @Expose
    private BulkResponseItem index;

    public BulkResponseItem getItems() {
        return index;
    }

    public void setItems(BulkResponseItem index) {
        this.index = index;
    }

}
