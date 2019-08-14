package com.weiweijin.myNoteAPI;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.given;
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
	public void testCategoryController() {
		//Test GET method
		given()
		.when()
		.get("/categories")
		.then()
		.statusCode(200);	
		
		//Test Post method
		Map<String, String> category = new HashMap<>();	
		category.put("topic","junit");
		category.put("category","testing");
		int id = given()
		.contentType("application/json")
		.body(category)
		.when().post("/categories").then()
		.body("topic",equalTo("junit"))
		.body("category", equalTo("testing"))
		.extract().path("id");
		
		//Test Delete method
		given().pathParam("id",id)
		.when()
		.delete("/categories/{id}")
		.then()
		.statusCode(200);				
	}
	
	@Test
	public void testNoteController() {
		//Test GET method
				given()
				.when()
				.get("/notes")
				.then()
				.statusCode(200);	
				
//				//Test Post method
//				Map<String, String> n = new HashMap<>();	
//				category.put("topic","junit");
//				category.put("category","testing");
//				int id = given()
//				.contentType("application/json")
//				.body(category)
//				.when().post("/notes").then()
//				.body("topic",equalTo("junit"))
//				.body("category", equalTo("testing"))
//				.extract().path("id");
//				
//				//Test Delete method
//				given().pathParam("id",id)
//				.when()
//				.delete("/notes/{id}")
//				.then()
//				.statusCode(200);	
	}
}
