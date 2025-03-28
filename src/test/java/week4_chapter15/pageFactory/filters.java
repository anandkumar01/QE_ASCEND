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

public class filters {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public filters(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@class='check-box ng-binding'][normalize-space()='Air India']")
	WebElement AirIndia;

	@FindBy(xpath = "//label[@class='check-box ng-binding'][normalize-space()='Air India Express']")
	WebElement AirIndiaExpress;

	@FindBy(xpath = "//label[@class='check-box ng-binding'][normalize-space()='Indigo']")
	WebElement Indigo;

	@FindBy(xpath = "//label[@class='check-box ng-binding'][normalize-space()='AkasaAir']")
	WebElement AkasaAir;

	@FindBy(xpath = "//label[@class='check-box ng-binding'][normalize-space()='SpiceJet']")
	WebElement SpiceJet;

	@FindBy(xpath = "(//div[@class='_stpsecnw']//label[@class='check-box'])[1]")
	WebElement nonstop;

	@FindBy(xpath = "(//div[@class='_stpsecnw']//label[@class='check-box'])[2]")
	WebElement stop1;

	@FindBy(xpath = "(//div[@class='_stpsecnw']//label[@class='check-box'])[3]")
	WebElement stop2;

	@FindBy(xpath = "//label[normalize-space()='Senior Citizens']")
	WebElement seniorcit;

	public void clickAirIndia() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India']")));
		AirIndia.click();
	}

	public void clickAirIndiaExpress() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		AirIndiaExpress.click();
	}

	public void clickIndigo() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Indigo.click();
	}

	public void clickAkasaAir() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		AkasaAir.click();
	}

	public void clickSpiceJet() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		SpiceJet.click();
	}

	public void clicknonstop() {
		nonstop.click();
	}

	public void stop1() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", stop2);
		stop1.click();
	}

	public void stop2() {
		stop2.click();
	}

	public void clickSeniorCitizen() throws InterruptedException {
		Thread.sleep(2000);
		seniorcit.click();
	}

}
