package com.utilities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDef {
	
	 //public String BaseUrl;
	 //String driverPath = "C:\\Users\\Mohit K\\Desktop\\java\\cucumberSelenium\\chromedriver.exe";
	 String driverPathh ;
	 public WebDriver driver ;

	@Given("I am on {string} login page")
	public void i_am_on_login_page(String string) throws IOException,InterruptedException{
	    // Write code here that turns the phrase above into concrete actions]
		driverPathh = LoadConstants.getConfigValue("driverPath");
		System.setProperty("webdriver.chrome.driver", driverPathh);
        driver = new ChromeDriver();
        driver.get(string);
        System.out.println("on the page");
        //Thread.sleep(4000);
	}
	
	@When("I enter username as {string} and password as {string}")
	public void i_enter_username_as_and_password_as(String username, String pass) throws IOException,InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		KeywordsD.LoginStep(username, pass,driver);
	    System.out.println("Logged in");
	    
	}
	
	@Then("Add item to cart")
	public void add_item_to_cart() throws IOException,InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		KeywordsD.AddItemStep(driver);
		System.out.println("ItemAdded");
	}
	@Then("Go to cart checkout")
	public void go_to_cart_checkout() throws IOException,InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		KeywordsD.DoCheckout(driver);
		System.out.println("checkoutdone");
	}
	@Then("Fill the info and finish")
	public void fill_the_info_and_finish() throws IOException,InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		KeywordsD.Finishcheckout(driver);
		System.out.println("item bought");
	}

	
	@Then("user is logged in successfuly")
	public void user_is_logged_in_successfuly() {
	    // Write code here that turns the phrase above into concrete actions
		//driver.close();
		System.out.println("Logged in");
	}
	
	@Then("user is logged out successfuly")
	public void user_is_logged_out_successfuly() {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
		System.out.println("Logged out");
	}
	
	@After
	public void afterHook(Scenario scenario) {
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		boolean failed = scenario.isFailed();
		System.out.println("failed");
		if(failed) {
			
			byte[] screenshot = scrShot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","failurescreenshot");
		}
	}

}
