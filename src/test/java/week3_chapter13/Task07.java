package week3_chapter13;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task07 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Test(priority = 1)
	void testLogin() {
		driver.findElement(By.xpath("//button[normalize-space()='Customer Login']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("userSelect")).click();

		Select select = new Select(driver.findElement(By.id("userSelect")));
		select.selectByVisibleText("Harry Potter");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 2, dependsOnMethods = "testLogin")
	void testDeposit() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[normalize-space()='Deposit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("1000");
		driver.findElement(By.xpath("(//button[normalize-space()='Deposit'])[2]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement box = driver.findElement(By.xpath("//span[@class='error ng-binding']"));
		boolean boxvisible = box.isDisplayed();
		Assert.assertEquals(boxvisible, true);

	}

	@Test(priority = 3, dependsOnMethods = "testDeposit")
	void testWithdraw() {

		driver.findElement(By.xpath("//button[normalize-space()='Withdrawl']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Withdraw']")));

		driver.findElement(By.xpath("//input[@placeholder='amount']")).sendKeys("100");
		driver.findElement(By.xpath("//button[normalize-space()='Withdraw']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement box = driver.findElement(By.xpath("//span[@class='error ng-binding']"));
		boolean boxvisible = box.isDisplayed();
		Assert.assertEquals(boxvisible, true);

		driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();

	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
