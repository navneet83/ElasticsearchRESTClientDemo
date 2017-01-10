package org.elasticsearch.services.demo.businessobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClusterHealthEntity {

    @SerializedName("cluster_name")
    @Expose
    private String clusterName;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("timed_out")
    @Expose
    private Boolean timedOut;
    @SerializedName("number_of_nodes")
    @Expose
    private Integer numberOfNodes;
    @SerializedName("number_of_data_nodes")
    @Expose
    private Integer numberOfDataNodes;
    @SerializedName("active_primary_shards")
    @Expose
    private Integer activePrimaryShards;
    @SerializedName("active_shards")
    @Expose
    private Integer activeShards;
    @SerializedName("relocating_shards")
    @Expose
    private Integer relocatingShards;
    @SerializedName("initializing_shards")
    @Expose
    private Integer initializingShards;
    @SerializedName("unassigned_shards")
    @Expose
    private Integer unassignedShards;
    @SerializedName("delayed_unassigned_shards")
    @Expose
    private Integer delayedUnassignedShards;
    @SerializedName("number_of_pending_tasks")
    @Expose
    private Integer numberOfPendingTasks;
    @SerializedName("number_of_in_flight_fetch")
    @Expose
    private Integer numberOfInFlightFetch;
    @SerializedName("task_max_waiting_in_queue_millis")
    @Expose
    private Integer taskMaxWaitingInQueueMillis;
    @SerializedName("active_shards_percent_as_number")
    @Expose
    private Double activeShardsPercentAsNumber;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Boolean timedOut) {
        this.timedOut = timedOut;
    }

    public Integer getNumberOfNodes() {
        return numberOfNodes;
    }

    public void setNumberOfNodes(Integer numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
    }

    public Integer getNumberOfDataNodes() {
        return numberOfDataNodes;
    }

    public void setNumberOfDataNodes(Integer numberOfDataNodes) {
        this.numberOfDataNodes = numberOfDataNodes;
    }

    public Integer getActivePrimaryShards() {
        return activePrimaryShards;
    }

    public void setActivePrimaryShards(Integer activePrimaryShards) {
        this.activePrimaryShards = activePrimaryShards;
    }

    public Integer getActiveShards() {
        return activeShards;
    }

    public void setActiveShards(Integer activeShards) {
        this.activeShards = activeShards;
    }

    public Integer getRelocatingShards() {
        return relocatingShards;
    }

    public void setRelocatingShards(Integer relocatingShards) {
        this.relocatingShards = relocatingShards;
    }

    public Integer getInitializingShards() {
        return initializingShards;
    }

    public void setInitializingShards(Integer initializingShards) {
        this.initializingShards = initializingShards;
    }

    public Integer getUnassignedShards() {
        return unassignedShards;
    }

    public void setUnassignedShards(Integer unassignedShards) {
        this.unassignedShards = unassignedShards;
    }

    public Integer getDelayedUnassignedShards() {
        return delayedUnassignedShards;
    }

    public void setDelayedUnassignedShards(Integer delayedUnassignedShards) {
        this.delayedUnassignedShards = delayedUnassignedShards;
    }

    public Integer getNumberOfPendingTasks() {
        return numberOfPendingTasks;
    }

    public void setNumberOfPendingTasks(Integer numberOfPendingTasks) {
        this.numberOfPendingTasks = numberOfPendingTasks;
    }

    public Integer getNumberOfInFlightFetch() {
        return numberOfInFlightFetch;
    }

    public void setNumberOfInFlightFetch(Integer numberOfInFlightFetch) {
        this.numberOfInFlightFetch = numberOfInFlightFetch;
    }

    public Integer getTaskMaxWaitingInQueueMillis() {
        return taskMaxWaitingInQueueMillis;
    }

    public void setTaskMaxWaitingInQueueMillis(Integer taskMaxWaitingInQueueMillis) {
        this.taskMaxWaitingInQueueMillis = taskMaxWaitingInQueueMillis;
    }

    public Double getActiveShardsPercentAsNumber() {
        return activeShardsPercentAsNumber;
    }

    public void setActiveShardsPercentAsNumber(Double activeShardsPercentAsNumber) {
        this.activeShardsPercentAsNumber = activeShardsPercentAsNumber;
    }

}
