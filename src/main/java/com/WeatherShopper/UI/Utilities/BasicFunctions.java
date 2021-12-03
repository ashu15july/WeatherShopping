package com.WeatherShopper.UI.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasicFunctions {
	
	WebDriver driver;
	
	public BasicFunctions(WebDriver driver) {
		this.driver = driver;
		
	}
	
	/*
	 * This function will select the least expensive products based on the name sent in argument.Then, it will fetch the 
	 * the cost of that product and compare it variable already defined with very high cost. This comparison will
	 * return the cheap price from all the products selected with specific name. Then this function will look 
	 * for the product with least price and specific name and add it into the cart.
	 */
	public void selectLeastExpensiveItem(String item) {
		
		List<WebElement> ele = driver.findElements(By.xpath("//p[contains(text(),'"+item+"')]/following-sibling::p"));
		int leastPrice=10000;
		for(WebElement lm:ele) {
			String value = lm.getText();
			String[] price = value.split(" ");
			if((leastPrice)>(Integer.valueOf(price[price.length-1]))) {
				leastPrice=Integer.valueOf(price[price.length-1]);
			}
		}
		driver.findElement(By.xpath("//p[contains(text(),'"+item+"')]/following-sibling::p[contains(text(),'"+leastPrice+"')]/following-sibling::button")).click();

	}
	
	

}
