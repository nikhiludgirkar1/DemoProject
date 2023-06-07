package com.demoproject.helper.api;

import java.util.HashMap;

public class ApiSetup {

    public static HashMap<String, String> getData() {
        HashMap<String, String> envHashMap = new HashMap<>();
        envHashMap.put("createStation", Endpoints.apiPath.createStation);
        envHashMap.put("station", Endpoints.apiPath.station);
        return envHashMap;
    }
}
