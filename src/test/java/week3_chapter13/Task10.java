package week3_chapter13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task10 {

	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
	}

	@Parameters({ "browser" })
	@Test
	void testOrangeHRM(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			String title = driver.getTitle();
			Assert.assertEquals(title, "OrangeHRM");
		}
	}

	@Parameters({ "browser" })
	@Test
	void testGoogle(String browser) {
		if (browser.equalsIgnoreCase("edge")) {
			driver.get("https://www.google.com/");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Google");
		}
	}

	@AfterClass
	void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
