package com.selenium.commons;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class Configuration {

	public static Properties properties = new Properties(); // Here we imported
															// Java.util

	public static String filepath;
	public static FileInputStream in;
	public static String URL;
	
	public static String Browser;
	public static  WebDriver driver;	
	

	public static WebDriver browser() {

		if (Browser.equalsIgnoreCase("Firefox")) {
			if(driver==null)
			driver = new FirefoxDriver();
			else 
				return driver;
			
		}
		
		else if (Browser.equalsIgnoreCase("ie")) {
			if(driver==null){
			String filepath = "src/test/resources/IEDriverServer.exe";
			filepath = System.getProperty("user.dir") + "/" + filepath;
			File file = new File(filepath);
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
			}
			else 
				return driver;

			
		}
		else if (Browser.equalsIgnoreCase("chrome")) {
			if(driver==null){
			String filepath = "src/test/resources/chromedriver.exe";
			filepath = System.getProperty("user.dir") + "/" + filepath;
			File file = new File(filepath);
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());

			driver = new ChromeDriver();
			}
			else 
				return driver;
		}
		else if (Browser.equalsIgnoreCase("safari")) {
			if(driver==null)
			driver = new SafariDriver();
			return driver;
		}
		return driver;
	

	}

	static {
		try {
			 if (System.getProperty("EnvType")==null) {
				filepath = "src/test/resources/QA-environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + "/"
						+ filepath);
				properties.load(in);
				Reporter.log("in properties qa loop", true);

			}
		else if (System.getProperty("EnvType").equalsIgnoreCase("qa")) {
				filepath = "src/test/resources/QA-environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + "/"
						+ filepath);
				properties.load(in);
				Reporter.log("in properties qa loop", true);

			} else if (System.getProperty("EnvType").equalsIgnoreCase("dev")) {
				filepath = "src/test/resources/Dev-environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + "/"
						+ filepath);
				properties.load(in);
				Reporter.log("in properties qa loop", true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		URL = properties.getProperty("url");
		
		Browser = properties.getProperty("Browser");

	}

	public static String LoginURL() {
		Reporter.log("URL is"+URL, true);
		return URL;

	}



	/*public  WebDriver getDriver() {
		// TODO Auto-generated method stub
  
		return driver;
	}*/

}
