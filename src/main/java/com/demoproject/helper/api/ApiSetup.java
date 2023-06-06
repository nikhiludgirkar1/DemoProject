package com.demoproject.helper.api;

import java.util.HashMap;

public class ApiSetup {

    public static HashMap<String, String> getData() {
        HashMap<String, String> envHashMap = new HashMap<>();
        envHashMap.put("allUsers", Endpoints.apiPath.allUsers);
        envHashMap.put("singleUser", Endpoints.apiPath.singleUser);
        envHashMap.put("createStation", Endpoints.apiPath.createStation);
        return envHashMap;
    }
}
