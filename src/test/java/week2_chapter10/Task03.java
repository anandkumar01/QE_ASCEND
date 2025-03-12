package week2_chapter10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task03 {
	public static void main(String[] args) {

		// Step 1: Launch the chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step 2: Enter the "https://www.easemytrip.com/" URL in to the browser
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 3: Click "Flight + Hotels" tab
		WebElement flighthotels = driver.findElement(By.xpath("//li[@class='flight + hotel mainMenu']/a"));
		flighthotels.click();

		// Step 4: Select from as "Coimbatore"
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement from = driver.findElement(By.xpath("//div[@class='bx-1to']"));
		from.click();

		WebElement cityInput = driver.findElement(By.id("txtAutoOrgLoc"));
		cityInput.sendKeys("Coimbatore");

		clickSourceAirport(driver, wait);

		// Step 5: Select to as "Chennai"
		WebElement to = driver.findElement(By.xpath("//div[@class='bx-2frm']"));
		to.click();

		WebElement dstcityInput = driver.findElement(By.id("txtAutoDesLoc"));
		dstcityInput.sendKeys("Chennai");

		clickDestinationAirport(driver, wait);

		// Step 6: Select any travel date
		WebElement traveldate = driver.findElement(By.id("Oneway"));
		traveldate.click();

		clickCurrentDate(driver, wait);

		WebElement roomsoption = driver.findElement(By.xpath("//div[@class='bx-4trv']"));
		roomsoption.click();
		WebElement addnights = driver.findElement(By.id("addfff"));
		addnights.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[@id='ight1']")));
		WebElement doneBtn = driver.findElement(By.xpath("(//a[@class='dn_btn'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", doneBtn);

		// Step 7: Click "Search" button
		WebElement searchBtn = driver.findElement(By.xpath("//button[@class='srch-btn-c']"));
		searchBtn.click();

		// Step 8: Print first available hotel detail from search result
		System.out.println("----------Hotel Details----------");
		WebElement hotelName = driver.findElement(By.xpath("(//div[@class='htl_ttl'])[1]"));
		System.out.println("Hotel Name: " + hotelName.getText());

		WebElement hotelLocation = driver.findElement(By.xpath("(//div[@class='address'])[1]"));
		System.out.println("Hotel Location: " + hotelLocation.getText());

		WebElement hotelPrice = driver.findElement(By.xpath("(//div[@class='act_price']/span[2])[1]"));
		System.out.println("Hotel Price: " + hotelPrice.getText());

		// Step 9: Click view details of first hotel
		WebElement viewBtn = driver.findElement(By.xpath("(//div[@class='viewBtn'])[1]"));
		viewBtn.click();

		// Step 10: Print the flight details
		System.out.println("\n----------Flight Details----------");
		WebElement flightName = driver.findElement(By.xpath("//div[@class='air-nme']"));
		System.out.println("Flight Name: " + flightName.getText());

		WebElement departureTime = driver.findElement(By.xpath("(//span[@class='flitime'])[1]"));
		System.out.println("DepartureTime: " + departureTime.getText());

		WebElement arrivalTime = driver.findElement(By.xpath("(//span[@class='flitime'])[2]"));
		System.out.println("ArrivalTime: " + arrivalTime.getText());

		WebElement date = driver.findElement(By.xpath("//div[@class='flydate']"));
		System.out.println("Date: " + date.getText());

		// Step 11: Close the browser
		driver.quit();
	}

	public static void clickCurrentDate(WebDriver driver, WebDriverWait wait) {
		int attempts = 0;
		WebElement calender = driver.findElement(By.xpath("//div[starts-with(@class,'mat-datepicker-content')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calender);
		while (attempts < 3) {
			try {
				WebElement date = driver.findElement(By.xpath("//span[contains(@class, 'mat-calendar-body-today')]"));
				wait.until(ExpectedConditions.elementToBeClickable(date));
				date.click();
				break; // Exit the loop if the click is successful
			} catch (StaleElementReferenceException | ElementNotInteractableException e) {
				attempts++;
				// Optionally, add a short wait here before retrying
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		}
		if (attempts == 3) {
			throw new RuntimeException("Failed to click on current date after 3 attempts");
		}
	}

	public static void clickSourceAirport(WebDriver driver, WebDriverWait wait) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				WebElement sourceAirport = driver.findElement(By.xpath("//ul[@class='ausuggest']/li"));
				wait.until(ExpectedConditions.elementToBeClickable(sourceAirport));
				sourceAirport.click();
				break; // Exit the loop if the click is successful
			} catch (StaleElementReferenceException | ElementNotInteractableException e) {
				attempts++;
				// Optionally, add a short wait here before retrying
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		}
		if (attempts == 3) {
			throw new RuntimeException("Failed to click on the source airport after 3 attempts");
		}
	}

	public static void clickDestinationAirport(WebDriver driver, WebDriverWait wait) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				WebElement destinationAirport = driver.findElement(By.xpath("//ul[@id='ulDestSectors']/li"));
				wait.until(ExpectedConditions.elementToBeClickable(destinationAirport));
				destinationAirport.click();
				break; // Exit the loop if the click is successful
			} catch (StaleElementReferenceException | ElementNotInteractableException e) {
				attempts++;
				// Optionally, add a short wait here before retrying
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			}
		}
		if (attempts == 3) {
			throw new RuntimeException("Failed to click on the destination airport after 3 attempts");
		}
	}
}
