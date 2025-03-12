package week2_chapter10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task05 {
	public static void main(String[] args) throws InterruptedException {

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

		// Step 8: Click Sort By Train Name
		WebElement sortByTrainName = driver.findElement(By.id("b"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", sortByTrainName);

		Thread.sleep(5000);

		// Step 9: Print First available train details
		System.out.println("----------First Train Details After Sorting by Train Name----------");

		WebElement trainName1 = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName1.getText());

		WebElement trainNo1 = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo1.getText());

		WebElement trainDep1 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[1]"));
		System.out.println("Train Departure Time: " + trainDep1.getText());

		WebElement trainArr1 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[2]"));
		System.out.println("Train Dest. Arrival Time: " + trainArr1.getText());

		WebElement timeDuration1 = driver.findElement(By.xpath("(//div[@class='label tl ng-binding'])[1]"));
		System.out.println("Train Duration Time: " + timeDuration1.getText());

		// Step 10: Click Sort By Depart
		WebElement sortByDepart = driver.findElement(By.id("d"));
		js.executeScript("arguments[0].click();", sortByDepart);

		Thread.sleep(5000);

		// Step 11: Print First available train details
		System.out.println("\n----------First Train Details After Sorting by Depart----------");

		WebElement trainName2 = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName2.getText());

		WebElement trainNo2 = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo2.getText());

		WebElement trainDep2 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[1]"));
		System.out.println("Train Departure Time: " + trainDep2.getText());

		WebElement trainArr2 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[2]"));
		System.out.println("Train Dest. Arrival Time: " + trainArr2.getText());

		WebElement timeDuration2 = driver.findElement(By.xpath("(//div[@class='label tl ng-binding'])[1]"));
		System.out.println("Train Duration Time: " + timeDuration2.getText());

		// Step 12: Click Sort By Duration
		WebElement sortByDuration = driver.findElement(By.id("f"));
		js.executeScript("arguments[0].click();", sortByDuration);

		Thread.sleep(5000);

		// Step 13: Print First available train details
		System.out.println("\n----------First Train Details After Sorting by Duration----------");

		WebElement trainName3 = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName3.getText());

		WebElement trainNo3 = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo3.getText());

		WebElement trainDep3 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[1]"));
		System.out.println("Train Departure Time: " + trainDep3.getText());

		WebElement trainArr3 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[2]"));
		System.out.println("Train Dest. Arrival Time: " + trainArr3.getText());

		WebElement timeDuration3 = driver.findElement(By.xpath("(//div[@class='label tl ng-binding'])[1]"));
		System.out.println("Train Duration Time: " + timeDuration3.getText());

		// Step 14: Click Sort By Arrive
		WebElement sortByArrive = driver.findElement(By.id("h"));
		js.executeScript("arguments[0].click();", sortByArrive);

		Thread.sleep(5000);

		// Step 15: Print First available train details
		System.out.println("\n----------First Train Details After Sorting by Arrive----------");

		WebElement trainName4 = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName4.getText());

		WebElement trainNo4 = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo4.getText());

		WebElement trainDep4 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[1]"));
		System.out.println("Train Departure Time: " + trainDep4.getText());

		WebElement trainArr4 = driver.findElement(By.xpath("(//div[@class='tr-tme'])[2]"));
		System.out.println("Train Dest. Arrival Time: " + trainArr4.getText());

		WebElement timeDuration4 = driver.findElement(By.xpath("(//div[@class='label tl ng-binding'])[1]"));
		System.out.println("Train Duration Time: " + timeDuration4.getText());

		// Step : Close the browser
		driver.quit();
	}
}
