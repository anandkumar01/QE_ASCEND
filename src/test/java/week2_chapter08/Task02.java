package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task02 {
    public static void main(String[] args) throws Exception {
         WebDriver driver = new ChromeDriver();
        
        try {
            // Open BrowserStack URL
        	driver.manage().window().maximize();
            driver.get("https://www.browserstack.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            
            // Locate the "Get Demo" button
            WebElement getDemoButton = driver.findElement(By.xpath("//a[@title=\"Free Trial\"]"));
            
            // Double-click on the "Get Demo" button
            Actions actions = new Actions(driver);
            actions.doubleClick(getDemoButton).perform();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
            
            // Locate and print the header of the modal popup
            WebElement modalHeader = driver.findElement(By.xpath("//div[@id=\"product-text-heading-var\"]/h1"));
            wait.until(ExpectedConditions.visibilityOf(modalHeader));
            System.out.println("Modal Header: " + modalHeader.getText());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
