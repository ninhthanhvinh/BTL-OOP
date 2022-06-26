package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Examples {

	@Test 
	void test_01() {
		
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getBody().asString());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		
		int statusCode = res.getStatusCode();
		
		AssertJUnit.assertEquals(statusCode, 200);
		
	}
	
}
