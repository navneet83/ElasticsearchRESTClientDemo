package org.elasticsearch.services.demo.businessobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sun.jdi.connect.Connector;

import java.util.Date;

public class TweetEntity {

    public TweetEntity (String message, Date postDate, String user){
        this.message = message;
        this.postDate= postDate;
        this.user= user;
    }

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("post_date")
    @Expose
    private Date postDate;
    @SerializedName("message")
    @Expose
    private String message;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
