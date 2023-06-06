package com.demoproject.utils;

import com.demoproject.helper.api.DemoProjectConstants;
import com.demoproject.helper.api.payloads.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {

    public static Map<String, Object> postRequestBody(String fileName, Object... values) {
//        String requestJson = new String("src/main/resources/json/api/"+"createWeatherStation.json");
//        String requestJson = JsonUtil
//                .readJsonFromResource(DemoProjectConstants.PROPERTIES_CONFIG.requestJsonPath() + "createWeatherStation.json");
        String requestJson = new String(fileName);
        Map<String, Object> requestBody = new HashMap<>();
        try {
            requestBody = JsonUtil.asMap(Payload.getRequest(requestJson, values));
        } catch (final IOException e) {

        }
        return requestBody;
    }
}
