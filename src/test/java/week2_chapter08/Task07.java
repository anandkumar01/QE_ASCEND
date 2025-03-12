package week2_chapter08;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task07 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {

			// Navigate to URL
			driver.manage().window().maximize();
			driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			String mainWindow = driver.getWindowHandle();

			// Click New Tab button
			driver.findElement(By.xpath("//button[@title='New Tab']")).click();
			switchToNewWindow(driver);

			// Read and print header from new tab
			WebElement header = driver.findElement(By.tagName("h1"));
			System.out.println("Header from new tab: " + header.getText());

			driver.close();
			// Switch back to main window
			driver.switchTo().window(mainWindow);

			// Click New Window button
			driver.findElement(By.xpath("//button[@title='New Tab']//following-sibling::button[1]")).click();
			switchToNewWindow(driver);

			// Read and print header from new window
			header = driver.findElement(By.tagName("h1"));
			System.out.println("Header from new window: " + header.getText());

			// Switch back to main window
			driver.switchTo().window(mainWindow);

			// Click New Window Message button
			driver.findElement(By.xpath("//button[@title='New Tab']//following-sibling::button[2]")).click();
			switchToNewWindow(driver);

			// Read and print content from New Window Message
			WebElement message = driver.findElement(By.xpath("/html/body/main/div/div"));
			System.out.println("Content from new window message: " + message.getText());

			// Switch back to main window
			driver.switchTo().window(mainWindow);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close browser
			driver.quit();
		}

	}

	private static void switchToNewWindow(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(handle);
				break;
			}
		}
	}
}
