package week4_chapter12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task03 {

	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@BeforeTest
	void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	void uploaddata() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='PIM']")));

		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")));

		driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Data Import']")));

		driver.findElement(By.xpath("//a[normalize-space()='Data Import']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-file-input-div']")));

		WebElement ele = driver.findElement(By.xpath("//div[@class='oxd-file-input-div']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);

		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("C:\\Users\\2303799\\Downloads\\importData.csv");
		driver.findElement(By.xpath("//button[normalize-space()='Upload']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body']")));
		WebElement block = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body']"));
		String text = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--card-body']")).getText();
		System.out.println(text);
		boolean ele1 = block.isDisplayed();
		Assert.assertEquals(true, ele1);

	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}
