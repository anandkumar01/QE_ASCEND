package week4_chapter12;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task04 {

	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String path = System.getProperty("user.home") + "\\Downloads";

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@BeforeTest
	void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	void uploaddata() throws InterruptedException {
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

		driver.findElement(By.xpath("//a[normalize-space()='Download']")).click();
		Thread.sleep(5000);

		File file = new File(path + "\\importData.csv");

		if (file.exists()) {
			System.out.println("File downloaded successfuly at : " + file.getAbsolutePath());
		}
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}

}
