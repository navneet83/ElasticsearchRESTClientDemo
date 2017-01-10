package org.elasticsearch.services.demo.businessobjects.bulk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class BulkResponseShards {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("successful")
    @Expose
    private Integer successful;
    @SerializedName("failed")
    @Expose
    private Integer failed;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getSuccessful() {
        return successful;
    }

    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

}
