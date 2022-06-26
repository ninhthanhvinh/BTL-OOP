package tests;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetListAuctionsByUserTest {
	public static String ACCESS_TOKEN;
	
	private final String JSON = "application/json";
	
	@Test
	public void Test_01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByUser/1");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
	@Test
	public void Test_02() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", null);
		request.put("index", "");
		request.put("count", "");
		
		Response res = given().get("/auctions/listAuctionsByUser/2");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
	@Test
	public void Test_03() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", null);
		request.put("index", "5");
		request.put("count", "");
		
		Response res = given().get("/auctions/listAuctionsByUser/3");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
	@Test
	public void Test_04() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "");
		request.put("count", "");
		
		Response res = given().get("/auctions/listAuctionsByUser/3");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
	@Test
	public void Test_05() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByUser/4");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
	@Test
	public void Test_06() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", null);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByUser/4");
		res.then().statusCode(200);
		
		System.out.println(res.getBody().asString());
		JsonPath jpath = res.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, Double.valueOf(1004));
		
		//System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
	}
	
}
