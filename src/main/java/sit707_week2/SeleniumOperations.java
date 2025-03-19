package sit707_week2;

import java.io.IOException;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ripha\\Documents\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Nisal");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		
		WebElement SurnameElement = driver.findElement(By.id("lastname"));
		SurnameElement.sendKeys("Perera");
		WebElement Phonenumb = driver.findElement(By.id("phoneNumber"));
		Phonenumb.sendKeys("0451298177");
		WebElement Emailkey = driver.findElement(By.id("email"));
		Emailkey.sendKeys("vishwaperera2500@gmail.com");
		WebElement Pass = driver.findElement(By.id("password"));
		Pass.sendKeys("Nisal@2002");
		WebElement Confpass = driver.findElement(By.id("confirmPassword"));
		Confpass.sendKeys("Nisal@2002");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement createaccountButton = driver.findElement(By.xpath("//button[contains(text(),'Create account')]"));
		createaccountButton.click();
		sleep(2);
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		Screenshotfun(driver, "officeworks_shot");
	
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	public static void Screenshotfun(WebDriver driver, String fileName) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshot, new File("C:\\Users\\ripha\\SIT333 JAVA PROJECTS\\2.1P-resources (6)\\2.1P\\" + fileName + ".jpg"));
			System.out.println("Screenshot saved to: " + fileName);
			
		} catch (IOException e) 
		
		{
			System.out.println("Screenshot Failed:" + e.getMessage());
		}
	}
	
	
}
