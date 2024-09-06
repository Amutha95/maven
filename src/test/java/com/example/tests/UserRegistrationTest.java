package com.example.tests;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



	public class UserRegistrationTest extends BaseTest       //public class named UserRegistrationTest that extends BaseTest. This means HomePageTest inherits the setup
	{

	    @Test
	    public void userRegistrationSuccess() {
	        // Navigate to 'Register' page
	        driver.findElement(By.linkText("Register")).click();

	        // Fill in registration form with valid data
	        driver.findElement(By.id("user_firstname")).sendKeys("Amutha");
	        driver.findElement(By.id("user_surname")).sendKeys("Vanniyaraj");
	        driver.findElement(By.id("user_phone")).sendKeys("6374058243");
	        driver.findElement(By.id("user_dateofbirth_1i")).sendKeys("2001");
	        driver.findElement(By.id("user_dateofbirth_2i")).sendKeys("July");
	        driver.findElement(By.id("user_dateofbirth_3i")).sendKeys("10");
	        
	     //input[@id='licencetype_t']. It uses the driver.findElement() method to find the element by its XPath.
	        WebElement licenceTypeElement = driver.findElement(By.xpath("//input[@id='licencetype_t']"));
	        
	        //This line clicks on the licenceTypeElement
	        licenceTypeElement.click();	
	        
	        //This line locates the dropdown element for selecting the occupation using its id, user_occupation_id.
	        WebElement occupationDropdown = driver.findElement(By.id("user_occupation_id"));
	        
	        //Select object for interacting with the occupationDropdown.
	        Select occupationSelect = new Select(occupationDropdown);
	        
	        //This line selects the option with the visible text "Engineer" from the occupationDropdown.
	        occupationSelect.selectByVisibleText("Engineer");
	        
	        //This lines locates the input field for the street address by its id, user_address_attributes, and enters the texts into it.
	        driver.findElement(By.id("user_address_attributes_street")).sendKeys("Kmg nagar, velliyankadu");
	        driver.findElement(By.id("user_address_attributes_city")).sendKeys("Tiruppur");
	        driver.findElement(By.id("user_address_attributes_county")).sendKeys("India");
	        driver.findElement(By.id("user_address_attributes_postcode")).sendKeys("641604");
	        driver.findElement(By.id("user_user_detail_attributes_email")).sendKeys("mvamutha123@gmail.com");
	        driver.findElement(By.id("user_user_detail_attributes_password")).sendKeys("Ammuraj10#");
	        driver.findElement(By.id("user_user_detail_attributes_password_confirmation")).sendKeys("Ammuraj");

	      

	        // Verify registration success by checking the presence of a success message or redirect to login
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        // Verify registration success by checking the presence of a success message or redirect to login
	        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"new_user\"]/div[5]/input[2]")));
	        Assert.assertTrue(confirmationMessage.isDisplayed(), "Registration failed.");

	    }
	}
