package com.WeatherShopper.UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Stripe {

	WebDriver driver;
	JavascriptExecutor jse;

	public Stripe(WebDriver driver, JavascriptExecutor jse) {
		this.driver=driver;
		this.jse=jse;
	}

	private By email = By.id("email");
	private By cvc = By.id("cc-csc");
	private By amount = By.xpath("//span[contains(text(),'Pay INR')]");
	private By zip = By.id("billing-zip");
	private By submit = By.id("submitButton");

	//This methid will let user switch to Stripe pop up.
	public void switchToStripe() {

		driver.switchTo().frame(0);
	}
	
	//It will enter email in Stripe pop up.
	public void sendEmail(String args) {
		driver.findElement(email).sendKeys(args);
	}
	
	//It will enter card number in Stripe pop up.
	public void sendCardNumber(JavascriptExecutor jse, String card) throws InterruptedException {

		jse.executeScript("document.getElementById('card_number').value='"+card+"';");
		Thread.sleep(3000);

	}

	//It will enter expiry number in Stripe pop up.
	public void sendExpiryDetail(JavascriptExecutor jse,String args) throws InterruptedException {

		jse.executeScript("document.getElementById('cc-exp').value='"+args+"';");
		Thread.sleep(2000);
	}

	//It will enter cvc in Stripe pop up.
	public void sendCVC(String args) {
		driver.findElement(cvc).sendKeys(args);
	}
	
	//It will enter zip in Stripe pop up.
	public void sendZip(String args) {
		driver.findElement(zip).sendKeys(args);
	}
	
	//This will return the text value of amount shown in stripe pop up.
	public String amountToBePaid() {
		String finaltotal = driver.findElement(amount).getText();
		String[] total2 = finaltotal.split(" ");
		String button = total2[total2.length-1];
		return button;
	}
	
	//It will click on Pay button.
	public void clickOnSubmit() throws InterruptedException {
		driver.findElement(submit).click();
		Thread.sleep(5000);
	}
	
	//This method will compare the amount and return the result in boolean.
	public boolean isAmountEqual(String expected, String actual) {
		if(actual.contains(expected)) {
			return true;
		}
		else {
			return false;

		}
	}
}
