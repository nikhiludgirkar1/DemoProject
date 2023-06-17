package com.demoproject.helper.api.data;

import com.demoproject.utils.RandomDataUtil;

import java.util.HashMap;
import java.util.Map;

public class RandomWeatherData {
    private static Map<String, Object> weatherMap;

    public static Map<String, Object> getWeatherData() {
        String externalId = RandomDataUtil.getExternalId();
        String name = RandomDataUtil.getRandomName();
        double latitude = RandomDataUtil.getLatitude();
        double longitude = RandomDataUtil.getLongitude();
        double altitude = RandomDataUtil.getAltitude();
        weatherMap = new HashMap<>();
        weatherMap.put("externalId", externalId);
        weatherMap.put("name", name);
        weatherMap.put("latitude", latitude);
        weatherMap.put("longitude", longitude);
        weatherMap.put("altitude", altitude);
        return weatherMap;
    }
}
