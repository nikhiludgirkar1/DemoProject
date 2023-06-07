package com.demoproject.helper.api.payloads;

import com.demoproject.helper.api.DemoProjectConstants;
import com.demoproject.utils.JsonUtil;
//import com.orangehrm.helper.api.OrangeConstants;
//import com.orangehrm.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Payload {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public static String getRequest(String requestJsonFileName, Object... values) throws IOException {
        logger.debug("Request JSON is1 :: " + requestJsonFileName);
        String requestJson = JsonUtil
                .readJsonFromResource(requestJsonFileName);
        logger.debug("2nd Request JSON :: "+requestJson);
        try {
            Class<?> stringClass = String.class;
            Class[] argTypes = new Class[] { String.class, Object[].class };
            Method method = stringClass.getMethod("format", argTypes);
            Object[] methodArgs = Arrays.copyOfRange(values, 0, values.length);
            logger.debug("invoking %s.format()%n", stringClass.getName());
            Object requestJsonObj = method.invoke(null, requestJson, (Object) methodArgs);
            requestJson = requestJsonObj.toString();
            logger.debug("3rd Request JSON ::  " + requestJsonObj.toString());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return requestJson;
    }

}
