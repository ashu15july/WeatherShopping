package com.WeatherShopper.UI.Testcases;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		testng.setTestClasses(new Class[] { TC0001.class });
		testng.addListener(tla);
		testng.run();


	}

}
