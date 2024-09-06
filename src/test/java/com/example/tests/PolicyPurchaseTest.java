package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PolicyPurchaseTest extends BaseTest {

    @Test
    public void purchasePolicy() {
        // Log in to the application
        driver.findElement(By.id("email")).sendKeys("mvamutha123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ammuraj10#");
        driver.findElement(By.name("submit")).click();

        // Navigate to the policy purchase page
        driver.findElement(By.linkText("Request Quotation")).click();

        // Enter user details
        driver.findElement(By.id("quotation_breakdowncover")).sendKeys("No coverage");
        driver.findElement(By.id("quotation_windscreenrepair_t")).click();

        // Select coverage
        driver.findElement(By.id("quotation_incidents")).sendKeys("0");
        driver.findElement(By.id("quotation_vehicle_attributes_cc")).sendKeys("2000");

        // Complete the purchase
        driver.findElement(By.name("submit")).click();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
