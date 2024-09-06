package com.example.tests;

	import java.time.Duration;
	import java.util.NoSuchElementException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class Claim_Management extends BaseTest //public class named Claim_Management that extends BaseTest. 
	{

	    @Test
	    public void ClaimInsurance()    ////ClaimInsurance method as a test method      
	    {
	        try {
	            // Navigate to the page
	        	//This line instructs the WebDriver to navigate to the specified URL. Ensure that the URL is correct and points to the desired page.
	            driver.get("https://demo.guru99.com/insurance/v1/claims.php"); // Ensure this URL

	            // Verify that the page has loaded correctly
	            //This line retrieves the current URL of the page after navigation and stores it in the currentUrl variable.
	            String currentUrl = driver.getCurrentUrl();
	            Assert.assertFalse(currentUrl.contains("404"), "Page not found: " + currentUrl);
	            
	            //This pauses the execution of the test for 3 seconds. It’s generally not recommended to use Thread.sleep as it can make tests slower and unreliable.
	            Thread.sleep(3000);

	           
              // This catch block handles the NoSuchElementException
	        } catch (NoSuchElementException e) {
	            System.err.println("Element not found: " + e.getMessage());
	            Assert.fail("Test failed due to missing elements.");
	        } catch (Exception e) {
	            System.err.println("The Page is Exist: " + e.getMessage());
	            Assert.fail("Test failed due to an unexpected error.");
	        }
	    }
	}
