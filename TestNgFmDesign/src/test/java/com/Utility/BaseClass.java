package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Utility.PageObjects.LandingPage;

public class BaseClass {

	
	public WebDriver driver ;
	LandingPage landingPage;
	
	public WebDriver initializeDriver() {
		
		
		String driverPath = "C:\\Users\\Mohit K\\Desktop\\java\\cucumberSelenium\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        return driver;
        
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() {
		
		driver = initializeDriver();
		 landingPage = new LandingPage(driver);
	     landingPage.goToUrl();
	     return landingPage;
	     //landingPage.loginToApplication("standard_user","secret_sauce");
		
	}
	
	public String getScreenshot(String testCaseName,WebDriver superDriver) throws IOException {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)superDriver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		
		driver.close();
	}
	
}
