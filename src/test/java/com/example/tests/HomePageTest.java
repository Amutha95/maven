package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomePageTest extends BaseTest   //public class named HomePageTest that extends BaseTest. This means HomePageTest inherits the setup
{
    @Test
   
    public void verifyHomePage()  //verifyHomePage method as a test method          
    {
    	//Retrieves the title of the current webpage and stores it in the pageTitle variable.
    	String pageTitle = driver.getTitle();
    	//Asserts that the pageTitle is equal to "Insurance Broker System - Login". If the assertion fails, the test will fail.
        Assert.assertEquals(pageTitle, "Insurance Broker System - Login");

        // Verify key elements on the home page
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed(), "Email field is not displayed");
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field is not displayed");
        Assert.assertTrue(driver.findElement(By.name("submit")).isDisplayed(), "Login button is not displayed");
    }
}