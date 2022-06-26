package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

import java.util.LinkedHashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetListAuctionsByTypeTest {
	public static String ACCESS_TOKEN;
	//String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
	private final String JSON = "application/json";
	

	@Test
	public void Test_01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctions/1");
		
		res.then().statusCode(404);
		
		System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	@Test
	public void Test_02() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctions/2");
		
		res.then().statusCode(404);
		
		System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	@Test
	public void Test_03() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctions/3");
		
		res.then().statusCode(404);
		
		System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	@Test
	public void Test_04() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctions/4");
		
		res.then().statusCode(404);
		
		System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	@Test
	public void Test_05() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "5");
		request.put("count", "8");
		
		Response res = given().get("/auctions/listAuctions/5");
		
		res.then().statusCode(404);
		
		System.out.println(res.getStatusCode());
		AssertJUnit.assertNotNull(res);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
}