package week4_chapter12;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task05 {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	@BeforeTest
	void launchBrowser() {
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
	}

	@Test
	void alert() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println("Alert 1");
		alert1.accept();

		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		Thread.sleep(6000);
		Alert alert2 = driver.switchTo().alert();
		System.out.println("Alert 2");

		alert2.accept();

		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println("Alert 3");
		alert3.dismiss();

		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		Alert alert4 = driver.switchTo().alert();
		System.out.println("Alert 4");
		alert4.sendKeys("Chayan");
		alert4.accept();
	}

	@AfterTest
	void closeBrowser() {
		driver.quit();
	}
}
