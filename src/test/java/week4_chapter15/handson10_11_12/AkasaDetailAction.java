package week4_chapter15.handson10_11_12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AkasaDetailAction {

	public static void execute(WebDriver driver) {
		WebDriverWait wait; 
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		
		AkasaDetail.clickFlightButton(driver).click();
		AkasaDetail.clickRoundTrip(driver).click();
		
		AkasaDetail.fromFlight(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='a_FromSector_show']")));
		AkasaDetail.fromName(driver).sendKeys("New Delhi");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spnNew Delhi']")));
		AkasaDetail.fromSelect(driver).click();
		
		AkasaDetail.toFlight(driver).sendKeys("Mumbai");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spnMumbai']")));
		AkasaDetail.toSelect(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_2_01/04/2025']")));
		AkasaDetail.selectDdate(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_5_04/04/2025']")));
		AkasaDetail.selectrdate(driver).click();
		
		AkasaDetail.travel(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spanEconomy']")));
		AkasaDetail.selectClass(driver).click();
		AkasaDetail.confirmClass(driver).click();
		
		AkasaDetail.search(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India']")));
		AkasaDetail.seniorCit(driver).click();
		AkasaDetail.clickAirIndia(driver).click();
		AkasaDetail.clickAirIndiaExpress(driver).click();
		AkasaDetail.clickIndigo(driver).click();
		AkasaDetail.clickSpiceJet(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='card fltResult ng-scope AC'])[1]")));
		String flight1 = SpiceJetDetail.flight1(driver).getText();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")));
		String flight2 = SpiceJetDetail.flight2(driver).getText();
		
		System.out.println("Flight No.:"+flight1+"\n\nFlight no.:"+flight2);
	}
}
