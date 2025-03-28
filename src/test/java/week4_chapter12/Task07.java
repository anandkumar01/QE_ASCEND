package week4_chapter12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task07 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/links");

		// Fetch all link elements
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links found: " + links.size());

		// Iterate over each link and check if it's broken
		for (WebElement link : links) {
			String url = link.getAttribute("href");

			if (url != null && !url.isEmpty()) {
				checkBrokenLink(url);
			} else {
				System.out.println("Skipping empty or null link");
			}
		}

		driver.quit();
	}

	public static void checkBrokenLink(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();

			int responseCode = connection.getResponseCode();
			if (responseCode >= 400) {
				System.out.println("Broken Link: " + url + " | Status Code: " + responseCode);
			} else {
				System.out.println("Valid Link: " + url + " | Status Code: " + responseCode);
			}
			connection.disconnect();
		} catch (IOException e) {
			System.out.println("Error checking link: " + url);
		}
	}
}
