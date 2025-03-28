package week4_chapter15.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week4_chapter15.base.baseClass;
import week4_chapter15.pageFactory.filters;
import week4_chapter15.pageFactory.flightDetails;
import week4_chapter15.pageFactory.searchPage;

public class Task01 {
	WebDriver driver;
	searchPage SearchPage;
	filters Filters;
	flightDetails FlightDetails;

	@BeforeMethod
	void launchBrowser() {
		baseClass.intializeBrowser();
		driver = baseClass.driver;
		driver.get("https://www.easemytrip.com/");

		SearchPage = new searchPage(driver);
		Filters = new filters(driver);
		FlightDetails = new flightDetails(driver);
	}

	@Test(dataProvider = "searchData")
	void flightDetails(String from, String to, String ddate, String rdate) throws InterruptedException {

		SearchPage.clickFlightButton();

		SearchPage.clickRoundTrip();

		SearchPage.fromflight(from);

		SearchPage.toflight(to);

		SearchPage.clickddate(ddate);

		SearchPage.clickrdate(rdate);

		SearchPage.travelclass();

		SearchPage.searchButton();

		Filters.clickAirIndia();

		Filters.clickAirIndiaExpress();

		Filters.clickIndigo();

		Filters.clickAkasaAir();

		FlightDetails.flightspicejetdet1();

		FlightDetails.flightspicejetdet2();

	}

	@DataProvider(name = "searchData")
	public Object[][] getData() {
		return new Object[][] { { "New Delhi", "Mumbai", "01/04/2025", "04/04/2025" },
				{ "Bengaluru", "New Delhi", "01/04/2025", "04/04/2025" } };
	}

	@AfterMethod
	void close() {
		baseClass.closeBrowser();
	}

}
