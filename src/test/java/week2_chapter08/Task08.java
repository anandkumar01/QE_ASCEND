package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task08 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {
			// Step 1: Launch the Chrome browser
			driver.manage().window().maximize();

			// Step 2: Open the target URL
			driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			// Step 3: Switch to iframe1
			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/main//iframe[1]")));

			// Get iframe1 header and print
			String iframe1Header = driver.getTitle();
			System.out.println("Iframe 1 Header: " + iframe1Header);

			// Read and print content inside iframe1
			WebElement iframe1Content = driver.findElement(By.xpath("/html/body"));
			System.out.println("Iframe 1 Content: " + iframe1Content.getText());

			// Step 4: Switch back to the main document
			driver.switchTo().defaultContent();

			// Step 5: Switch to iframe2
			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/main//iframe[2]")));
			// Get iframe2 header and print
			String iframe2Header = driver.getTitle();
			System.out.println("Iframe 2 Header: " + iframe2Header);

			// Read and print content inside iframe2
			WebElement iframe2Content = driver.findElement(By.xpath("/html/body"));
			System.out.println("Iframe 2 Content: " + iframe2Content.getText());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
