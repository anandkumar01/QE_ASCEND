package week3_chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task02 {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeClass
	void launchBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://cleartax.in/s/compound-interest-calculator");
	}

	@Test
	void testInterest() {
		driver.findElement(By.id("compoundFrequency")).click();
		Select freq = new Select(driver.findElement(By.id("compoundFrequency")));
		freq.selectByVisibleText("Yearly");

		driver.findElement(By.id("principleAmount")).clear();
		driver.findElement(By.id("principleAmount")).sendKeys("7000");

		driver.findElement(By.id("annualrate")).clear();
		driver.findElement(By.id("annualrate")).sendKeys("10");

		driver.findElement(By.id("periodUnit")).click();

		Select time = new Select(driver.findElement(By.id("periodUnit")));
		time.selectByVisibleText("Years");

		driver.findElement(By.id("periodInDigit")).clear();
		driver.findElement(By.id("periodInDigit")).sendKeys("1");

		WebElement interest = driver.findElement(By.xpath("//span[normalize-space()='700']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", interest);

		String actual = "700";
		String confirm = driver.findElement(By.xpath("//span[normalize-space()='700']")).getText();

		Assert.assertEquals(confirm, actual, "Value didn't match.");
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
