package com.weiweijin.myNoteAPI;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

public class MyNoteApiApplicationTests {

	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}
	
	@Test
	public void testSetup() {
		String str = "I am done with Junit setup";
		assertEquals("I am done with Junit setup", str);
	}
	
	@Test
	public void testCategoriesFetchesSuccess() {
		get("/categories")
		.then()
		.statusCode(200);
	}
	

}
