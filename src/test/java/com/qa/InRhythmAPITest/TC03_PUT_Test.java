package com.qa.InRhythmAPITest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC03_PUT_Test {
	
	@Test(priority =6)
	public void PutSampleTest_01(){
		
		JSONObject req= new JSONObject();
		
		req.put("name", "morpheus");
		req.put("job", "zion resident");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().
			put("https://reqres.in/api/users/2").
			then().
			statusCode(200).
			log().all();
	}
	
	// Intentionally fail this test by giving wrong status code
	@Test(priority =7)
	public void PutSampleTest_02(){
		
		JSONObject req= new JSONObject();
		
		req.put("name", "morpheus");
		req.put("job", "zion resident");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().
			put("https://reqres.in/api/users/2").
			then().
			statusCode(205).
			log().all();
	}
}
