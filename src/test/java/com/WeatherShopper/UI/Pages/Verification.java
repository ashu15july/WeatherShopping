package com.WeatherShopper.UI.Pages;

/*
 * This class contains the page object of Verification page that appears once payment is done. 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Verification {
	WebDriver driver;
	
	
	public Verification(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By payment = By.xpath("/html/body/div/div[1]/h2");
	
	
	//This method will return the text of payment status.
	public String verifyPayment() {
		return driver.findElement(payment).getText();
	}
	

}
