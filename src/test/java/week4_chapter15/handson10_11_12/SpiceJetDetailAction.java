package week4_chapter15.handson10_11_12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpiceJetDetailAction {
	
	public static void execute(WebDriver driver) {
		WebDriverWait wait; 
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		SpiceJetDetail.clickFlightButton(driver).click();
		SpiceJetDetail.clickRoundTrip(driver).click();
		
		SpiceJetDetail.fromFlight(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='a_FromSector_show']")));
		SpiceJetDetail.fromName(driver).sendKeys("New Delhi");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spnNew Delhi']")));
		SpiceJetDetail.fromSelect(driver).click();
		
		SpiceJetDetail.toFlight(driver).sendKeys("Mumbai");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spnMumbai']")));
		SpiceJetDetail.toSelect(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_2_01/04/2025']")));
		SpiceJetDetail.selectDdate(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_5_04/04/2025']")));
		SpiceJetDetail.selectrdate(driver).click();
		
		SpiceJetDetail.travel(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spanEconomy']")));
		SpiceJetDetail.selectClass(driver).click();
		SpiceJetDetail.confirmClass(driver).click();
		
		SpiceJetDetail.search(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India']")));
		SpiceJetDetail.clickAirIndia(driver).click();
		SpiceJetDetail.clickAirIndiaExpress(driver).click();
		SpiceJetDetail.clickIndigo(driver).click();
		SpiceJetDetail.clickAkasa(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card fltResult ng-scope AC'])[1]")));
		String flight1 = SpiceJetDetail.flight1(driver).getText();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")));
		String flight2 = SpiceJetDetail.flight2(driver).getText();
		
		System.out.println("Flight No.:"+flight1+"\n\nFlight no.:"+flight2);
	}
}
