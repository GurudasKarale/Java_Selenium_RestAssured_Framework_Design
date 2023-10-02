package com.Utility.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemCatalogue {

	
	WebDriver driver;
	public ItemCatalogue(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='inventory_item']")
	List<WebElement> items;
	
	By itemTextBy = By.xpath("//div[@class='inventory_item_name']");
	
	By addToCartBtn = By.xpath("//button[@class='btn_primary btn_inventory']");
	
	public void addToCart() {
		
		  for(int i=0;i<items.size();i++) {
	        	String itemText = items.get(i).findElement(itemTextBy).getText();
	        	System.out.println(itemText);
	        	if(itemText.equals("Sauce Labs Backpack")) {
	        		items.get(i).findElement(addToCartBtn).click();
	        		break;
	        	}
	        }
		
	}
	

	
}
