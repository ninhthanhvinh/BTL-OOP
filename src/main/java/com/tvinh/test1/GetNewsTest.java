package com.tvinh.test1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetNewsTest {

    Map<String, Object> map = new HashMap<String, Object>();

    //String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
    private final String JSON = "application/json";

    @Test
    public void Test01 () {

        JSONObject request = new JSONObject();

        //        baseURI = AutomationTesting.baseuri;

        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();

        String ACCESS_TOKEN = loginTest.getAccessToken();
        request.put("access_token", ACCESS_TOKEN);
        request.put("index", "5");
        request.put("count", "8");

        Response response = given().get("/news");
        response.then().statusCode(200);


        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);

    }
}
