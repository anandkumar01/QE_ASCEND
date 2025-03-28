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

public class searchPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@FindBy(xpath = "//li[@class='flights mainMenu']")
	WebElement flightbutton;

	@FindBy(xpath = "//li[@id='rtrip']")
	WebElement roundtrip;

	@FindBy(xpath = "//p[@id='pff']")
	WebElement frombutton;

	@FindBy(xpath = "//input[@id='a_FromSector_show']")
	WebElement from;

	@FindBy(xpath = "//ul[@class='ausuggest']//li[1]")
	WebElement clickfrom;

	@FindBy(xpath = "//input[@id='a_Editbox13_show']")
	WebElement to;

	@FindBy(xpath = "(//ul[@class='ausuggest']//li[@onchange = 'ChangeCabin();'])[5]")
	WebElement clickto;

	@FindBy(xpath = "//p[@id='ptravlrNo']")
	WebElement travelClass;

	@FindBy(xpath = "//span[@id='spanEconomy']")
	WebElement eco;

	@FindBy(xpath = "//a[@id='traveLer']")
	WebElement done;

	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement search;

	public searchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickFlightButton() {
		flightbutton.click();
	}

	public void clickRoundTrip() {
		roundtrip.click();
	}

	public void fromflight(String From) throws InterruptedException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		frombutton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='a_FromSector_show']")));
		from.sendKeys(From);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spn" + From + "']")));
		clickfrom.click();
	}

	public void toflight(String To) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		to.sendKeys(To);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='spn" + To + "']")));
		// Thread.sleep(2000);
		// js.executeScript("arguments[0].click()",clickto);
		clickto.click();

	}

	public void clickddate(String Ddate) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_2_01/04/2025']")));
		WebElement ddate = driver.findElement(By.xpath("//li[@id='fst_2_" + Ddate + "']"));

		ddate.click();
	}

	public void clickrdate(String Rdate) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='fst_5_04/04/2025']")));
		WebElement rdate = driver.findElement(By.xpath("//li[@id='fst_5_" + Rdate + "']"));
		rdate.click();
	}

	public void travelclass() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		travelClass.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='spanEconomy']")));
		eco.click();
		done.click();
	}

	public void searchButton() {
		search.click();
	}
}
