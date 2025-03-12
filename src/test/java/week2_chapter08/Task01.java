package week2_chapter08;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
 
public class Task01 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
       
        try {
            // Launch the browser and open the URL
        	driver.manage().window().maximize();
            driver.get("https://www.browserstack.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
           
            // Locate "Get Started Free" button
            WebElement getStartedButton = driver.findElement(By.xpath("//a[contains(text(),'Get started free')]"));
           
            // Print button color before hover
            String initialColor = getStartedButton.getCssValue("background-color");
            System.out.println("Initial color of 'Get Started Free' button: " + initialColor);
           
            // Perform mouse hover action
            Actions actions = new Actions(driver);
            actions.moveToElement(getStartedButton).perform();
           
            // Print button color after hover
            String hoverColor = getStartedButton.getCssValue("background-color");
            System.out.println("Current color after mouse hover: " + hoverColor);
            // Scroll down to "View Pricing" button
            // JavascriptExecutor js = (JavascriptExecutor) driver;
            // js.executeScript("window.scrollBy(0,250)", "");
            WebElement viewPricingButton = driver.findElement(By.xpath("//a[contains(text(), 'View Pricing')]"));
            actions.moveToElement(viewPricingButton).click().perform();
           
            // Print Best Value dollar amount
            WebElement bestValuePrice = driver.findElement(By.xpath("(//*[@class='amount'])[1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String text = (String) js.executeScript("return arguments[0].textContent;", bestValuePrice);
            System.out.println("Best Value Price: " + text + "$/month");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
