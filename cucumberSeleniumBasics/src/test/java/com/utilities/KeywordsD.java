package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywordsD {
	
	

	public static void LoginStep(String username,String pass,WebDriver driver) throws IOException,InterruptedException {
		
		WebElement userfield = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("usernamexpath")));
	    if(userfield.isDisplayed() && userfield.isEnabled()) {
	    	userfield.sendKeys(username);	
	    }
	    
	    WebElement passfield = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("passxpath")));
	    if(passfield.isDisplayed() && passfield.isEnabled()) {
	    	passfield.sendKeys(pass);	
	    }
	    
	    WebElement btnn = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("buttonxpath")));
	    if(btnn.isDisplayed() && btnn.isEnabled()) {
	    	btnn.click();	
	    }
	    StepStatus.setKeywordMap("TestCaseStatus","Pass");
	    StepStatus.setKeywordMap("TestStepStatus","Pass");
	    StepStatus.setKeywordMap("Comment","Login button is clicked");
	    
	    //Boolean buttonstatus = driver.findElement(By.xpath("//button[@class='error-button']")).isDisplayed();
	    //assertFalse(buttonstatus);
	   
	    
	    try {
	    	Boolean buttonstatus = driver.findElement(By.xpath("//button[@class='error-button']")).isDisplayed();
	    	assertFalse(buttonstatus);
	      } catch(NoSuchElementException e) {
	        
	    	  
	    	  assertFalse(false);
	      }
	    
	    Thread.sleep(4000);
	}
	
	public static void AddItemStep(WebDriver driver) throws IOException,InterruptedException {
		
		Thread.sleep(4000);
		List<WebElement> item = driver.findElements(By.xpath(LoadConstants.getPageObjectValue("item")));
		int itemNeeded=0;
		System.out.println(item.size());
		for(int i=0;i<item.size();i++) {
			
			if(item.get(i).getText().contains("Sauce Labs Backpack")) {
				itemNeeded=i;
				break;
			}
		}
		
		List<WebElement> addCart = driver.findElements(By.xpath(LoadConstants.getPageObjectValue("addtocart")));
		Thread.sleep(4000);
		addCart.get(itemNeeded).click();
		List<WebElement> itemPrice = driver.findElements(By.xpath(LoadConstants.getPageObjectValue("itemprice")));
		String itemPriceText = itemPrice.get(itemNeeded).getText();
		
		System.out.println(itemPriceText);
		
		
	}
		
	public static void DoCheckout(WebDriver driver) throws IOException,InterruptedException {
		
			Thread.sleep(4000);
			WebElement item = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("gotocart")));
			item.click();
			Thread.sleep(2000);
			WebElement chkout = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("checkout")));
			chkout.click();
				
	}
	
	public static void Finishcheckout(WebDriver driver) throws IOException,InterruptedException {
		
		MaptoStoreExcel.setTestDataMap(ReadExcel.readTheExcel("checkout"));
		WebElement firstnme = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("fname")));
		firstnme.sendKeys(MaptoStoreExcel.getTestDataMap("Name"));
		Thread.sleep(2000);
		WebElement lastnme = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("lname")));
		lastnme.sendKeys(MaptoStoreExcel.getTestDataMap("Address"));
		Thread.sleep(2000);
		WebElement pcode = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("postalcode")));
		pcode.sendKeys(MaptoStoreExcel.getTestDataMap("zip"));
		Thread.sleep(2000);
		
		WebElement infos = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("infosubmit")));
		infos.click();
		Thread.sleep(4000);
		WebElement finishS = driver.findElement(By.xpath(LoadConstants.getPageObjectValue("finish")));
		finishS.click();
			
}
	
}



