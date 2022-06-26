package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class EditAuctionsTest {
	Map<String, Object> map = new HashMap<String, Object>();
	
	private final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NTUyMDk5NiwiZXhwIjoxNjU1ODgwOTk2LCJuYmYiOjE2NTU1MjA5OTYsImp0aSI6InljZHFCUDJEUk52S29BWDgiLCJzdWIiOjU3LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.aq-TBj-8ZDkt8l4TukjLlMGGBwzGCDnSV4YATED5WRs";
		
		request.put("category_id", 10);
		request.put("start_date", 1);
		request.put("end_date", 5);
		request.put("title", "DauGia");
		
		Response response = given().
				header("Authorization", "bearer" + ACCESS_TOKEN). 
				contentType(JSON).
			body(request.toJSONString()).
				when().
			post("/auctions/edit/1");
		response.then().statusCode(302);
		
		System.out.println(response.getBody().asString());
		
		/*
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		AssertJUnit.assertEquals(code, 1000);
		*/
	}
}
