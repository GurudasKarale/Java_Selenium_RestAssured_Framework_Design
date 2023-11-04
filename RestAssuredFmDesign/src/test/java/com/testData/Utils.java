package com.testData;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	
	public RequestSpecification requestSpecificatonsUtil() throws IOException {
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		//RestAssured.baseURI="https://rahulshettyacademy.com";

	    req =new RequestSpecBuilder().setBaseUri(getConfigProperties("baseUrl")).addQueryParam("key", "qaclick123")
	    .addFilter(RequestLoggingFilter.logRequestTo(log))
	    .addFilter(ResponseLoggingFilter.logResponseTo(log))
	    		.setContentType(ContentType.JSON).build();
	    
	    return req;
		}
		return req;
	}
	
	public String getConfigProperties(String key) throws IOException {
		
		Properties  prop = new Properties();
		FileInputStream fis = new FileInputStream("F:\\java_ee\\RestAssuredFmDesign\\src\\test\\java\\com\\testData\\config.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	
}
