package com.mortegagecalculator.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.selenium.commons.Configuration;


public class TestngAnnotationsTest{

	public WebDriver driver = Configuration.browser();


	@BeforeClass(alwaysRun=true)
	public void invokeURL(){
		driver.get(Configuration.LoginURL());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	


	@AfterMethod(alwaysRun = true)
	public void HomePage() {

	}


	@AfterSuite(alwaysRun = true)
	public void CloseBrowser() {


		driver.quit();

	}
}
