package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetDetailsAuctionsTest {
	String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
	
	private final String JSON = "application/json";
	
	@Test 
	public void Test01() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		req.put("access_token", ACCESS_TOKEN);
		
		Response res = given().get("/auctions/detail/1");
		
		res.then().statusCode(500);
		
		System.out.println(res.getBody().asString());
		
		AssertJUnit.assertNotNull(res);
	}
}
