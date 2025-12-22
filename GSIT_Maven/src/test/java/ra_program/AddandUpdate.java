package ra_program;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddandUpdate {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//given().log().all().queryParams("key","qaclick123")
		String response = given().queryParams("key","qaclick123")
		.body(Payload.addPlace()).when().post("maps/api/place/add/json")
		.then().log().all().statusCode(200).body("status", equalTo("OK"))
		.body("scope", equalTo("APP")).extract().asString();
		
		//This is for complete response
		System.out.println(response);
		
		//Suppose we want to fetch any particular field value.(you can use any field you want)
		JsonPath js = new JsonPath(response);
		
		String pid = js.getString("place_id");
		System.out.println(pid);
		
		//Update Place - we should update pid
		given().queryParam("key", "qaclick123").queryParam("place_id", pid)
		.body("{\r\n"
				+ "\"place_id\":\""+pid+"\",\r\n"
				+ "\"address\":\"GrowskillIT Bangalore\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().log().all().statusCode(200)
				.body("msg", equalTo("Address successfully updated")); //To valid the message received. we can add this if we want to check the message
				
		//Get API
		String getResponse = given().queryParam("key", "qaclick123").queryParam("place_id", pid)
		    .when().get("maps/api/place/get/json")
		    .then().assertThat().statusCode(200).extract().response().asString();

		System.out.println(getResponse);
		
		JsonPath jadd = new JsonPath(getResponse);
		String actualAddress = jadd.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, "GrowskillIT Bangalore");
		
		// We can create reusable method for Jsonpath and can reuse it instead of creating object in every steo. Check in class dated 11/27
		
		/* DELETE Place API
		given().queryParam("key", "qaclick123")
		    .header("Content-Type", "application/json")
		    .body("{\n"
		            + "\"place_id\":\"" + pid + "\"\n"
		            + "}")
		.when()
		    .delete("maps/api/place/delete/json")
		.then()
		    .statusCode(200)
		    .body("status", equalTo("OK")); */
	}

}
