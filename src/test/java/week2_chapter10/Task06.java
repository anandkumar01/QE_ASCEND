package week2_chapter10;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Task06 {
	private WebDriver driver;

	public Task06(WebDriver driver) {
		this.driver = driver;
	}

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--disable-infobars");

		// Step 1: Launch the chrome browser
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		// Step 2: Enter the "https://www.easemytrip.com/" URL in to the browser
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Task06 trainDetails = new Task06(driver);

		trainDetails.fetchTrain();
		trainDetails.run();
		driver.quit(); // Close the browser
	}

	public void fetchTrain() {

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
	}

	// Step 8: Select Quota as required
	public void selectQuota(String quota) {
		WebElement dropdown = driver.findElement(By.xpath("(//select[@class='dropdown'])[1]"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(quota);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Step 9: Print First available train details for each quota
	public void printTrainDetails(String quota) {
		System.out.println("\n----------First Train Details After Selecting " + quota + " Quota----------");

		WebElement trainName = driver.findElement(By.xpath("(//div[@class='tr-name t-ellipsis'])[1]"));
		System.out.println("Train Name: " + trainName.getText());

		WebElement trainNo = driver.findElement(By.xpath("(//div[@class='tr-no'])[1]"));
		System.out.println("Train Number: " + trainNo.getText());

		try {
			List<WebElement> trainDetails = driver.findElements(By.xpath("(//div[@class=\"mainflx\"])[1]/div"));
			for (WebElement ele : trainDetails) {
				System.out.println(ele.getText() + "\t");
			}
		} catch (Exception e) {
			System.out.println("No train details found..");
		}
	}

	public void run() {
		selectQuota("Senior Citizen");
		printTrainDetails("Senior Citizen");

		selectQuota("Ladies Quota");
		printTrainDetails("Ladies Quota");

		selectQuota("DP");
		printTrainDetails("DP");

		selectQuota("Tatkal");
		printTrainDetails("Tatkal");
	}
}
