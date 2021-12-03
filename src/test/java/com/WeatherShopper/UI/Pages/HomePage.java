package com.WeatherShopper.UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	private By temp  = By.id("temperature");
	private By moist = By.xpath("//button[contains(text(),'Buy moisturizers')]");
	private By suns  = By.xpath("//button[contains(text(),'Buy sunscreens')]");

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	//This will return temperature value from home page.
	public int getTemperature() {
		String temperature = driver.findElement(temp).getText();
		String[] vals = temperature.split(" ");
		int temp = Integer.valueOf(vals[0]);
		return temp;

	}

	//It will click on By moisturizers button.
	public void buyMoisturizers() {
		driver.findElement(moist).click();

	}

	//It will click on By suncscreens button.
	public void buySunscreens() {
		driver.findElement(suns).click();

	}
}
