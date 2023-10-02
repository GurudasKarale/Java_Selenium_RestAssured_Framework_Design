package com.Utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utility.PageObjects.ItemCatalogue;
import com.Utility.PageObjects.ItemCheckout;
import com.Utility.PageObjects.LandingPage;
import org.apache.commons.io.FileUtils;


public class TestDefinitions extends BaseClass {
	
	@Test(dataProvider="getData")
	public void placeOrder(HashMap<String,String> input) throws InterruptedException {
		
        landingPage.loginToApplication("standard_user","secret_sauce");
        
        Thread.sleep(4000);
        
        ItemCatalogue itemCatalogue = new ItemCatalogue(driver);
        itemCatalogue.addToCart();

        ItemCheckout itemCheckout =new ItemCheckout(driver);
        itemCheckout.doCheckout(input.get("FirstName"),input.get("LastName"),input.get("PostalCode"));
        
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String,String> map = new HashMap();
		map.put("FirstName","aaa");
		map.put("LastName","bbb");
		map.put("PostalCode","123");
		return new Object[][] {{map}};
	}

}
