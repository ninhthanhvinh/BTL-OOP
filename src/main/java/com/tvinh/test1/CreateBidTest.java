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
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;

public class CreateBidTest {

    Map<String, Object> map = new HashMap<String, Object>();

    private final String JSON = "application/json";

    @Test
    public void Test01 () {
        //        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";
        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        request.put("price", 10000);
        request.put("bid_last_id", a);

        Response response = given().
                header("Authorization", "Bearer"+ /*ACCESS_TOKEN*/
                        "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NjM4MDE3NiwiZXhwIjoxNjU2NzQwMTc2LCJuYmYiOjE2NTYzODAxNzYsImp0aSI6ImhKUnN5ekhHWFFESXBpa20iLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.M5keGqBHO6E7l4obs2U1QIwwmhPX5joAk6t15v2Psck").
                contentType(JSON).
                with().
                pathParam("auctionId", 100).
                when().
                post("/bids/create/{auctionId}");

        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }

}


