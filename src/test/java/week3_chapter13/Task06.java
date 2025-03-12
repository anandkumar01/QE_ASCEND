package week3_chapter13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task06 {

	WebDriver driver = new ChromeDriver();

	@BeforeClass
	void launchBrowser() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test(priority = 1, groups = { "login", "integration" })
	void loginUser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		String loginSuccess = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
		Assert.assertEquals(loginSuccess, "Dashboard");
	}

	@Test(priority = 2, groups = { "logout", "integration" })
	void logoutUser() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement login = driver.findElement(By.xpath("//h5[normalize-space()='Login']"));
		boolean isLoginDisplayed = login.isDisplayed();

		Assert.assertEquals(isLoginDisplayed, true);
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
