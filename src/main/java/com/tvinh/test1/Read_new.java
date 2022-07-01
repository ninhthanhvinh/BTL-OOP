package com.tvinh.test1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Read_new {
    Map<String, Object> map = new HashMap<String, Object>();

    private final String JSON = "application/json";

    @Test
    public void Test01() {
//        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

        Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
                contentType(JSON).
                with().
                pathParam("newId", 1).
                when().
                get("/news/read/{newId}");
        res.then().statusCode(200);

        JsonPath jpath = res.jsonPath();
        LinkedHashMap<String, String> data = jpath.get("data");
        System.out.println(data);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Read_new.class });
        testng.addListener(tla);
        testng.run();
    }
}