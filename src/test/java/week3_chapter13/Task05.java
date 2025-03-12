package week3_chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task05 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/bmi-calculator.html");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	void testUser1() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("30");

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("170");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("60");

		driver.findElement(By.xpath("//input[@name='x']")).click();
		String bigtext = driver.findElement(By.className("bigtext")).getText();
		String actualBMI = bigtext.substring(5, 10);

		String expectedBMI = " 20.8";
		Assert.assertEquals(actualBMI, expectedBMI);
	}

	@Test(priority = 2)
	void testUser2() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("10");

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("90");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("60");

		driver.findElement(By.xpath("//input[@name='x']")).click();
		String bigtext = driver.findElement(By.className("bigtext")).getText();
		String actualBMI = bigtext.substring(5, 10);

		String expectedBMI = " 74.1";
		Assert.assertEquals(actualBMI, expectedBMI);
	}

	@Test(priority = 3)
	void testUser3() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("69");

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("170");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("70");

		driver.findElement(By.xpath("//input[@name='x']")).click();
		String bigtext = driver.findElement(By.className("bigtext")).getText();
		String actualBMI = bigtext.substring(5, 10);

		String expectedBMI = " 24.2";
		Assert.assertEquals(actualBMI, expectedBMI);
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
