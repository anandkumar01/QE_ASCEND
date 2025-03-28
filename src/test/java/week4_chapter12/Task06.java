package week4_chapter12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task06 {
	
	WebDriver driver;
	
	@Test
	void user1() throws InterruptedException {
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--headless");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.get("https://www.calculator.net/bmi-calculator.html");
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Metric Units']")).click();
		driver.findElement(By.xpath("//input[@id='cage']")).clear();
		driver.findElement(By.xpath("//input[@id='cage']")).sendKeys("30");
		
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).clear();
		driver.findElement(By.xpath("//input[@id='cheightmeter']")).sendKeys("170");
		
		driver.findElement(By.xpath("//input[@id='ckg']")).clear();
		driver.findElement(By.xpath("//input[@id='ckg']")).sendKeys("60");
		
		driver.findElement(By.xpath("//input[@name='x']")).click();
		String bigtext = driver.findElement(By.xpath("//div[@class='bigtext']")).getText();
		String bmi = bigtext.substring(5,10);
		
		String actualBMI = " 20.8";
		Assert.assertEquals(bmi, actualBMI);
		
		driver.quit();
	}
}
