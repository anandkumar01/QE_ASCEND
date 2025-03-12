package week3_chapter13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task11 {
	WebDriver driver;

	@BeforeMethod
	void launchBrowser() {
		driver = new ChromeDriver();
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	void verifyTitle() {
		// Navigate to the website
		driver.get("https://automationbookstore.dev/");

		// Get the title of the page
		String actualTitle = driver.getTitle();

		// Verify the title with the wrong expected result
		String expectedTitle = "BookStore";
		Assert.assertNotEquals(actualTitle, expectedTitle, "Title does not match!");
	}

	@AfterMethod
	void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
