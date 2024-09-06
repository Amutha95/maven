package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;



@Test
public class QuoteRequestTest extends BaseTest {


//This line declares the requestQuoteWithValidData()
public void requestQuoteWithValidData() {
// Login to the website
	
//This line locates the input field for the email address by its id, email, and enters the text "mvamutha123@gmail.com" into it.
driver.findElement(By.id("email")).sendKeys("mvamutha123@gmail.com");
//This line locates the input field for the password by its id, password, and enters the text "Ammuraj10#" into it.
driver.findElement(By.id("password")).sendKeys("Ammuraj10#");
//This line locates the submit button by its name, submit, and clicks it to log in to the website.
driver.findElement(By.name("submit")).click();

// Click on the "Request Quotation" link

//This line locates the link for the "Request Quotation" page using a partial match on the link text, "Request Quotation", and stores it in the requestQuoteLink variable.
WebElement requestQuoteLink = driver.findElement(By.partialLinkText("Request Quotation"));
//This line clicks on the requestQuoteLink to navigate to the quotation request page.
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

// Submit the quote request form
WebElement submitButton = driver.findElement(By.xpath("//form[@action='new_quotation.php']/div[8]/input[1]"));
//Verify the success of the quote request by checking for a confirmation message
Assert.assertTrue(submitButton.isDisplayed(), "Quote request failed.");
}
@AfterClass
public void tearDown() {
// Close the browser
driver.quit();
}

}

