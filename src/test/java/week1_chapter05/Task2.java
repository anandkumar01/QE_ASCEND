package week1_chapter05;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		// Step 1: Launch the chrome browser
		driver.manage().window().maximize();

		// Step 2: Enter the "https://onecognizant.cognizant.com/Home" url
		driver.get("https://onecognizant.cognizant.com/Home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Step 3: Verify the Logo "OneCognizant" in the homepage
		WebElement logo = driver.findElement(By.xpath("//div[@class='nav-wrapper']/a[2]"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}

		// Step 4: Search for "TruTime" in the search box and click Search button
		WebElement searchBox = driver.findElement(By.id("oneC_searchAutoComplete"));
		searchBox.sendKeys("TruTime");
		WebElement searchButton = driver.findElement(By.xpath("//div[@id='micBTN']//following-sibling::div"));
		searchButton.click();

		// Step 5: Click on the TruTime app link from the search results window
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement truTime = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='TruTime ']")));
		truTime.click();

		// Step 6: Retrieve Monthly & Yearly Avg of TruTime and store in the variable
		getTruTimeAvg(driver);

		// Step 7: Capture the current month (Ex: April 2024) displayed in the TruTime
		getCurrentMonthYear(driver);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Close the browser
		driver.quit();

	}

	public static void getCurrentMonthYear(WebDriver driver) {

		WebElement currentMonthElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
		WebElement currentYearElement = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));

		if (currentMonthElement.isDisplayed()) {
			System.out.println("Displaying");
		} else {
			System.out.println("Not Displaying");
		}
		String currentMonth = currentMonthElement.getText();
		String currentYear = currentYearElement.getText();
		System.out.println("Current month and year: " + currentMonth + " " + currentYear);
	}

	public static void getTruTimeAvg(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"appFrame\"]")));
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"appFrame\"]")));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Month Average
		WebElement monthAvgElement = driver.findElement(By.id("A2"));
		String monthAvg = monthAvgElement.getText();
		System.out.println("Month average: " + monthAvg);

		WebElement swipeMonthAvgElement = driver.findElement(By.xpath("//span[@id='A2']//following-sibling::span[1]"));
		String swipeMonthAvg = swipeMonthAvgElement.getText();
		System.out.println("Swipe month average: " + swipeMonthAvg);

		WebElement topupMonthAvgElement = driver.findElement(By.xpath("//span[@id='A2']//following-sibling::span[2]"));
		String topupMonthAvg = topupMonthAvgElement.getText();
		System.out.println("Topup month average: " + topupMonthAvg);

		// Year Average
		WebElement yearAvgElement = driver.findElement(By.id("A3"));
		String yearAvg = yearAvgElement.getText();
		System.out.println("Year average: " + yearAvg);

		WebElement swipeYearAvgElement = driver.findElement(By.xpath("//span[@id='A3']//following-sibling::span[1]"));
		String swipeYearAvg = swipeYearAvgElement.getText();
		System.out.println("Swipe year average: " + swipeYearAvg);

		WebElement topupYearAvgElement = driver.findElement(By.xpath("//span[@id='A3']//following-sibling::span[2]"));
		String topupYearAvg = topupYearAvgElement.getText();
		System.out.println("Topup year average: " + topupYearAvg);
	}
}
