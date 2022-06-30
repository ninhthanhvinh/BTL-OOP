package com.tvinh.test1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetNewsTest {

    Map<String, Object> map = new HashMap<String, Object>();

    LoginTest loginTest = new LoginTest();
    String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
    private final String JSON = "application/json";

    @Test
    public void Test01() {
//        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        request.put("access_token", ACCESS_TOKEN);
        request.put("index", "10");
        request.put("count", "10");

        Response response = given().header("Authorization","Bearer" + ACCESS_TOKEN).
                contentType(JSON).
                body(request.toJSONString()).
                when().
                get("/news");
        response.then().statusCode(200);
        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }

    @Test
    public void Test02() {
//        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        request.put("access_token", ACCESS_TOKEN);
        request.put("index", "10000");
        request.put("count", "10");

        Response response = given().header("Authorization", "Bearer" + ACCESS_TOKEN).
                contentType(JSON).
                body(request.toJSONString()).
                when().
                get("/news");
        response.then().statusCode(200);
        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }


    @Test
    public void Test03() {
//        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        request.put("access_token", ACCESS_TOKEN);
        request.put("index", "10");
        request.put("count", "9999999999999999999999999999");

        Response response = given().header("Authorization", "Bearer" + ACCESS_TOKEN).
                contentType(JSON).
                body(request.toJSONString()).
                when().
                get("/news");
        response.then().statusCode(200);
        System.out.println(response.getStatusCode());

        System.out.println(response.getBody().asString());

        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }

    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { GetNewsTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
