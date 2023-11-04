package com.ecomAutomation;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import java.io.File;

public class APITest {
	
	
	public static void main(String [] args) {
		
		RequestSpecification req =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON)
		.build();
		
		LoginRequestPojo loginReq = new LoginRequestPojo();
		loginReq.setUserEmail("");
		loginReq.setUserPassword("");
		
		
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginReq);
		LoginResponsePojo loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().log().all().extract().response().as(LoginResponsePojo.class);
		System.out.println(loginResponse.getToken());
		String token = loginResponse.getToken();
		System.out.println(loginResponse.getUserId());
		String userId = loginResponse.getUserId();
		
		//Add product
		
		RequestSpecification addProductReq =  new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization",token)
				.build();
		RequestSpecification createProductReq = given().log().all().spec(addProductReq).param("productName","laptop")
		.param("productAddedBy",userId)
		.param("productCategory","fashion")
		.param("productSubCategory","shirts")
		.param("productPrice","11500")
		.param("productDescription","Addias Originals")
		.param("productFor","women")
		.multiPart("productImage",new File("C://Users//Mohit K//Downloads//testing.jpg"));
		
		String createProductResponse = createProductReq.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		
		JsonPath js = new JsonPath(createProductResponse);
		String productId = js.get("productId");
		System.out.println(productId);
		
	}
	

}
