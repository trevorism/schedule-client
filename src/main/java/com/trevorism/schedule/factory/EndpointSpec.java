package com.trevorism.schedule.factory;

import com.trevorism.schedule.model.HttpMethod;

public class EndpointSpec {

    private final String endpoint;
    private final String httpMethod;
    private final String requestJson;

    public EndpointSpec(String endpoint, HttpMethod httpMethod, String requestJson) {
        this.endpoint = endpoint;
        this.httpMethod = httpMethod.toString().toLowerCase();
        this.requestJson = requestJson;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestJson() {
        return requestJson;
    }
}
