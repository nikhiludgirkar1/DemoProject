package com.demoproject.helper.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class ReqResApi implements AutoCloseable {

    private String baseUri;
    HashMap<String, String> headers;
    private static RequestSpecification requestSpecification;

    public ReqResApi(String baseUri, HashMap<String, String> headers) {
        this.headers = headers;
        this.baseUri = baseUri;
        System.out.println("baseuri" + baseUri);
    }

    //    public ReqResApi(String baseUri) {
    //        this(baseUri, (Map<String, String>)null);
    //    }

//
//        public ReqResApi(String baseUri, String authToken) {
//            this(baseUri, authToken == null ? null : ImmutableMap.of("auth", authToken));
//        }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .addHeaders(headers)
                .build();
    }

    @Override
    public void close() throws Exception {

    }
}
