package com.tvinh.test1;

import com.tvinh.test1.AutomationTesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest {

    public static String ACCESS_TOKEN;

    private final String JSON = "application/json";


    @Test
    public void Test01() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "ninhthanhvinh@gmail.com");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }
    @Test
    public void Test02() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
    }
    @Test
    public void Test03() {

        Map<String, String> map = new HashMap<String, String>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "admin@gmail.com");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1002);
    }

    @Test
    public void Test04() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "thanh12345@gmail.com");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1002);
    }

    @Test
    public void Test05() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
    }

    @Test
    public void Test06() {

        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "thanh12345gmail.com");
        request.put("password", "");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");
        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1001);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { LoginTest.class });
        testng.addListener(tla);
        testng.run();
    }

    public String getAccessToken(){
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject();

        baseURI = AutomationTesting.baseuri;

        request.put("email", "ninhthanhvinh@gmail.com");
        request.put("password", "123456");

        Response response = given().contentType(JSON).
                body(request.toJSONString()).
                when().
                post("/login");

        JsonPath jp = response.jsonPath();
        LinkedHashMap<String, Object> data = jp.get("data");

        return data.get("access_token").toString();
    }

}


