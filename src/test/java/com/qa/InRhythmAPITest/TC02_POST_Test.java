package com.qa.InRhythmAPITest;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC02_POST_Test {
	
	@Test(priority =4)
	public void PostSampleTest_01(){
		
		JSONObject req= new JSONObject();
		
		req.put("name", "morpheus");
		req.put("job", "leader");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201).
			log().all();
	
	
	}
	
	// Intentionally fail this test by giving wrong status code
	@Test(priority =5)
	public void PostSampleTest_02(){
		
		JSONObject req= new JSONObject();
		
		req.put("name", "morpheus");
		req.put("job", "leader");
		
		System.out.println(req);
		System.out.println(req.toJSONString());
	
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(req.toJSONString()).
			when().
			post("https://reqres.in/api/users").
		then().
			statusCode(200). //wrong status code
			log().all();
	}
}
