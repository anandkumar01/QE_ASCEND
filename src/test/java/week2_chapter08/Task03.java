package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task03 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {
			// Open Guru99 file upload URL
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/test/upload/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			// Locate and upload file
			WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
			uploadElement.sendKeys("C:\\Users\\2303799\\Downloads\\web-development-user.png");

			// Select "I accept terms of service" checkbox
			WebElement termsCheckbox = driver.findElement(By.xpath("//*[@id=\"terms\"]"));
			termsCheckbox.click();

			// Click Submit file button
			WebElement submitButton = driver.findElement(By.id("submitbutton"));
			submitButton.click();

			Thread.sleep(2000);

			// Get and print the success message
			WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"res\"]/center"));
			System.out.println("Upload Success Message: " + successMessage.getText());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
