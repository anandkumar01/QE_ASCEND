package week4_chapter15.pageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightDetails {
	WebDriver driver;
	JavascriptExecutor js;
	WebDriverWait wait;

	public flightDetails(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card fltResult ng-scope AC']")
	WebElement flight1;

	@FindBy(xpath = "(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")
	WebElement flight2;

	@FindBy(xpath = "(//div[@class='card fltResult ng-scope AC'])[1]")
	WebElement flightIndigo1;

	@FindBy(xpath = "(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")
	WebElement flightIndigo2;

	@FindBy(xpath = "//div[@class='card fltResult ng-scope AC']")
	WebElement flightAkasa1;

	@FindBy(xpath = "(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")
	WebElement flightAkasa2;

	public void flightspicejetdet1() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='card fltResult ng-scope AC'])[1]")));

		String Flight1 = flight1.getText();
		System.out.print("Flight No.: ");
		System.out.println(Flight1);
	}

	public void flightspicejetdet2() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]")));

		String Flight2 = flight2.getText();
		System.out.print("\n\nFlight No.: ");
		System.out.println(Flight2);
	}

	public void flightindigo1() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", flightIndigo2);
		String indigo1 = flightIndigo1.getText();
		System.out.print("Flight No.: ");
		System.out.println(indigo1);
	}

	public void flightindigo2() {

		String indigo2 = flightIndigo2.getText();
		System.out.print("\n\nFlight No.: ");
		System.out.println(indigo2);
	}

	public void flightAkasa1() {
		String akasa = flightAkasa1.getText();
		System.out.print("Flight No.: ");
		System.out.println(akasa);
	}

	public void flightAkasa2() {
		String akasa = flightAkasa2.getText();
		System.out.print("\n\nFlight No.: ");
		System.out.println(akasa);
	}
}
