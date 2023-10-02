package com.Utility;

import org.testng.Assert;
import org.testng.annotations.Test;

public class errorValidationsTests extends BaseClass {
	
	@Test  //(groups= {"ErrorHandling"})
	public void loginValidation() {
		
		landingPage.loginToApplication("standard_user","secret_sauc");
		System.out.println("----------------->>>>>>>>>>>");
		System.out.println(landingPage.getErrorText());
		Assert.assertEquals("Incorrect","Incorrec");
		
		
	}
	

}
