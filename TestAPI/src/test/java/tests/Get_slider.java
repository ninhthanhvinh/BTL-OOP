package tests;

import static io.restassured.RestAssured.baseURI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_slider {
	Map<String, Object> map = new HashMap<String, Object>();
	private static final String JSON = "application/json";
	
	@Test
	public void Test01() {
		JSONObject request = new JSONObject();
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		Response res = given().get("/slider");
		res.then().statusCode(200);
		System.out.println(res.getBody().toString());
		
		JsonPath jpath = res.jsonPath();
		assertEquals(jpath.getInt("code"), 1000);
	}
	
	public void call(){
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { Get_slider.class });
        testng.addListener(tla);
        testng.run();
    }
	
}
