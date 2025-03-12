package week3_chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task14 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.calculator.net/bmr-calculator.html");
	}

	@Test(priority = 1)
	void test_01_middle() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("30");

		driver.findElement(By.xpath("//label[normalize-space()='male']")).click();

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("182");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("80");

		driver.findElement(By.xpath("//input[@name='x']")).click();

		String expected = "BMR = 1,793 Calories/day";
		String actual;
		try {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		} catch (StaleElementReferenceException e) {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		}
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 2)
	void test_02_middle() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("30");

		driver.findElement(By.xpath("//label[normalize-space()='female']")).click();

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("182");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("80");

		driver.findElement(By.xpath("//input[@name='x']")).click();

		String expected = "BMR = 1,627 Calories/day";
		String actual;
		try {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		} catch (StaleElementReferenceException e) {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		}
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 3)
	void test_03() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("80");

		driver.findElement(By.xpath("//label[normalize-space()='male']")).click();

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("176");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("76");

		driver.findElement(By.xpath("//input[@name='x']")).click();

		String expected = "BMR = 1,465 Calories/day";
		String actual;
		try {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		} catch (StaleElementReferenceException e) {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		}
		Assert.assertEquals(actual, expected);
	}

	@Test(priority = 4)
	void test_04() {
		driver.findElement(By.id("cage")).clear();
		driver.findElement(By.id("cage")).sendKeys("80");

		driver.findElement(By.xpath("//label[normalize-space()='female']")).click();

		driver.findElement(By.id("cheightmeter")).clear();
		driver.findElement(By.id("cheightmeter")).sendKeys("176");

		driver.findElement(By.id("ckg")).clear();
		driver.findElement(By.id("ckg")).sendKeys("76");

		driver.findElement(By.xpath("//input[@name='x']")).click();

		String expected = "BMR = 1,299 Calories/day";
		String actual;
		try {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		} catch (StaleElementReferenceException e) {
			actual = driver.findElement(By.xpath("//div[@class='verybigtext']")).getText();
		}
		Assert.assertEquals(actual, expected);
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
