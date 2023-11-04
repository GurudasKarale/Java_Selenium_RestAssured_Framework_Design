package com.Utility.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utility.WaitUtil;

public class LandingPage extends WaitUtil {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);                             
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwrd;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement errorValid;
	
	public void goToUrl() {
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	public void loginToApplication(String usrName,String pwd) {
		
		userName.sendKeys(usrName);
		passwrd.sendKeys(pwd);
		loginButton.click();
	}
	
	public String getErrorText() {
		
		waitForWebElementToAppear(errorValid);
		//System.out.println(errorValid.getText());
		return errorValid.getText();
	}
	
	
}
