package week2_chapter08;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task04 {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open the URL
            driver.get("https://demo.guru99.com/test/tooltip.html");
            driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            
            // Locate the Download button
            WebElement downloadButton = driver.findElement(By.id("download_now"));
            
            // Perform mouse hover action
            Actions actions = new Actions(driver);
            actions.moveToElement(downloadButton).perform();
            
            List<WebElement> toolTiplist=driver.findElements(By.xpath("//div[@class=\"tooltip\"]//tr"));
            // Locate the tooltip element
            for(int i=0;i<toolTiplist.size();i++){
                System.out.println(toolTiplist.get(i).getText());
            }
            WebElement releaseNote = driver.findElement(By.xpath("//div[@class='tooltip']/a"));
            
            // Print the tooltip text
            System.out.println("Tooltip Text: " + releaseNote.getText());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
