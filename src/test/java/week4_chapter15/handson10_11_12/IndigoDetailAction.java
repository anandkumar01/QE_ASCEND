package week4_chapter15.handson10_11_12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndigoDetailAction {

	public static void execute(WebDriver driver) {
		WebDriverWait wait;
		JavascriptExecutor js;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		IndigoDetail.clickFlightButton(driver).click();
		IndigoDetail.clickRoundTrip(driver).click();

		IndigoDetail.fromFlight(driver).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='a_FromSector_show']")));
		IndigoDetail.fromName(driver).sendKeys("New Delhi");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spnNew Delhi']")));
		IndigoDetail.fromSelect(driver).click();

		IndigoDetail.toFlight(driver).sendKeys("Mumbai");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spnMumbai']")));
		IndigoDetail.toSelect(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_2_01/04/2025']")));
		IndigoDetail.selectDdate(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_5_04/04/2025']")));
		IndigoDetail.selectrdate(driver).click();

		IndigoDetail.travel(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spanEconomy']")));
		IndigoDetail.selectClass(driver).click();
		IndigoDetail.confirmClass(driver).click();

		IndigoDetail.search(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India']")));
		IndigoDetail.clickAirIndia(driver).click();
		IndigoDetail.clickAirIndiaExpress(driver).click();
		IndigoDetail.clickAkasa(driver).click();
		IndigoDetail.clickSpiceJet(driver).click();

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", IndigoDetail.clickstop1(driver));
		IndigoDetail.clickstop1(driver);
		IndigoDetail.clickstop2(driver);

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", IndigoDetail.flight1(driver));
		String indigo1 = IndigoDetail.flight1(driver).getText();
		System.out.print("Flight No.: ");
		System.out.println(indigo1);

		String indigo2 = IndigoDetail.flight2(driver).getText();
		System.out.print("\n\nFlight No.: ");
		System.out.println(indigo2);
	}

}
