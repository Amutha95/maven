/* Name: Amutha
 * Date:
 * Ques: Create Basetest class for another subclasses
 */


package com.example.tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//BaseTest is a base class 
public class BaseTest     
{
	//protected means variable is accessible within the class, subclasses, and other classes in the same package.
	protected WebDriver driver; 
	
	 //@BeforeMethod, it will run before each test method. It sets up the WebDriver instance.
    @BeforeMethod          
    public void setup() {
    	//WebDriverManager to automatically download and set up the correct version of ChromeDriver
        WebDriverManager.chromedriver().setup(); 
        
        //ChromeDriver, which opens a new Chrome browser.
        driver = new ChromeDriver();   
      //Maximizes the browser window.
        driver.manage().window().maximize();
      //Navigates the browser to the specified URL.
        driver.get("http://demo.guru99.com/insurance/v1/index.php");        
    }

    @AfterMethod 
 // @AfterMethod, it will run after each test method.
    public void tearDown() {
    	//Checks if the driver instance is not null (i.e., it was successfully initialized).
        if (driver != null) { 
        	
        	//Closes all browser windows
            driver.quit();      
        }
    }
}
