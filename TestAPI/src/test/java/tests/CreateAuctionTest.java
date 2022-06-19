package tests;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.time.*;

public class CreateAuctionTest {
	
	Map<String, Object> map = new HashMap<String, Object>();
	
	@Test
	public void Test01() {
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject request = new JSONObject();
		
		request.put("category_id", 1000);
		request.put("start_date", "");
		request.put("end_date", "");
		request.put("title_ni", "Giới thiệu");
		
		Response response = given().header("Authorization", "bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NTU0NTY0NywiZXhwIjoxNjU1OTA1NjQ3LCJuYmYiOjE2NTU1NDU2NDcsImp0aSI6IkdSYU9GSzlDdTJ0bmVVQVUiLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.sVmnrOOTcK8uhnjAESrsSwY6vj_qoYCtwCVxa2KFyGQ").
				contentType("application/json").
			body(request.toJSONString()).
				when().
			post("/items/create/1");
		System.out.println(response.getBody().asString());
	
}
