package tests;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LogOutTest {
	
	String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9hdWN0aW9uLWFwcDMuaGVyb2t1YXBwLmNvbVwvYXBpXC9sb2dpbiIsImlhdCI6MTY1NTUzNzg2OSwiZXhwIjoxNjU1ODk3ODY5LCJuYmYiOjE2NTU1Mzc4NjksImp0aSI6InJuejdrMHhSQmNUTHB2TnkiLCJzdWIiOjY1LCJwcnYiOiIyM2JkNWM4OTQ5ZjYwMGFkYjM5ZTcwMWM0MDA4NzJkYjdhNTk3NmY3In0.sX-pWrwDyGfCIhlqy_1huxTt3GSElXrQtnpKV53q4BM";
	@Test
	public void Test01() {
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		Response response = given().
								header("Authorization", "bearer" + ACCESS_TOKEN).
							contentType("application/json").
								when().
							post("/logout");
		response.then().statusCode(200);
		System.out.println(response.getBody().asString());
		JsonPath jpath = response.jsonPath();
		int code = jpath.getInt("code");
		System.out.println(code);
		assertNotEquals(code, 1000);
		
	}
		
}
