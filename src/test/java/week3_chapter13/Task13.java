package week3_chapter13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task13 {

	Logger logger = LogManager.getLogger(this.getClass());
	WebDriver driver;

	@BeforeMethod
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://elementalselenium.com/");
		logger.info("Navigate to the url");
	}

	@Test
	void testLogin() {
		logger.info("Enter the email");
		driver.findElement(By.id("email")).sendKeys("user11@demo.in");

		Select select = new Select(driver.findElement(By.id("options")));

		logger.info("Select java as language");
		select.selectByVisibleText("Java");

		driver.findElement(By.xpath("//input[@value='Send me test automation Pro tips']")).click();
		logger.info("Click on the button");
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
}
