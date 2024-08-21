package chezuba;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchFunctionality { 
	
	// Declaring a Webdriver instance variable globally
	WebDriver driver;
	
	@BeforeTest // Testng @BeforeTest Annotation - Executes the setup method before any test methods
	public void setup() {
		
		// Initialize the ChromeDriver instance
		driver = new ChromeDriver();
		
		// Application under test link is stored in a variable "URL";
		String URL = "https://www.qafox.com/";
		
		// Opens the URL in the browser
		driver.get(URL);
		
		//Sets implicit wait for 10 seconds 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Maximizing the window
		driver.manage().window().maximize();
	}
	
	
	
	@AfterTest // Testng -@AfterTest Annotation executes after test methods
	public void teardown() {
		
		// Close the browser
		driver.close();
	}
}