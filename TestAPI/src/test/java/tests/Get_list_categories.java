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

public class Get_list_categories {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		Response res = given().
							contentType(JSON).
						with().
							pathParams("data", "categories").
						when().
							get("/categories/{data}");
		res.then().statusCode(200);
		
		JsonPath jpath = res.jsonPath();
		
		LinkedHashMap<String, String> data = jpath.get("data");
		
		System.out.println(data);
		
	}
}
