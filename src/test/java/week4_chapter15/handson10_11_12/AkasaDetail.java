package week4_chapter15.handson10_11_12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AkasaDetail {

	public static WebElement clickFlightButton(WebDriver driver) {
		WebElement flightbutton = driver.findElement(By.xpath("//li[@class='flights mainMenu']"));
		return flightbutton;
	}
	
	public static WebElement clickRoundTrip(WebDriver driver) {
		WebElement clickRoundTrip = driver.findElement(By.xpath("//li[@id='rtrip']"));
		return clickRoundTrip;
	}
	
	public static WebElement fromFlight(WebDriver driver) {
		WebElement from = driver.findElement(By.xpath("//p[@id='pff']"));
		return from;
	}
	
	public static WebElement fromName(WebDriver driver) {
		WebElement fromName = driver.findElement(By.xpath("//input[@id='a_FromSector_show']"));
		return fromName;
	}
	
	public static WebElement fromSelect(WebDriver driver) {
		WebElement fromselect = driver.findElement(By.xpath("//ul[@class='ausuggest']//li[1]"));
		return fromselect;
	}
	
	public static WebElement toFlight(WebDriver driver) {
		WebElement toName = driver.findElement(By.xpath("//input[@id='a_Editbox13_show']"));
		return toName;
	}
	
	public static WebElement toSelect(WebDriver driver) {
		WebElement toselect = driver.findElement(By.xpath("(//ul[@class='ausuggest']//li[@onchange = 'ChangeCabin();'])[5]"));
		return toselect;
	}
	
	public static WebElement selectDdate(WebDriver driver) {
		WebElement ddate = driver.findElement(By.xpath("//li[@id='fst_2_01/04/2025']"));
		return ddate;
	}
	
	public static WebElement selectrdate(WebDriver driver) {
		WebElement rdate = driver.findElement(By.xpath("//li[@id='fst_5_04/04/2025']"));
		return rdate;
	}
		
	public static WebElement travel(WebDriver driver) {
		WebElement travel = driver.findElement(By.xpath("//p[@id='ptravlrNo']"));
		return travel;
	}
	
	public static WebElement selectClass(WebDriver driver) {
		WebElement selectclass = driver.findElement(By.xpath("//span[@id='spanEconomy']"));
		return selectclass;
	}
	
	public static WebElement confirmClass(WebDriver driver) {
		WebElement confirmclass = driver.findElement(By.xpath("//a[@id='traveLer']"));
		return confirmclass;
	}
	
	public static WebElement search(WebDriver driver) {
		WebElement search = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
		return search;
	}
	
	public static WebElement seniorCit(WebDriver driver) {
		WebElement senior = driver.findElement(By.xpath("//label[normalize-space()='Senior Citizens']"));
		return senior;
	}
	
	public static WebElement clickAirIndia(WebDriver driver) {
		WebElement airIndia = driver.findElement(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India']"));
		return airIndia;
	}
	
	public static WebElement clickAirIndiaExpress(WebDriver driver) {
		WebElement airIndiaExpress = driver.findElement(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Air India Express']"));
		return airIndiaExpress;
	}
	
	public static WebElement clickIndigo(WebDriver driver) {
		WebElement indigo = driver.findElement(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='Indigo']"));
		return indigo;
	}
	
	public static WebElement clickSpiceJet(WebDriver driver) {
		WebElement spicejet = driver.findElement(By.xpath("//label[@class='check-box ng-binding'][normalize-space()='SpiceJet']"));
		return spicejet;
	}
	
	public static WebElement flight1(WebDriver driver) {
		WebElement flight1 = driver.findElement(By.xpath("//div[@class='card fltResult ng-scope AC']"));
		return flight1;
	}
	
	public static WebElement flight2(WebDriver driver) {
		WebElement flight2 = driver.findElement(By.xpath("(//div[@class='bor-bot card fltResultRT ng-scope AC'])[1]"));
		return flight2;
	}
}
