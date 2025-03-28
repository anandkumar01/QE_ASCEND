package week4_chapter15.handson10_11_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mainModule {

	static WebDriver driver = null;

	@BeforeMethod
	void urllaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.easemytrip.com/");
	}

	@Test
	void SpicejetDetails() {
		SpiceJetDetailAction.execute(driver);
	}

	@Test
	void IndigoDetails() {
		IndigoDetailAction.execute(driver);
	}

	@Test
	void AkasaDetails() {
		AkasaDetailAction.execute(driver);
	}

	@AfterMethod
	void closeBrowser() {
		driver.quit();
	}
}
