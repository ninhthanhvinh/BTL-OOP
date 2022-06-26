package tests;

import org.testng.annotations.Test;
import java.util.HashMap;
import org.apache.commons.lang3.RandomStringUtils;
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
	
	@Test
	public void Test02() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "");
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
	
	@Test
	public void Test03() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "123456");
		req.put("re_pass", "123457");
		req.put("address", "ThuyDan");
		req.put("name", "vinh");
		req.put("phone", "090");
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
	}
	
	@Test
	public void Test04() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "");
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
	
	@Test
	public void Test05() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "123456");
		req.put("re_pass", "");
		req.put("address", "ThuyDan");
		req.put("name", "vinh");
		req.put("phone", "090");
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
	}
	
	@Test
	public void Test06() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "123456");
		req.put("re_pass", "123456");
		req.put("address", "ThuyDan");
		req.put("name", "");
		req.put("phone", "090");
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
	}
	
	@Test
	public void Test07() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		req.put("email", "ninhthanhvinh@gmail.com");
		req.put("password", "123456");
		req.put("re_pass", "123456");
		req.put("address", "ThuyDan");
		req.put("name", "vinh");
		req.put("phone", "");
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
	}
	
	@Test
	public void Test08() {
		
		JSONObject req = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		//String pass = RandomStringUtils.randomAlphanumeric(8);
		
		req.put("email", /*RandomStringUtils.randomAlphanumeric(10) +*/ "ntv@gmail.com");
		req.put("password", /*pass*/ "123456");
		req.put("re_pass", /*pass*/ "123456");
		req.put("address", RandomStringUtils.randomAlphanumeric(30));
		req.put("name", RandomStringUtils.randomAlphanumeric(10));
		req.put("phone", RandomStringUtils.randomNumeric(10));
		req.put("avatar", null);
		
		Response res = given().contentType(JSON).body(req.toJSONString()).when().post("/signup");
		
		System.out.println(res.getBody().asString());
		
		JsonPath jpath = res.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1001);
	}
	
	
}
