package com.Utility;

import io.restassured.path.json.JsonPath;

public class JsonPathUtil {

	
	public static void main(String []args) {
		
		JsonPath jsonPath = new JsonPath(Payload.playJsonPath());
		int count = jsonPath.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount = jsonPath.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String courseTitle = jsonPath.get("courses[0].title");
		System.out.println(courseTitle);
		
		for(int i=0;i<count;i++) {
			
			String coursesTitle = jsonPath.get("courses["+i+"].title");
			System.out.println(coursesTitle);
			System.out.println(jsonPath.get("courses["+i+"].price"));
		
		}
		
		System.out.println("------->>> print copies sold for cypress course");
		for(int i=0;i<count;i++) {
			String cypressCourseTitle = jsonPath.get("courses["+i+"].title");
			if(cypressCourseTitle.equals("Cypress")) {
				System.out.println(jsonPath.getInt("courses["+i+"].copies"));
				break;
			}
		}
	}
	
}
