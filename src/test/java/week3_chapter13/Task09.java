package week3_chapter13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task09 {

	WebDriver driver;

	@BeforeClass
	void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@DataProvider(name = "loginData")
    Object[][] loginDataProvider() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"locked_out_user", "secret_sauce"},
            {"performance_glitch_user", "secret_sauce"}
        };
    }

	@Test(dataProvider = "loginData")
	void testLogin(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/");
	}

	@AfterClass
	void closeBrowser() {
		if (driver != null) {
            driver.quit();
        }
	}
}