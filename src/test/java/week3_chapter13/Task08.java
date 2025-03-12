package week3_chapter13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task08 {

	WebDriver driver;

	@BeforeMethod
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@Parameters({ "username", "password" })
	@Test
	void testLogin(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String expected = "Logged In Successfully";
		String actual = driver.findElement(By.xpath("//h1[normalize-space()='Logged In Successfully']")).getText();
		Assert.assertEquals(actual, expected);
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
}
