package ra_program;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import Files.Payload;
import io.restassured.RestAssured;

public class AddPlace {
	
	//First Method

public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//given().log().all().queryParams("key","qaclick123")
		given().queryParams("key","qaclick123")
		.body("{\r\n"
				+ "    \"location\": {\r\n"
				+ "        \"lat\": -40.383494,\r\n"
				+ "        \"lng\": 40.427362\r\n"
				+ "    },\r\n"
				+ "    \"accuracy\": 100,\r\n"
				+ "    \"name\": \"GSIT Office\",\r\n"
				+ "    \"phone_number\": \"(+91) 983 893 0000\",\r\n"
				+ "    \"address\": \"GrowSkillIT, Chennai\",\r\n"
				+ "    \"types\": [\r\n"
				+ "        \"Office\"\r\n"
				+ "    ],\r\n"
				+ "    \"website\": \"http://www.gsit.com\",\r\n"
				+ "    \"language\": \"English-IN\"\r\n"
				+ "}").when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("status", equalTo("OK"))
		.body("scope", equalTo("APP"));
		
		
		

	}

}
