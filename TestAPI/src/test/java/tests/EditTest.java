package tests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class EditTest {
		
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void TestCase01() {
		
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		String ACCESS_TOKEN =
	
		"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NTUyMDk5NiwiZXhwIjoxNjU1ODgwOTk2LCJuYmYiOjE2NTU1MjA5OTYsImp0aSI6InljZHFCUDJEUk52S29BWDgiLCJzdWIiOjU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.aq-TBj-8ZDkt8l4TukjLlMGGBwzGCDnSV4YATED5WRs";
		
		request.put("email", "ninhvinh1@gmail.com");
		request.put("password", "123456");
		request.put("re_pass", "123456");
		request.put("address", "MyAddress");
		request.put("name", "MyName");
		request.put("phone", "09090909090");
		request.put("avatar", null);
		
		Response response = given().
								header("Authorization","Bearer" + ACCESS_TOKEN).
							contentType(JSON).
								body(request.toJSONString()).
							when().
								post("/edit");
		
		System.out.println(response.getBody().asString());
		
		response.then().statusCode(200);
		
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		assertEquals(code, 1000);
		
	}
}
