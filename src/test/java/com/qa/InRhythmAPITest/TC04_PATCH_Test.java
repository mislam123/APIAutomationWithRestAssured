package com.qa.InRhythmAPITest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC04_PATCH_Test {
	
	@Test(priority =8)
	public void PatchSampleTest_01(){
		
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
			patch("https://reqres.in/api/users/2").
			then().
			statusCode(200).
			log().all();
	}
	
	// Intentionally fail this test by giving wrong status code
	@Test(priority =9)
	public void PatchSampleTest_02(){
		
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
			patch("https://reqres.in/api/users/2").
			then().
			statusCode(204). //wrong status code
			log().all();
	}
}
