package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public class GetListAuctionsTest {
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	
	
	private final String JSON = "application/json";

	
	@Test 
	public void Test01() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		Response res = given().when().
			get("/auctions");
		res.then().statusCode(200);
			
	}
	
}
