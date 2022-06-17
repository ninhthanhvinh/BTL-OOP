package tests;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotEquals;

public class SignUpTest {
		Map<String, Object> map = new HashMap<String, Object>();
		
		private final String JSON = "application/json";
		
		
	@Test
	public void Test01() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "123456");
		req.put("re_pass", "123456");
		req.put("address", "ThuyDan");
		req.put("name", "vinh");
		req.put("phone", "090");
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
	}
}
