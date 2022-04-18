package com.qa.InRhythmAPITest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC01_GET_Test {
	
	@Test(priority =1)
	public void GetSampleTest_01(){
		
		given().get("https://reqres.in/api/users").then().statusCode(200);
		
	}
	
	// Intentionally fail this test by giving wrong status code
	@Test(priority =2)
	public void GetSampleTest_02(){
		
		given().get("https://reqres.in/api/users").then().statusCode(201);
		
	}
	
	// we can have more info like below test
	@Test(priority =3)
	public void GetSampleTest_03(){
		
		Response res = get("https://reqres.in/api/users?page=2");
		System.out.println(res.asString());
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());
		System.out.println(res.getStatusLine());
		System.out.println(res.getHeader("content-type"));
		System.out.println(res.getTime());
		Assert.assertEquals(res.statusCode(), 200);
		
	}

}
