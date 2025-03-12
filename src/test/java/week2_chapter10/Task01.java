package week2_chapter10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task01 {

	public static void main(String[] args) {

		// Step 1: Launch the chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Step 2: Enter the "https://www.easemytrip.com/" URL in to the browser
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Step 3: Click "Flights" tab
		WebElement flight = driver.findElement(By.xpath("//span[@class='meuicowidth flightmenuico']"));
		flight.click();

		// Step 4: Select from as "Coimbatore"
		WebElement from = driver.findElement(By.id("frmcity"));
		from.click();
		WebElement cityInput = driver.findElement(By.id("a_FromSector_show"));
		cityInput.sendKeys("Coimbatore");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		try {
			WebElement sourceAirport = driver.findElement(By.id("airportCoimbatore"));
			wait.until(ExpectedConditions.elementToBeClickable(sourceAirport));
			sourceAirport.click();
		} catch (StaleElementReferenceException e) {
			WebElement sourceAirport = driver.findElement(By.id("airportCoimbatore"));
			wait.until(ExpectedConditions.elementToBeClickable(sourceAirport));
			sourceAirport.click();
		}

		// Step 5: Select to as "Chennai"
//		WebElement to = driver.findElement(By.id("tocity"));
//		to.click();
		WebElement dest_cityInput = driver.findElement(By.id("a_Editbox13_show"));
		dest_cityInput.sendKeys("Chennai");

		try {
			WebElement destinationAirport = driver.findElement(By.id("airportChennai"));
			wait.until(ExpectedConditions.elementToBeClickable(destinationAirport));
			destinationAirport.click();
		} catch (StaleElementReferenceException e) {
			WebElement destinationAirport = driver.findElement(By.id("airportChennai"));
			wait.until(ExpectedConditions.elementToBeClickable(destinationAirport));
			destinationAirport.click();
		}

		// Step 6: Select any departure date
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scroll = driver.findElement(By.xpath("//div[@id='dvcalendar']/div/div/div"));
		js.executeScript("arguments[0].scrollIntoView();", scroll);

		WebElement departureDate = driver.findElement(By.className("active-date"));
		departureDate.click();

		// Step 7: Click Search button
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("srchBtnSe")));
		WebElement searchButton = driver.findElement(By.className("srchBtnSe"));
		searchButton.click();

		// Step 8: Print first available flight detail from search result
		System.out.println("----------First available flight details----------");

		WebElement filghtName = driver.findElement(
				By.xpath("(//div[@class='adodis_v4 ng-binding ng-scope']//following-sibling::div/div)[1]"));
		System.out.println("Flight Name: " + filghtName.getText());

		WebElement departureTime = driver.findElement(
				By.xpath("(//div[@class='adodis_v4 ng-binding ng-scope']//following-sibling::div/div)[2]/span[1]"));
		System.out.println("Departure Time: " + departureTime.getText());

		WebElement timeDuration = driver.findElement(
				By.xpath("(//div[@class='adodis_v4 ng-binding ng-scope']//following-sibling::div/div)[3]/span[1]"));
		System.out.println("Total Time Duration: " + timeDuration.getText());

		WebElement ArrivalTime = driver.findElement(
				By.xpath("(//div[@class='adodis_v4 ng-binding ng-scope']//following-sibling::div/div)[4]/span[1]"));
		System.out.println("Arrival Time: " + ArrivalTime.getText());

		WebElement ticketPrice = driver.findElement(
				By.xpath("(//div[@class='adodis_v4 ng-binding ng-scope']//following-sibling::div/div)[5]/div[2]/div"));
		System.out.println("Ticket Price: " + ticketPrice.getText());

		// Step 9: Select Senior Citizen check box
		WebElement seniorCitizensCheckBox = driver
				.findElement(By.xpath("//input[@id='chkSeniorCitizen']//following-sibling::span"));
		seniorCitizensCheckBox.click();

		// Step 10: Click Search button
		WebElement searchBtn = driver.findElement(By.id("btnSrch"));
		searchBtn.click();

		// Step 11: Print last available flight detail from search result
		System.out.println("\n----------Last available flight details----------");

		WebElement lastfilghtName = driver.findElement(By.xpath("(//span[@class='txt-r4 ng-binding'])[last()]"));
		System.out.println("Flight Name: " + lastfilghtName.getText());

		WebElement lastFlightDepartureTime = driver
				.findElement(By.xpath("(//span[@class='txt-r2-n ng-binding'])[last()-1]"));
		System.out.println("Departure Time: " + lastFlightDepartureTime.getText());

		WebElement lastFlightTimeDuration = driver
				.findElement(By.xpath("(//span[@class='dura_md ng-binding'])[last()]"));
		System.out.println("Total Time Duration: " + lastFlightTimeDuration.getText());

		WebElement lastFlightArrivalTime = driver
				.findElement(By.xpath("(//span[@class='txt-r2-n ng-binding'])[last()]"));
		System.out.println("Arrival Time: " + lastFlightArrivalTime.getText());

		WebElement lastFlightTicketPrice = driver
				.findElement(By.xpath("(//span[starts-with(@id,'spnPrice')])[last()-1]"));
		System.out.println("Ticket Price: " + lastFlightTicketPrice.getText());

		// Close the browser
		driver.quit();
	}

}
