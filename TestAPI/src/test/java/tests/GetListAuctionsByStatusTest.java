package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetListAuctionsByStatusTest {
	String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
	
	private final String JSON = "application/json";
	
	@Test 
	public void Test01() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		//req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
		when().
			post("/auctions/listAuctionsByStatus/1").
		then().
			statusCode(200);
		
		Response res = given().get("/auctions/listAuctionsByStatus/1");
		
						
		//res.then().statusCode(200);
		
		AssertJUnit.assertNotNull(res);
	}
	
	@Test 
	public void Test02() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByStatus/2");
						
		res.then().statusCode(500);
		
		AssertJUnit.assertNotNull(res);
	}
	
	@Test 
	public void Test03() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByStatus/3");
						
		res.then().statusCode(500);
		
		AssertJUnit.assertNotNull(res);
	}
	
	@Test 
	public void Test04() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByStatus/4");
						
		res.then().statusCode(500);
		
		AssertJUnit.assertNotNull(res);
	}
	
	@Test 
	public void Test05() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByStatus/5");
						
		res.then().statusCode(500);
		
		AssertJUnit.assertNotNull(res);
	}
	
	@Test 
	public void Test06() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "5");
		req.put("count", "8");
		
		Response res = given().get("/auctions/listAuctionsByStatus/6");
						
		res.then().statusCode(500);
		
		AssertJUnit.assertNotNull(res);
	}
}
