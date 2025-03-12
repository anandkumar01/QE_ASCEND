package week3_chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task04 {

	WebDriver driver;
	JavascriptExecutor js;
	SoftAssert softAssert;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://cleartax.in/s/compound-interest-calculator");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	void testInterest1() {
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

		String expectedInterest = "700";
		String actualInterest = driver.findElement(By.xpath("//span[normalize-space()='700']")).getText();

		softAssert = new SoftAssert();
		softAssert.assertEquals(actualInterest, expectedInterest);

		String expectedTotalValue = "7,700";
		String actualTotalValue = driver.findElement(By.xpath("//span[normalize-space()='7,700']")).getText();

		softAssert.assertEquals(actualTotalValue, expectedTotalValue);
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
