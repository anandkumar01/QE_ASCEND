package week4_chapter12;

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

public class Task08 {

	WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@BeforeTest
	void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@Test
	void checkAvail() throws InterruptedException {
		driver.findElement(By.cssSelector(".btn_checkavail")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//b[contains(text(),'The ID cannot be blank. Please choose your desired')]")));
		String text = driver
				.findElement(By.xpath("//b[contains(text(),'The ID cannot be blank. Please choose your desired')]"))
				.getText();
		System.out.println(text);
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}
}
