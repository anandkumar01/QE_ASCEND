package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task09 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {
			// Step 1: Launch the Chrome browser
			driver.manage().window().maximize();

			// Step 2: Open the target URL
			driver.get("https://www.tutorialspoint.com/selenium/practice/nestedframes.php");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			WebElement mainFrame = driver.findElement(By.xpath("/html/body"));
			System.out.println("Content of the main frame: " + mainFrame.getText());

			// Step 3: Switch to childframe
			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/main//iframe[1]")));
			// Get childframe header and print

			String iframe1Header = driver.getTitle();
			System.out.println("Iframe 1 Header: " + iframe1Header);

			// Read and print content inside childframe
			WebElement childFrame = driver.findElement(By.xpath("/html/body"));
			System.out.println("Iframe 1 Content: " + childFrame.getText());

			// Step 4: Switch back to the main document
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
