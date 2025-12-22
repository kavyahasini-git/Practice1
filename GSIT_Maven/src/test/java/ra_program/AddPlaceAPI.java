package ra_program;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;

	//Second Method

public class AddPlaceAPI {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//given().log().all().queryParams("key","qaclick123")
		given().queryParams("key","qaclick123")
		.body(Payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("status", equalTo("OK"))
		.body("scope", equalTo("APP"));
		
		
		

	}

}
