package com.weiweijin.myNoteAPI;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.weiweijin.myNoteAPI.Model.Category;
import com.weiweijin.myNoteAPI.Model.Note;

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
		Category category = new Category();
		category.setTopic("java");
		category.setCategory("language");
		int id = given()
		.contentType("application/json")
		.body(category)
		.when().post("/categories").then()
		.body("topic",equalTo("java"))
		.body("category", equalTo("language"))
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
				
		//Test Post method
		Note note = new Note();
		note.setTopic("java");
		note.setNoteText("test");
		note.setUrl("testurl");
		int id = given()
		.contentType("application/json")
		.body(note)
		.when().post("/notes").then()
		.body("topic",equalTo("java"))
		.body("noteText", equalTo("test"))
		.body("url", equalTo("testurl"))
		.extract().path("id");
				
		//Test Delete method
		given().pathParam("id",id)
		.when()
		.delete("/notes/{id}")
		.then()
		.statusCode(200);	
	}
}
