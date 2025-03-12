package week2_chapter10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task02 {
	public static void main(String[] args) {

		// Step 1: Launch the chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step 2: Enter the "https://www.easemytrip.com/" URL in to the browser
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Step 3: Click "Hotels" tab
		WebElement hotels = driver.findElement(By.xpath("//span[@class='meuicowidth hotelmenuico']"));
		hotels.click();
		
		// Step 4: Enter city name as "Pune"
		WebElement city = driver.findElement(By.xpath("//div[@class='hp_inputBox selectHtlCity']"));
		city.click();
		WebElement cityInput = driver.findElement(By.xpath("//input[@id='txtCity']"));
		cityInput.sendKeys("Pune");

		WebElement targetcity = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]"));
		targetcity.click();

		// Step 5: Select any Check In and Check Out date
		WebElement checkin = driver.findElement(By.xpath("((//div[@id='ui-datepicker-div']//tbody)[1]//a[1])[last()-3]"));
		checkin.click();
		
		WebElement checkout = driver.findElement(By.xpath("((//div[@id='ui-datepicker-div']//tbody)[1]//a[1])[last()]"));
		checkout.click();
		
		// Step 6: Select Rooms and Guests
		WebElement doneBtn = driver.findElement(By.id("exithotelroom"));
		doneBtn.click();
		
		WebElement searchBtn = driver.findElement(By.id("btnSearch"));
		searchBtn.click();
		
		// Step 7: Select Price per night
		WebElement perNightCheckbox = driver.findElement(By.xpath("//input[@id='txtPrc2']//following-sibling::span"));
		perNightCheckbox.click();
		
		// Step 8: Print first available hotel detail from search result
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("---------- First Hotel Details ----------");
		
		WebElement hotelName = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div/a/div[2]/span)[1]"));
		System.out.println("Hotel Name: " + hotelName.getText());
		
		WebElement hotelLocation = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div/div[1]/a)[1]"));
		System.out.println("Hotel Location: " + hotelLocation.getText());
		
		WebElement hotelPrice = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div[2]/div[5]/div[2])[1]"));
		System.out.println("Hotel Price: " + hotelPrice.getText());
		
		// Step 9: Select Sort By as Price low to High
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		try {
		    WebElement dropdown = driver.findElement(By.id("drpSortFilter"));
		    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		    dropdown.click();
		} catch (StaleElementReferenceException e) {
		    WebElement dropdown = driver.findElement(By.id("drpSortFilter"));
		    wait.until(ExpectedConditions.elementToBeClickable(dropdown));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		    dropdown.click();
		} catch (ElementClickInterceptedException e) {
		    WebElement dropdown = driver.findElement(By.id("drpSortFilter"));
		    wait.until(ExpectedConditions.visibilityOf(dropdown));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		}

		try {
			WebElement lowtohigh = driver.findElement(By.id("lth"));
		    wait.until(ExpectedConditions.elementToBeClickable(lowtohigh));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lowtohigh);
		    lowtohigh.click();
		} catch (StaleElementReferenceException e) {
			WebElement lowtohigh = driver.findElement(By.id("lth"));
		    wait.until(ExpectedConditions.elementToBeClickable(lowtohigh));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lowtohigh);
		    lowtohigh.click();
		} catch (ElementClickInterceptedException e) {
			WebElement lowtohigh = driver.findElement(By.id("lth"));
		    wait.until(ExpectedConditions.visibilityOf(lowtohigh));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lowtohigh);
		}
		
		// Step 10: Print 10th available hotel detail from search result
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("\n---------- 10th Hotel details after sorting ----------");
		
		WebElement tenthhotelName = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div/a/div[2]/span)[10]"));
		System.out.println("10th Hotel Name: " + tenthhotelName.getText());
		
		WebElement tenthhotelLocation = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div/div/a[1])[10]"));
		System.out.println("10th Hotel Location: " + tenthhotelLocation.getText());
		
		WebElement tenthhotelPrice = driver.findElement(By.xpath("(//div[@class='hotel-content-dtl']/div[2]/div[5]/div[2])[10]"));
		System.out.println("10th Hotel Price: " + tenthhotelPrice.getText());
		
		// Close the browser
		driver.quit();
	}
}
