package com.tvinh.test1;

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
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DeleteCommentTest {
    Map<String, Object> map = new HashMap<String, Object>();

    private final String JSON = "application/json";

    @Test
    public void Test01() {
//        baseURI = AutomationTesting.baseuri;

        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

        Response response = given().
                header("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NjM4MDE3NiwiZXhwIjoxNjU2NzQwMTc2LCJuYmYiOjE2NTYzODAxNzYsImp0aSI6ImhKUnN5ekhHWFFESXBpa20iLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.M5keGqBHO6E7l4obs2U1QIwwmhPX5joAk6t15v2Psck").
                contentType(JSON).
                with().
                pathParam("commentId", 1).
                when().
                get("/comments/{commentId}");
        response.then().statusCode(200);

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }

    @Test
    public void Test02() {
//        baseURI = AutomationTesting.baseuri;

        baseURI = "https://auction-app3.herokuapp.com/api";

        String ACCESS_TOKEN = "asfewasdasfdscasdgfrafsfecasdcawef123.123asdf342ads";

        Response response = given().
                header("access_token",ACCESS_TOKEN).
                contentType(JSON).
                with().
                pathParam("commentId", 2).
                when().
                get("comments/{commentId}");

        System.out.println(response.getBody().asString());

        response.then().statusCode(200);
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }
    public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { DeleteCommentTest.class });
        testng.addListener(tla);
        testng.run();
    }

    @Test
    public void Test03() {
//        baseURI = AutomationTesting.baseuri;

        baseURI = "https://auction-app3.herokuapp.com/api";

        LoginTest loginTest = new LoginTest();
        String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;

        Response response = given().
                header("authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NjM4MDE3NiwiZXhwIjoxNjU2NzQwMTc2LCJuYmYiOjE2NTYzODAxNzYsImp0aSI6ImhKUnN5ekhHWFFESXBpa20iLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.M5keGqBHO6E7l4obs2U1QIwwmhPX5joAk6t15v2Psck").
                contentType(JSON).
                with().
                pathParam("commentId", 1).
                when().
                post("/comments/{commentId}");

        System.out.println(response.getBody().asString());
        JsonPath jpath = response.jsonPath();
        int code = jpath.getInt("code");
        assertEquals(code, 1000);
    }

}
