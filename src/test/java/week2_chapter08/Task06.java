package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task06 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		try {

			// Navigate to URL
			driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			// Locate elements
			WebElement firstName = driver.findElement(By.id("firstname"));
			WebElement lastName = driver.findElement(By.id("lastname"));
			WebElement userName = driver.findElement(By.id("username"));
			WebElement password = driver.findElement(By.id("password"));
			WebElement registerButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));

			// Enter values
			firstName.sendKeys("Selenium");
			lastName.sendKeys("Test123456");

			// Perform double click on First Name text box and copy text
			Actions actions = new Actions(driver);
			actions.doubleClick(firstName).perform();
			String copiedFirstName = firstName.getAttribute("value");

			// Paste copied First Name into User Name field
			userName.sendKeys(copiedFirstName);

			// Perform double click on Last Name text box and copy text
			actions.doubleClick(lastName).perform();
			String copiedLastName = lastName.getAttribute("value");

			// Paste copied Last Name into Password field
			password.sendKeys(copiedLastName);

			// Click Register button
			registerButton.click();

			// Verify page refresh
			firstName = driver.findElement(By.id("firstname"));
			lastName = driver.findElement(By.id("lastname"));
			userName = driver.findElement(By.id("username"));
			password = driver.findElement(By.id("password"));

			boolean isRefreshed = firstName.getAttribute("value").isEmpty() && lastName.getAttribute("value").isEmpty()
					&& userName.getAttribute("value").isEmpty() && password.getAttribute("value").isEmpty();

			if (isRefreshed) {
				System.out.println("Test Passed: Page refreshed and all entered values are cleared.");
			} else {
				System.out.println("Test Failed: Some values are still present.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close browser
			driver.quit();
		}

	}
}
