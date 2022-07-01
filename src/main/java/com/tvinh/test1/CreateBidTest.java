package com.tvinh.test1;

import com.tvinh.test1.AutomationTesting;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class CreateBidTest {

    Map<String, Object> map = new HashMap<String, Object>();

    LoginTest loginTest = new LoginTest();
    String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
    private final String JSON = "application/json";

    @Test
    public void Test01 () {
        //        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        request.put("access_token", ACCESS_TOKEN);
        request.put("price", (int) 1);
        request.put("bid_last_id", (int) 1);

        Response response = given().
                post("/bids/create/1");
        response.then().statusCode(200);
        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        Assert.assertEquals(code, 1000);
    }
}


