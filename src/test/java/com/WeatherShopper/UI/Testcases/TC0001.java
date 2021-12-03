package com.WeatherShopper.UI.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.WeatherShopper.UI.Pages.Cart;
import com.WeatherShopper.UI.Pages.Checkout;
import com.WeatherShopper.UI.Pages.HomePage;
import com.WeatherShopper.UI.Pages.Stripe;
import com.WeatherShopper.UI.Pages.Verification;
import com.WeatherShopper.UI.Utilities.BasicFunctions;
import com.WeatherShopper.UI.Utilities.Browserfactory;

public class TC0001 {
	
	WebDriver driver;
	Browserfactory brs;
	BasicFunctions bfs;
	HomePage home;
	Checkout check;
	Cart ct;
	Stripe sp;
	Verification vf;
	JavascriptExecutor jse;
	
	String url = "https://weathershopper.pythonanywhere.com/";
	String email = "Test@Test.com";
	String card = "4242424242424242";
	String exp = "11/23";
	String cvc = "123";
	String zip = "123456";
	String msg = "PAYMENT SUCCESS";
	
	
	/*
	 * Here the parameters annotation will read the value of browser from Testng.xml file. And beforetest annotation
	 * will be used to do presetup before the real execution starts.
	 * 
	 */
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) {
		brs = new Browserfactory();
		driver = brs.iniBrowser(driver, browser, url);		
	}
	
	/*
	 * This is main test case. It will be executed parallely on the basis of browser values passed in testng.xml file.
	 * Currently it will be executed in Chrome and Edge browser.
	 */
	@Test
	public void endToEndTest() throws InterruptedException {
		home = new HomePage(driver);
		check = new Checkout(driver);
		ct = new Cart(driver);
		sp = new Stripe(driver,jse);
		vf = new Verification(driver);
		bfs = new BasicFunctions(driver);
		jse = (JavascriptExecutor)driver;
		
		//Fetch the temperature from application.
		int temp = home.getTemperature();
		//Go to if loop if temp is less than 19' c.
		if(temp<19) {
			//click on buy moisturizers.
			home.buyMoisturizers();
			//Add least expensive moisturizers into cart having Aloe in name.
			bfs.selectLeastExpensiveItem("Aloe");
			//Add least expensive moisturizers into cart having Almond in name.
			bfs.selectLeastExpensiveItem("Almond");
			
		}
		else if(temp>34) {
			//Click on buy sunscreens.
			home.buySunscreens();
			//Add least expensive Sunscreen into cart having SPF-50 in name.
			bfs.selectLeastExpensiveItem("SPF-50");
			//Add least expensive Sunscreen into cart having SPF-30 in name.
			bfs.selectLeastExpensiveItem("SPF-30");
		}
		else {
			System.out.println("Temperature is not suitable enough to select either moisturizers or sunscreens.");
		}
		//Go to cart.
		ct.clickOnCart();
		//Pick the total amount shown in cart.
		String TotalAmountInCart = check.totalAmount();
		//Click on Pay with card button.
		check.clickOnPayWithCard();
		//Switch to Stripe payment popup.
		sp.switchToStripe();
		//Provide emailid.
		sp.sendEmail(email);
		//Provide card number.
		sp.sendCardNumber(jse,card);
		//Provide CVC number.
		sp.sendCVC(cvc);
		//Provide card expiry detail.
		sp.sendExpiryDetail(jse,exp);
		//Provide ZIP code.
		sp.sendZip(zip);
		//Fetch the amount shown in stripe payment pop up.
		String TotalAmountInStripe = sp.amountToBePaid();
		//Verify the amount picked up from checkout page is same as amount shown in stripe.
		AssertJUnit.assertEquals(true, sp.isAmountEqual(TotalAmountInCart, TotalAmountInStripe));
		//Click on submit.
		sp.clickOnSubmit();
		//Verify payment is successful.
		AssertJUnit.assertEquals(msg, vf.verifyPayment());
		
	}
	
	//Once the execution is completed, quit the browser.
	@AfterTest
	public void tearDown() {
		brs.closeApplication(driver);
		
	}

}
