package week2_chapter10;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task04 {
	public static void main(String[] args) {

		// Step 1: Launch the chrome browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// Step 2: Enter the "https://www.easemytrip.com/" URL in to the browser
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 3: Click "Trains" tab
		WebElement trains = driver.findElement(By.xpath("//li[@class='trains mainMenu']/a"));
		trains.click();

		// Step 4: Select from as "Coimbatore"
		WebElement from = driver.findElement(By.xpath("//div[@id='TrainBySearch']/div[1]"));
		from.click();

		WebElement cityInput = driver.findElement(By.id("txtfromcity"));
		cityInput.sendKeys("Coimbatore");
		WebElement sourceStation = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[1]"));
		sourceStation.click();

		// Step 5: Select to as "Chennai"
		WebElement to = driver.findElement(By.xpath("//div[@id='TrainBySearch']/div[2]"));
		to.click();

		WebElement dstcityInput = driver.findElement(By.id("txtdesticity"));
		dstcityInput.sendKeys("Chennai");
		WebElement destinationStation = driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[1]"));
		destinationStation.click();

		// Step 6: Select Dep arture Date
		WebElement departureDate = driver.findElement(By.id("lblrdoonewaydate"));
		departureDate.click();

		// Close the pop up
		WebElement closePopup = driver.findElement(By.cssSelector("a.crs-hp.closeFilePanel"));
		closePopup.click();

		// Step 7: Click Search button
		WebElement searchBtn = driver.findElement(By.xpath("//div[@id='TrainBySearch']/div[4]"));
		searchBtn.click();

		// Step 8: Print First available train details
		System.out.println("----------Train Details----------");

		WebElement trainName = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName.getText());

		WebElement trainNo = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo.getText());

		WebElement trainDep = driver.findElement(By.xpath("(//div[@class='tr-tme'])[1]"));
		System.out.println("Train Departure Time: " + trainDep.getText());

		WebElement trainArr = driver.findElement(By.xpath("(//div[@class='tr-tme'])[2]"));
		System.out.println("Train Dest. Arrival Time: " + trainArr.getText());

		WebElement timeDuration = driver.findElement(By.xpath("(//div[@class='label tl ng-binding'])[1]"));
		System.out.println("Train Duration Time: " + timeDuration.getText());

		// Step 9: Click View Route link of the first available train
		WebElement routemap = driver.findElement(By.xpath("(//div[@class='tr-view label'])[1]"));
		WebElement scroll = driver.findElement(By.xpath("(//div[@class='seatavl'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		js.executeScript("arguments[0].click();", routemap);

		// Step 10: Print all the route details
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='if-table-statn']")));

		// Find the table
		WebElement table = driver.findElement(By.xpath("//table[@class='if-table-statn']"));

		// Find the header row
		WebElement headerRow = table.findElement(By.xpath(".//tr[1]"));
		List<WebElement> headers = headerRow.findElements(By.tagName("th"));

		// Print the headers
		for (WebElement header : headers) {
			System.out.print(header.getText() + "\t");
		}
		System.out.println();

		// Find all content rows within the tbody
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

		// Iterate through each content row
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + "\t");
			}
			System.out.println();
		}

		// Step : Close the driver
		driver.quit();
	}
}
