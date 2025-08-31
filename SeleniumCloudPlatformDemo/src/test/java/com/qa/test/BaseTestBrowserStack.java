package com.qa.test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestBrowserStack {
	WebDriver driver;
	public static String USERNAME="kamaldeepkaur_LnlVBk";
	public static String ACCESS_KEY="vQ9xB29puq77xzh8fKe2";
	public static String URL="https://"+USERNAME+":"+ACCESS_KEY+"@hub-cloud.browserstack.com/wd/hub/";
	
	@BeforeMethod
	@Parameters({"browser","version", "os", "os_version"})
	public void setUp(String browserName, String browser_version, String os,String os_version , Method name) {
		System.out.println("browser name is : " + browserName);
		String methodName = name.getName();
			
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("os", os);
		cap.setCapability("os_version", os_version);
		cap.setCapability("browser_version", browser_version);
		//cap.setCapability("platformName", platformName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browserName","Chrome");
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browserName","Firefox");	
		}
		
		//url = https://oauth-kamaldeeprandhawa-7982d:0be654da-89df-485e-8617-389a3c4f112f@ondemand.us-west-1.saucelabs.com:443/wd/hub
		try {
			driver = new RemoteWebDriver(new URL(URL), cap);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
