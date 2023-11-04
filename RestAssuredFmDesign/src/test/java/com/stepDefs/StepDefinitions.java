package com.stepDefs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.AddPlace;
import com.pojo.Location;
import com.testData.APIresources;
import com.testData.TestDataRepository;
import com.testData.Utils;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitions extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	TestDataRepository testRepository = new TestDataRepository();
	JsonPath js;
	static String place_id;
	
	@Given("Add place Api payload {string} {string} {string}")
	public void add_place_api_payload(String name, String language, String address) throws IOException {
	    System.out.println("payload is ready");
	     
	    
	    res=given().spec(requestSpecificatonsUtil())
	    .body(testRepository.addPlacePayload(name,language,address));

	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		System.out.println("post the payload");
		
		
		APIresources apiResource = APIresources.valueOf(resource);
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpMethod.equalsIgnoreCase("POST"))
		{response =res.when().post(apiResource.getResource()).
			    then().spec(resspec).extract().response();
		}
		else if(httpMethod.equalsIgnoreCase("GET")){
			response =res.when().get(apiResource.getResource()).
				    then().spec(resspec).extract().response();
		}
		
	}
	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		System.out.println("api is hit and response is received");
		
		 assertEquals(response.getStatusCode(),200);
		
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		System.out.println("verify response");
		
		String responseString=response.asString();
		js = new JsonPath(responseString);
		assertEquals(js.get(key).toString(),value);
		
	}
	
	@Then("place_id created maps to {string} using {string}")
	public void place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
	    
		place_id = js.get("place_id").toString();
		res=given().spec(requestSpecificatonsUtil())
		.queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
		String responseStringGetPlace=response.asString();
		js = new JsonPath(responseStringGetPlace);
		String actualName = js.get("name").toString();
		assertEquals(actualName,expectedName);
	}
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {
	    
		res = given().spec(requestSpecificatonsUtil()).body(testRepository.deletePlacePayload(place_id));
		
		
		
	}


}
