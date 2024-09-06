package com.example.tests;

	import org.openqa.selenium.Dimension;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class ResponsiveTest extends BaseTest {
		 @Test(priority = 1)
		    public void testResponsiveDesignMobile(){
		        driver.manage().window().setSize(new Dimension(375, 667)); // phone
		        
		    }

		    @Test(priority = 2)
		    public void testResponsiveDesignTablet() {
		        driver.manage().window().setSize(new Dimension(768, 1024)); // iPad
		        
		        
		    }

		    @Test(priority = 3)
		    public void testResponsiveDesignDesktop() {
		        driver.manage().window().maximize(); // Desktop
		        
		    }
	}


