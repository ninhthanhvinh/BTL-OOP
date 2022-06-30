package com.tvinh.test1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import javafx.scene.text.Text;
import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ContactUsTest {


    Map<String, Object> map = new HashMap<String, Object>();
    Map<Text, Object> map1 = new HashMap<Text, Object>();

    public static String ACCESS_TOKEN;
    //String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
    private final String JSON = "application/json";

    @Test
    public void Test01() {
//        baseURI = AutomationTesting.baseuri;

        JSONObject request = new JSONObject();

        baseURI = "https://auction-app3.herokuapp.com/api";

        request.put("access_token", ACCESS_TOKEN);
        request.put("name", "vinh");
        request.put("phone", "090445554");
        request.put("email", "ninhthanhvinh1@gmail.com");
        request.put("content", "chan vl");
        request.put("file", null);
        request.put("report_type:", "1");

        Response response = given().
                post("/contactUs");
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
        testng.setTestClasses(new Class[] { ContactUsTest.class });
        testng.addListener(tla);
        testng.run();
    }
}
