package com.Utility.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemCheckout {

	WebDriver driver;
	public ItemCheckout(WebDriver driver) {
		//super(driver);                             send driver to parent class waitutility
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='shopping_cart_link fa-layers fa-fw']")
	WebElement cartBtn;
	
	@FindBy(xpath="//a[@class='btn_action checkout_button']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//input[@id='first-name']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement lname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy(xpath="//input[@class='btn_primary cart_button']")
	WebElement detailsCheckoutBtn;
	
	@FindBy(xpath="//a[@class='btn_action cart_button']")
	WebElement placeOrderBtn;
	
	
	public void doCheckout(String firstName,String lastName,String postalCod){
		
		cartBtn.click();
		checkoutBtn.click();
		fname.sendKeys(firstName);
		lname.sendKeys(lastName);
		postalCode.sendKeys(postalCod);
		detailsCheckoutBtn.click();
		placeOrderBtn.click();
		
	}
	
	
}
