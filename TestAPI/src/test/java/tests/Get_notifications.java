package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_notifications {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		LoginTest loginTest = new LoginTest();
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		request.put("access_token", ACCESS_TOKEN);
		request.put("index", "2");
		request.put("count", "2");
		
		given().
			header("Authorization", "bearer" + ACCESS_TOKEN).
			contentType(JSON).
			body(request.toJSONString()).
		when().
			post("/notifications");
		Response res = given().get("/notifications");
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		LinkedHashMap<String, String> data = jpath.get("data");
		System.out.println(data);
		
	}
}
