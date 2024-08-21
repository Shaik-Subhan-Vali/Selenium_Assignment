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
		
		// Initialize the Chromedriver instance
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
	
	@Test // Testng - @Test Annotation - will be executed upon executing @beforetest annotation
	public void testcase1() {
		
		// Locating the search box element by ID
		WebElement searchBox = driver.findElement(By.id("s"));
		
		// Input text stored in a variable "input"
		String input = "selenium";
		
		// Entering the text into the search box
		searchBox.sendKeys(input);
		
		// Locating the search button element by ID
		WebElement searchBtn = driver.findElement(By.id("search-submit"));
		
		// Click operation on the element search button
		searchBtn.click();
		
		// Locating the results area element by its ID
		WebElement resultsArea = driver.findElement(By.id("primary"));
		
		// Get the text from the results area
		String exptext = resultsArea.getText();
		
		// Actual text to be verified is declared
		String acttext = "SEARCH RESULTS FOR: " + input.toUpperCase();
		
		// Using testng assertions to verify expected and actual tests
		Assert.assertTrue(exptext.contains(acttext));
	}
	
	@AfterTest // Testng -@AfterTest Annotation executes after test methods
	public void teardown() {
		
		// Close the browser
		driver.close();
	}
}