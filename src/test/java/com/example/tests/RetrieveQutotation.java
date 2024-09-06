package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


		public class RetrieveQutotation extends BaseTest  {
	    @Test
	    public void requestAndVerifyQuotation() {
	        // Log in to the application
	        driver.findElement(By.id("email")).sendKeys("mvamutha123@gmail.com");
	        driver.findElement(By.id("password")).sendKeys("Ammuraj10#");
	        driver.findElement(By.name("submit")).click();

	        // Navigate to the request quotation page
	        WebElement requestQuoteLink = driver.findElement(By.partialLinkText("Request Quotation"));
	        requestQuoteLink.click();


	     // This line locates the dropdown menu for the breakdown cover by its id, quotation_breakdowncover, and stores it in the BreakdowncoverDropdown variable.
	        WebElement BreakdowncoverDropdown = driver.findElement(By.id("quotation_breakdowncover"));
	        //This line creates a Select object for interacting with the BreakdowncoverDropdown, allowing you to select options from the dropdown menu.
	        Select BreakdowncoverDropdownSelect = new Select(BreakdowncoverDropdown);

	        //This line selects the option with the visible text "No cover" from the breakdown cover dropdown menu.
	        BreakdowncoverDropdownSelect.selectByVisibleText("No cover");
	        //This line locates the checkbox for windscreen repair by its id, quotation_windscreenrepair_t, and clicks it to select the option.
	        driver.findElement(By.id("quotation_windscreenrepair_t")).click();
	        //This line locates the input field for incidents by its id, quotation_incidents, and enters the text "None" into it.
	        driver.findElement(By.id("quotation_incidents")).sendKeys("None");
	        //This line locates the input field for the vehicle registration number by its id, quotation_vehicle_attributes_registration, and enters the text "Ambx123" into it.
	        driver.findElement(By.id("quotation_vehicle_attributes_registration")).sendKeys("Ambx123");
	        //his line locates the input field for the vehicle mileage by its id, quotation_vehicle_attributes_mileage, and enters the text "19000" into it.
	        driver.findElement(By.id("quotation_vehicle_attributes_mileage")).sendKeys("19000");
	        driver.findElement(By.id("quotation_vehicle_attributes_value")).sendKeys("22000");
	        //This line locates the dropdown menu for the parking location by its id, quotation_vehicle_attributes_parkinglocation
	        WebElement ParkingDropdownDropdown = driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation"));
	        //Select object for interacting with the ParkingDropdownDropdown, allowing you to select options from the dropdown menu.
	        Select ParkingDropdownSelect = new Select(ParkingDropdownDropdown);
	        //This line selects the option with the visible text "Locked Garage" from the parking location dropdown menu.
	        ParkingDropdownSelect.selectByVisibleText("Locked Garage");
	        //This line locates the input field for the policy start month by its id, quotation_vehicle_attributes_policystart_2i, and enters "September" into it.
	        driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")).sendKeys("September");
	        //This line locates the input field for the policy start day by its id, quotation_vehicle_attributes_policystart_3i, and enters "1" into it.
	        driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")).sendKeys("1");
	        // Calculate the premium
	        driver.findElement(By.xpath("//input[@value='Calculate Premium']")).click();

	        // Submit the form to get the identification number
	        driver.findElement(By.xpath("//input[@value='Save Quotation']")).click();

	        // Capture the generated identification number
	        WebElement identificationNumberElement = driver.findElement(By.xpath("//b[contains(text(), 'Your identification number is')]/following-sibling::b"));
	        String generatedIdentificationNumber = identificationNumberElement.getText();

	        System.out.println("Generated Identification Number: " + generatedIdentificationNumber);
	        
	        
	        driver.close();

	        // Navigate to the retrieve quotation page
	        //driver.findElement(By.xpath("//a[@id=\"ui-id-3\"]")).click();  
	        WebElement QuoteLink = driver.findElement(By.partialLinkText("Retrieve Quotation"));
	      //This line clicks on the requestQuoteLink to navigate to the quotation request page.
	        QuoteLink.click();
	       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        //WebElement retrieveLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Retrieve Quotation"))); retrieveLink.click(); 
	        
	        
	       
	        
	        
	        // Enter the generated identification number
	        driver.findElement(By.id("id")).sendKeys(generatedIdentificationNumber);

	        // Submit to retrieve the quotation
	        driver.findElement(By.name("submit")).click();

	        // Verify that the retrieved identification number matches the one that was generated
	        WebElement retrievedIdentificationElement = driver.findElement(By.xpath("//b[contains(text(), 'Your identification number is')]/following-sibling::b"));
	        String retrievedIdentificationNumber = retrievedIdentificationElement.getText();

	        Assert.assertEquals(retrievedIdentificationNumber, generatedIdentificationNumber, "Retrieved identification number does not match the generated number.");
	    }

	    @AfterTest
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
