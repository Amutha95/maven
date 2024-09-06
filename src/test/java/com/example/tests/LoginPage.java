package com.example.tests;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class LoginPage extends BaseTest {

	    @Test
	    public void loginTest() {
	        // Navigate to the Guru99 Insurance website
	        driver.get("http://demo.guru99.com/insurance/v1/index.php");

	        // Enter the username
	        WebElement emailField = driver.findElement(By.id("email"));
	        emailField.sendKeys("mvamutha123@gmail.com");

	        // Enter the password
	        WebElement passwordField = driver.findElement(By.id("password"));
	        passwordField.sendKeys("Ammuraj10#");

	        // Click the login button
	        WebElement loginButton = driver.findElement(By.name("submit"));
	        loginButton.click();

	        // Verify successful login by checking for a specific element on the homepage
	        WebElement inputElement = driver.findElement(By.xpath("//div[3]//form//input"));	       
	        Assert.assertTrue(inputElement.isDisplayed(), "Login failed.");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
	}
