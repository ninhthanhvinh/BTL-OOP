package tests;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


public class GetListAuctionsTest {
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
	
	
	private final String JSON = "application/json";

	
	@Test 
	public void Test01() {
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject req = new JSONObject();
		
		req.put("access_token", ACCESS_TOKEN);
		req.put("index", "2");
		req.put("count", "5");
		
		Response res = given().
						contentType(JSON).
				       body(req.toJSONString()).
				       	when().
				       post("/auctions");
		res.then().statusCode(200);
		System.out.println(res.getStatusCode());
		assertNotNull(res);
		
	}
	
}
