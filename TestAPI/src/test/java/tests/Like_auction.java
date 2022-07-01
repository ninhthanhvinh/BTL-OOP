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

public class Like_auction {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		Response res = given().
							header("Authorization", "bearer" + ACCESS_TOKEN). 
							contentType(JSON).
						with().
							pathParam("auctionId", 1).
						when().
							post("/updateLike/{auctionId}");
		
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
		
		assertEquals(jpath.getInt("code"), 1000);
		
	}
	
	@Test
	public void Test02() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		Response res = given().
							header("Authorization", "bearer" + ACCESS_TOKEN). 
							contentType(JSON).
						with().
							pathParam("auctionId", 2).
						when().
							post("/updateLike/{auctionId}");
		
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
		
		assertEquals(jpath.getInt("code"), 1000);
		
	}
	
	public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Like_auction.class });
        testng.addListener(tla);
        testng.run();
    }
	
}
