package com.trevorism.schedule.model;

import java.util.Date;

public class ScheduledTask {

    public static final ScheduledTask NULL_SCHEDULED_TASK = new ScheduledTask();

    private String id;
    private String name;
    private String type;
    private Date startDate;
    private boolean enabled;

    private String endpoint;
    private String httpMethod;
    private String requestJson;

    public static boolean isNullObject(ScheduledTask task) {
        return null == task.getName();
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id;  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() { return type; }

    public void setType(String type) {
        this.type = type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestJson() {
        return requestJson;
    }

    public void setRequestJson(String requestJson) {
        this.requestJson = requestJson;
    }

}
