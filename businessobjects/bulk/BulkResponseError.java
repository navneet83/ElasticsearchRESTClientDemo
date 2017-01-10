package org.elasticsearch.services.demo.businessobjects.bulk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BulkResponseError {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("reason")
    @Expose
    private String reason;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
