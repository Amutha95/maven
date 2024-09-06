package com.example.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



	public class Edit_Profile extends BaseTest       //public class named UserRegistrationTest that extends BaseTest. This means HomePageTest inherits the setup
	{
		 @Test
		    public void testEditProfileWithValidData() {
		        // Log in to the application
		        driver.findElement(By.id("email")).sendKeys("mvamutha123@.com");
		        driver.findElement(By.id("password")).sendKeys("Ammuraj10#");
		        driver.findElement(By.name("submit")).click();

		        // Navigate to Edit Profile
		        driver.findElement(By.xpath("//*[@id=\'editprofile\']")).click();


		        // Update the profile with valid data
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		        WebElement surname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_surname")));
		        surname.clear();
		        surname.sendKeys("UpdatedSurname");

		        WebElement firstname = driver.findElement(By.id("user_firstname"));
		        firstname.clear();
		        firstname.sendKeys("UpdatedFirstname");

		        // Continue updating other profile fields as needed
		        // ...

		        // Submit the form
		        driver.findElement(By.name("submit")).click();

		        // Verify the confirmation message or check that the updated information is displayed correctly
		        String confirmationMessage = driver.findElement(By.className("confirmation")).getText();
		        Assert.assertTrue(confirmationMessage.contains("successfully updated"), "Profile update failed!");
		    }

		    @Test
		    public void testEditProfileWithInvalidData() {
		        // Similar steps as above but with invalid data to check error handling
		        // For example, you can input invalid email or leave required fields empty
		    }

		    @AfterClass
		    public void teardown() {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
		}



