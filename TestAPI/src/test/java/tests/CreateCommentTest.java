package tests;

import static org.testng.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateCommentTest {
	Map<String, Object> map = new HashMap<String, Object>();
	
	@Test
	public void Test01() {
		
		JSONObject request = new JSONObject();
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		
		request.put("content", "Mat hang nay rat tot");
		request.put("comment_last_id", 100);
		
		Response response = given().
				header("Authorization", "bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NTU0NTY0NywiZXhwIjoxNjU1OTA1NjQ3LCJuYmYiOjE2NTU1NDU2NDcsImp0aSI6IkdSYU9GSzlDdTJ0bmVVQVUiLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.sVmnrOOTcK8uhnjAESrsSwY6vj_qoYCtwCVxa2KFyGQ").
				contentType("application/json").
			body(request.toJSONString()).
				when().
			post("/items/create/1");
		/*
		JsonPath jpath = response.jsonPath();
		assertNotEquals(jpath.getInt("code"), 1000);
		*/
		response.then().statusCode(302);
		System.out.println(response.getBody().asString());
		
	}
	
}
