package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Read_notifications {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
							contentType(JSON).
						with().
							pathParam("auctionDenyld", 1).
						when().
								get("/notifications/read/{auctionDenyld}");
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	
	@Test
	public void Test02() {
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		Response res = given().header("Authorization", "bearer" + ACCESS_TOKEN).
							contentType(JSON).
						with().
							pathParam("auctionDenyld", 2).
						when().
								get("/notifications/read/{auctionDenyld}");
		res.then().statusCode(200);
		System.out.println(res.getStatusCode()); //code = 404
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
	}
	
	public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Read_notifications.class });
        testng.addListener(tla);
        testng.run();
    }
}
