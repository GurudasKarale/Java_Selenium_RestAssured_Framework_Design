package com.Utility;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;


public class OauthAutomation {

	
	public static void main(String []args) {
		
		
		//to get authorization code - https://api.imgur.com/oauth2/authorize
		//to get  token - https://api.imgur.com/oauth2/token
		//generate client id - https://api.imgur.com/oauth2/addclient
		
//		given()
//		.queryParam("client_id","05db23d087540dd")
//		.queryParam("client_secret","362e81808524451629458fcedf61944af37972e1")
//		.queryParam("redirect_uri","https://oauth.pstmn.io/v1/callback")
//		.queryParam("grant_type","authorization_code")
//		.when().log().all()
//		.post("https://api.imgur.com/oauth2/token").asString();
		
		
		
		String token = "925423766fc68861d308b5d448fafc8bb04ab754";
		
//		String response =  given().queryParam("access_token",token)
//		.when()
//		.get("https://api.imgur.com/3/account/me/images").asString();
		
		String response =  given().auth().oauth2(token)
				.when()
				.get("https://api.imgur.com/3/account/me/images").asString();
		System.out.println(response);
		
	}
	
}
