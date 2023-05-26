package com.demoproject.helper.api;
import java.util.HashMap;

public class HeaderConfig {
    public static HashMap<String, String> getHeaders(){
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }
}
