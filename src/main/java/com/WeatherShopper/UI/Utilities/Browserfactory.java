package com.WeatherShopper.UI.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserfactory {
	
	/*
	 * This function is used to do pre setup for test case where user will provide driver reference, browser name and URL.
	 * According to browser name input it will setup that specific browser with the help of WebDriverManager and open the 
	 * application for user.
	 */


	public WebDriver iniBrowser(WebDriver driver, String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver(); 
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		return driver;
	}

	/*
	 * This function will quit the browser.
	 */

	public void closeApplication(WebDriver driver) {
		driver.quit();
	}
	
	

}
