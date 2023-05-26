package com.demoproject.helper.api;

public class RespSpecification {

    public static boolean isStatusSuccess(int statusCode) {
        if (statusCode >= 200 && statusCode <= 204)
            return true;
        return false;
    }
}
