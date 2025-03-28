package week3_chapter13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task13 {

	Logger logger = LogManager.getLogger(this.getClass());
	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://elementalselenium.com/");
		logger.info("Navigate to the url");
	}

	@Test
	void testLogin() {
		driver.findElement(By.id("email")).sendKeys("user11@demo.in");
		logger.info("Email entered");

		Select select = new Select(driver.findElement(By.id("options")));

		logger.info("Selected java as language");
		select.selectByVisibleText("Java");

		driver.findElement(By.xpath("//input[@value='Send me test automation Pro tips']")).click();
		logger.info("Clicked on the button");
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
