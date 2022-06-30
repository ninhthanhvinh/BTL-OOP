package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
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
		
		req.put("index", "2");
		req.put("count", "5");
		
		given().header("Authorization", "bearer" + ACCESS_TOKEN).
			contentType(JSON).
			body(req.toJSONString()).
		when().
			post("/auctions"). 
		then().
			statusCode(200);
		
		Response res = given().get("/auctions");
		//res.then().statusCode(200);
		System.out.println(res.getStatusCode());
		assertNotNull(res);
		
	}
	
}

