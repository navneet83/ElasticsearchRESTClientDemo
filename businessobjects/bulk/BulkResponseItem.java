package org.elasticsearch.services.demo.businessobjects.bulk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BulkResponseItem {

    @SerializedName("_index")
    @Expose
    private String index;
    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("_version")
    @Expose
    private Integer version;
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("_shards")
    @Expose
    private BulkResponseShards bulkResponseShards;
    @SerializedName("created")
    @Expose
    private Boolean created;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("error")
    @Expose
    private BulkResponseError error;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public BulkResponseShards getBulkResponseShards() {
        return bulkResponseShards;
    }

    public void setBulkResponseShards(BulkResponseShards bulkResponseShards) {
        this.bulkResponseShards = bulkResponseShards;
    }

    public Boolean getCreated() {
        return created;
    }

    public void setCreated(Boolean created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BulkResponseError getError() {
        return error;
    }

    public void setError(BulkResponseError error) {
        this.error = error;
    }

    public boolean hasError() {
        return (this.error != null);
    }
}
