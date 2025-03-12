package week3_chapter13;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task01 {
	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test
	void testTask01() {
		List<WebElement> carts = driver.findElements(By.xpath("//button[@class='btn_primary btn_inventory']"));
		int i = 0;
		for (WebElement ele : carts) {
			ele.click();
			i++;
			if (i == 2) {
				break;
			}
		}
		String window = driver.getWindowHandle();
		System.out.println(window);

		driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a")).click();
		driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();

		driver.findElement(By.id("first-name")).sendKeys("Chayan");
		driver.findElement(By.id("last-name")).sendKeys("Roy");
		driver.findElement(By.id("postal-code")).sendKeys("128799");
		driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();

		WebElement scroll = driver.findElement(By.className("cart_footer"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

		driver.findElement(By.xpath("//a[@class='btn_action cart_button']")).click();

		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();

		Assert.assertEquals(actual, expected, "Message wasn't displayed while completing order.");
	}

	@AfterClass
	void closeBrowser() {
		driver.quit();
	}
}
