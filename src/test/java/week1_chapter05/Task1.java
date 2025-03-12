package week1_chapter05;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	public static void main(String[] args) throws Exception {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		// Launch the chrome browser
		driver.manage().window().maximize();

		// Enter the "https://www.google.com" url in to the browser
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Verify the Logo "Google" in the search page/welcome page
		WebElement logo = driver.findElement(By.className("lnXdpd"));
		if (logo.isDisplayed()) {
			System.out.println("Logo Displayed");
		} else {
			System.out.println("Logo not displayed");
		}

		// Enter "Cognizant" in the search text box and click on Google Search button
		WebElement searchInput = driver.findElement(By.className("gLFyf"));
		searchInput.sendKeys("Cognizant");

		// Capture the number of search results along with transaction time taken
		WebElement googleSearch = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']"));
		googleSearch.click();

		// Wait for the results to load
		Thread.sleep(30000);

		// Locate all links on the search results page
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of search results shown: " + allLinks.size());
		for (WebElement link : allLinks) {
			System.out.println(link.getText());
		}

		driver.quit();

	}
}
