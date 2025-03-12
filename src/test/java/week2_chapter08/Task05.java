package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task05 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();

		try {
			// Open the URL
			driver.manage().window().maximize();
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

			Actions actions = new Actions(driver);

			// Drag Bank option into Debit side Account section
			WebElement bank = driver.findElement(By.id("credit2"));
			WebElement debitAccount = driver.findElement(By.id("bank"));
			actions.dragAndDrop(bank, debitAccount).perform();

			// Drag Sales option into Credit side Account section
			WebElement sales = driver.findElement(By.id("credit1"));
			WebElement creditAccount = driver.findElement(By.id("loan"));
			actions.dragAndDrop(sales, creditAccount).perform();

			// Drag 5000 into Debit side Amount section
			WebElement amount5000 = driver.findElement(By.id("fourth"));
			WebElement debitAmount = driver.findElement(By.id("amt7"));
			actions.dragAndDrop(amount5000, debitAmount).perform();

			// Drag 5000 into Credit side Amount section
			WebElement creditAmount = driver.findElement(By.id("amt8"));
			actions.dragAndDrop(amount5000, creditAmount).perform();

			// Verify dragged amount displayed correctly in the below table
			WebElement debitValue = driver.findElement(By.xpath("//*[@id=\"t7\"]"));
			WebElement creditValue = driver.findElement(By.xpath("//*[@id=\"t8\"]"));

			if (debitValue.getText().equals("5000") && creditValue.getText().equals("5000")) {
				System.out.println("Amounts displayed correctly in the table");
			} else {
				System.out.println("Amounts not displayed correctly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			driver.quit();
		}
	}
}
