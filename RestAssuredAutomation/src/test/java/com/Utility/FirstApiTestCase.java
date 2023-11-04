package com.Utility;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class FirstApiTestCase {

	public static void main(String []args) {
	
		RestAssured.baseURI = "https://reqres.in/";
		
		//get 
		
		String response = given().log().all().queryParam("page",'2').header("Content-Type","application/json")
		.body("{\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":7,\"email\":\"michael.lawson@reqres.in\",\"first_name\":\"Michael\",\"last_name\":\"Lawson\",\"avatar\":\"https://reqres.in/img/faces/7-image.jpg\"},{\"id\":8,\"email\":\"lindsay.ferguson@reqres.in\",\"first_name\":\"Lindsay\",\"last_name\":\"Ferguson\",\"avatar\":\"https://reqres.in/img/faces/8-image.jpg\"},{\"id\":9,\"email\":\"tobias.funke@reqres.in\",\"first_name\":\"Tobias\",\"last_name\":\"Funke\",\"avatar\":\"https://reqres.in/img/faces/9-image.jpg\"},{\"id\":10,\"email\":\"byron.fields@reqres.in\",\"first_name\":\"Byron\",\"last_name\":\"Fields\",\"avatar\":\"https://reqres.in/img/faces/10-image.jpg\"},{\"id\":11,\"email\":\"george.edwards@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Edwards\",\"avatar\":\"https://reqres.in/img/faces/11-image.jpg\"},{\"id\":12,\"email\":\"rachel.howell@reqres.in\",\"first_name\":\"Rachel\",\"last_name\":\"Howell\",\"avatar\":\"https://reqres.in/img/faces/12-image.jpg\"}],\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}")
		.when().get("api/users")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("----------->>>>>"+response);
		
		JsonPath jsonPath = new JsonPath(response);
		String totalPages = jsonPath.getString("total_pages");
		System.out.println(totalPages);
		
		//put
		
		System.out.println("------------------->>>> Put example");
		
		String putResponse = given().log().all().body("{\"data\":{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"John\",\"last_name\":\"Weaver\",\"avatar\":\"https://reqres.in/img/faces/2-image.jpg\"},\"support\":{\"url\":\"https://reqres.in/#support-heading\",\"text\":\"To keep ReqRes free, contributions towards server costs are appreciated!\"}}")
		.when().put("api/users/2")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
		
		System.out.println(putResponse);
	}
	
	
}
