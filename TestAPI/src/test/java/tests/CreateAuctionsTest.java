package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class CreateAuctionsTest {
	
	Map<String, Object> map = new HashMap<String, Object>();
	String ACCESS_TOKEN = LoginTest.ACCESS_TOKEN;
	
	@Test
	public void Test01(){
		
		baseURI = "https://auction-app3.herokuapp.com/api";
		
		JSONObject request = new JSONObject();
		
		request.put("category_id", 1);
		request.put("start_date", "");
		request.put("end_date", "");
		request.put("title_ni", "Giới thiệu");
		
		/*
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime startDay = today.plusDays(1);
		LocalDateTime endDay = today.plusDays(3);
		Random rand = new Random();
		int ranNum = rand.nextInt(1000);
		String startString = startDay.format(DateTimeFormatter.ofPattern("yyyy-MM--dd HH:mm:ss"));
		String endString = endDay.format(DateTimeFormatter.ofPattern("yyyy-MM--dd HH:mm:ss"));
		LoginTest loginTest = new LoginTest();
		
		String ACCESS_TOKEN = loginTest.getAccessToken();
		
		AuctionData auctionData = new AuctionData();
		auctionData.setCateID(1);
		auctionData.setStartDate(startString);
		auctionData.setEndDate(endString);
		auctionData.setTitle("Vinhdeptrai" + ranNum);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(auctionData);
		System.out.println(jsonString);
		*/
		Response response = given().header("Authorization", "bearer" + ACCESS_TOKEN). 
				contentType(ContentType.JSON).
			body(request.toJSONString()).
				when().
			post("/auctions/create");
		response.then().statusCode(200);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	
	}
}