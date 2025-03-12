package week3_chapter13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task03 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test
	void getTitle() {
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle, "Title didn't match.");
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
