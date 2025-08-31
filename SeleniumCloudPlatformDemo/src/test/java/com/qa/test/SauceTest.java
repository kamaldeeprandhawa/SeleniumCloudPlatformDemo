package com.qa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SauceTest extends BaseTest{

	
	@Test
	public void loginTest() {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret-sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	
	@Test
	public void testInventoryItem() {
		loginTest();
		assertEquals(driver.findElement(By.cssSelector(".inventory_item")).getSize(), 6);
	}
	
	@Test
	public void testAddToCart() {
		loginTest();
		assertEquals(driver.findElement(By.xpath("")).getSize(), 6);
	}
}
