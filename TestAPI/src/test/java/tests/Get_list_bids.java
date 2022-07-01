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

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_list_bids {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		Response res = given().
							contentType(ContentType.JSON).
						with().
							pathParam("auctionId", 1).
							queryParam("index", "1").
							queryParam("count", "2").
						when().
							get("/bids/{auctionId}");
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
		
		assertEquals(jpath.getInt("code"), 1000);
	}
	
	public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Read_new.class });
        testng.addListener(tla);
        testng.run();
    }
	
}
