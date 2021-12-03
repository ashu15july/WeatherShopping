package com.WeatherShopper.UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		this.driver=driver;
	}
	
	private By cart = By.xpath("//button[@onclick='goToCart()']");
	
	//This will click on cart button.
	public void clickOnCart() {
		driver.findElement(cart).click();		
	}
	

}
