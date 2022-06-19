package tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.runners.MethodSorters;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginTest {
	
	public static String ACCESS_TOKEN;
	
	private final String JSON = "application/json";
	

	@Test
	public void Test01() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "ninhthanhvinh@gmail.com");
		request.put("password", "123456");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).extract().response();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		LinkedHashMap<String, String> data = jpath.get("data");
		
		ACCESS_TOKEN = data.get("access_token");
		assertEquals(code, 1000);
	}
	@Test
public void Test02() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "");
		request.put("password", "");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login");
		response.then().statusCode(200).toString();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1001);
		}
	@Test
	public void Test03() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "admin@gmail.com");
		request.put("password", "123456");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).extract().response();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1002);
	}
	
	@Test
	public void Test04() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "thanh12345@gmail.com");
		request.put("password", "");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).extract().response();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1002);
	}
	
	@Test
	public void Test05() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "");
		request.put("password", "123456");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).extract().response();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1001);
	}
	
	@Test
	public void Test06() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("email", "thanh12345gmail.com");
		request.put("password", "");
		
		Response response = given().contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).extract().response();
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1001);
	}
	
}


