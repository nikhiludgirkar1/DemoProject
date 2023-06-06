package com.demoproject.definitions;

import com.demoproject.helper.api.*;
import com.demoproject.utils.PostAPIBuilder;
import com.demoproject.utils.RandomDataUtil;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APIDefinition {

    private HashMap<String, String> map;
    private RequestSpecification requestSpecification;
    private String baseUri;
    private Response response;
    private ReqResApi reqResApi;
    private HashMap<String, String> endpointData;
    private HashMap<String, String> headers;

    public APIDefinition() {
        this.baseUri = DemoProjectConstants.PROPERTIES_CONFIG.baseApiUrl();
        endpointData = ApiSetup.getData();
        headers = HeaderConfig.getHeaders();
        reqResApi = new ReqResApi(this.baseUri, headers);
    }

//    @Given("Admin should be able to create user with name {string} and job {string}")
//    public void userShouldBeAbleToListUsers(String name, String job) {
//        HashMap<String, String> testData = new HashMap<>();
//        testData.put("name", name);
//        testData.put("job", job);
//        response = given()
//                .spec(reqResApi.getRequestSpecification())
//                .body(testData)
//                .basePath(endpointData.get("allUsers"))
//                .when().post().then().extract().response();
//        assertTrue(RespSpecification.isStatusSuccess(response.getStatusCode()));
//    }
//
//    @And("user gets response for valid user id")
//    public void userGetsResponseForValidEndpoint() {
//        response = given()
//                .spec(reqResApi.getRequestSpecification())
//                .basePath(endpointData.get("singleUser"))
//                .when()
//                .get()
//                .then().extract().response();
//        assertTrue(RespSpecification.isStatusSuccess(response.statusCode()), "Status code was different");
//        DocumentContext documentContext = JsonPath.parse(response.asString());
//        List<String> text = documentContext.read("$..support[?(@.url=='https://reqres.in/#support-heading')].text");
//        System.out.println("text is " + text);
//    }

    @Given("User should be able to create weather station with valid weather details")
    public void userShouldBeAbleToCreateWeatherStation() {
        String externalId = RandomDataUtil.getExternalId();
        String name = RandomDataUtil.getRandomName();
        double latitude = RandomDataUtil.getLatitude();
        double longitude = RandomDataUtil.getLongitude();
        double altitude = RandomDataUtil.getAltitude();
        response = given()
                .spec(reqResApi.getRequestSpecification())
                .body(PostAPIBuilder.postRequestBody("createWeatherStation.json",externalId, name, latitude, longitude, altitude))
                .queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
                .basePath(endpointData.get("createStation"))
                .when()
                .post()
                .then()
                .extract().response();
        assertTrue(RespSpecification.isStatusSuccess(response.statusCode()), "Status code was different");

    }

}
