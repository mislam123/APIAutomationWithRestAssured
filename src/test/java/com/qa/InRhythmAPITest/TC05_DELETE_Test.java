package com.qa.InRhythmAPITest;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class TC05_DELETE_Test {
	
	@Test(priority =10)
	public void DeleteSampleTest_01(){
		
		given().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();

	}
	
	// Intentionally fail this test by giving wrong status code
	@Test(priority =11)
	public void DeleteSampleTest_02(){
		
		given().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(202).
			log().all();

	}
}
