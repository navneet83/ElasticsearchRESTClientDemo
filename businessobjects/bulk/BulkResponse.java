package org.elasticsearch.services.demo.businessobjects.bulk;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BulkResponse {
    @SerializedName("took")
    @Expose
    private Integer took;
    @SerializedName("errors")
    @Expose
    private Boolean errors;
    @SerializedName("items")
    @Expose
    private List<BulkResponseItems> bulkResponseItems = null;

    public Integer getTook() {
        return took;
    }

    public void setTook(Integer took) {
        this.took = took;
    }

    public Boolean hasErrors() {
        return errors;
    }

    public void setErrors(Boolean errors) {
        this.errors = errors;
    }

    public List<BulkResponseItems> getBulkResponseItems() {
        return bulkResponseItems;
    }

    public void setBulkResponseItems(List<BulkResponseItems> bulkResponseItems) {
        this.bulkResponseItems = bulkResponseItems;
    }
}

