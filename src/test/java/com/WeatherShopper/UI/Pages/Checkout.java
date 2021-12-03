package com.WeatherShopper.UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
	
	WebDriver driver;
	
	public Checkout(WebDriver driver) {
		this.driver=driver;
	}
	
	private By total = By.id("total");
	private By payWithCard = By.xpath("//span[contains(text(),'Pay with Card')]");
	
	//This will return the text value of amount shown in Checkout page.
	public String totalAmount() {
		String price = driver.findElement(total).getText();
		String[] total1 = price.split(" ");
		String amount = total1[total1.length-1];
		return amount;
	}
	
	//It will click on Pay With Card button.
	public void clickOnPayWithCard() throws InterruptedException {
		driver.findElement(payWithCard).click();
		Thread.sleep(3000);
	}
}
