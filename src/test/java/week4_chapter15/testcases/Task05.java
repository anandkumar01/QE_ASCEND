package week4_chapter15.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import week4_chapter15.base.baseClass;
import week4_chapter15.pageFactory.filters;
import week4_chapter15.pageFactory.flightDetails;
import week4_chapter15.pageFactory.searchPage;

public class Task05 {

	WebDriver driver;
	searchPage SearchPage;
	filters Filters;
	flightDetails FlightDetails;

	@BeforeClass
	void launchBrowser() {
		baseClass.intializeBrowser();
		driver = baseClass.driver;
		driver.get("https://www.easemytrip.com/");

		SearchPage = new searchPage(driver);
		Filters = new filters(driver);
		FlightDetails = new flightDetails(driver);
	}

	@Test
	void flightDetails() throws InterruptedException {

		String to = "New Delhi";
		String from = "Mumbai";
		String ddate = "01/04/2025";
		String rdate = "04/04/2025";

		SearchPage.clickFlightButton();

		SearchPage.clickRoundTrip();

		SearchPage.fromflight(to);

		SearchPage.toflight(from);

		SearchPage.clickddate(ddate);

		SearchPage.clickrdate(rdate);

		SearchPage.travelclass();

		SearchPage.searchButton();

		Filters.clickAirIndia();

		Filters.clickAirIndiaExpress();

		Filters.clickAkasaAir();

		Filters.clickSpiceJet();

		Filters.stop1();

		Filters.stop2();

		FlightDetails.flightindigo1();

		FlightDetails.flightindigo2();
	}

	@AfterTest
	void close() {
		baseClass.closeBrowser();
	}
}
