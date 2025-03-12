package week2_chapter08;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task10 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {
			// Step 1: Launch browser and navigate to the login page
			driver.manage().window().maximize();
			driver.get("https://demoqa.com/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			// Step 2: Enter login credentials (Modify with actual username & password)
			WebElement username = driver.findElement(By.id("userName"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement loginButton = driver.findElement(By.id("login"));

			username.sendKeys("username1");
			password.sendKeys("password@123");
			loginButton.click();

			Thread.sleep(3000);

			// Step 3: Retrieve and print cookies
			Set<org.openqa.selenium.Cookie> cookies = driver.manage().getCookies();
			System.out.println("Cookies Information:");
			for (org.openqa.selenium.Cookie cookie : cookies) {
				System.out.println("Name: " + cookie.getName());
				System.out.println("Value: " + cookie.getValue());
				System.out.println("Domain: " + cookie.getDomain());
				System.out.println("Path: " + cookie.getPath());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
