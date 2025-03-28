package week4_chapter15.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {

	public static WebDriver driver;
	
	public static void intializeBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}
