package com.qa.gridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGirdTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		//1. Define Desired Capabilities:
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		
		//2. ChromeOptions definition:
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
		
		String hubURL = "http://10.0.0.25:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubURL),options);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
