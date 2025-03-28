package week4_chapter12;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task01 {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@BeforeTest
	void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/");
	}

	@Test
	void login() {

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

		driver.findElement(By.xpath("//input[@id='login-button']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='app_logo']")));

		WebElement ele = driver.findElement(By.xpath("//div[@class='app_logo']"));
		boolean visible = ele.isDisplayed();

		try {
			Assert.assertEquals(true, visible);
			captureScreenshot("testTitle.png");
		} catch (AssertionError e) {
			throw new AssertionError("Test case failed");
		}
	}

	public void captureScreenshot(String testname) {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String scrshot = System.getProperty("user.dir") + "//Screenshot//correctLogin.png";
		File destination = new File(scrshot);
		destination.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(srcFile, destination);
			System.out.println("Screenshot saved at : " + destination.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}
}
