package tests;

import static io.restassured.RestAssured.baseURI;
import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Create_bid {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("price", 1);
		request.put("bid_last_id", "1234");
		
		Response res = given().
							header("Authorization", "bearer" + ACCESS_TOKEN).
							contentType(JSON).
							body(request.toJSONString()).
						with().
							pathParam("auctionId", 1).
						when().
							post("/bids/create/{auctionId}");
		
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
		
		assertEquals(jpath.getInt("code"), 1000);
		
	}
	
	public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Create_bid.class });
        testng.addListener(tla);
        testng.run();
    }
	
}
