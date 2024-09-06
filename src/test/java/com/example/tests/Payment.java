package com.example.tests;

	import org.openqa.selenium.By;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	public class Payment extends BaseTest {
	  @Test
	  public void paymentM() throws InterruptedException {
		  //for clicking on payment option
		  driver.findElement(By.linkText("Payment Gateway Project")).click();
		  Thread.sleep(2000);
		  //for selecting a quantity
		  Select quantity = new Select(driver.findElement(By.name("quantity")));
		  quantity.selectByIndex(4);
		  Thread.sleep(2000);
		  
		  //for clicking on BUY button
		  driver.findElement(By.xpath("/html/body/section/div/form/div/div[8]/ul/li/input")).click();
		  Thread.sleep(4000);
		  
		  //for entering a card number
		  driver.findElement(By.id("card_nmuber")).sendKeys("1234 5678 9876");
		  //for selecting expiring month
		  Select month = new Select(driver.findElement(By.id("month")));
		  month.selectByIndex(3);
		  //for selecting a year
		  Select year = new Select(driver.findElement(By.id("year")));
		  year.selectByIndex(7);
		  
		  //for entering a cvv code
		  driver.findElement(By.id("cvv_code")).sendKeys("879");
		  //for clicking a submit button
		  driver.findElement(By.name("submit")).click();
		  Thread.sleep(4000);
		  System.out.println("Submitted");
		  
	  }
	}



