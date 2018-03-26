package com.realtor.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.realtor.actions.CommonActions;
import com.realtor.pages.HomePage;
import com.realtor.pages.ListingsPage;
import com.realtor.pages.ListingDetailsPage;

public class ListingDetailsTestPlan {

	// Instantiations and Object creations for required pages
	WebDriver driver;
	CommonActions commonActions = new CommonActions();
	HomePage homePage = new HomePage();
	ListingsPage listingsPage = new ListingsPage();
	ListingDetailsPage listingDetailsPage = new ListingDetailsPage();

	@Test
	public void testPrice() throws Exception {

		// pass on browser on which test needs to be run - firefox or chrome
		driver = commonActions.DriverInstantiation(driver, "firefox");
		// launch the browser and hit the home page URL
		driver.get(homePage.homePageURL);
		commonActions.wait(driver, 5);
		// find the search bar element and click
		WebElement searchBar = driver.findElement(homePage.searchBar);
		searchBar.click();
		commonActions.wait(driver, 5);
		// type in the search key in the search bar
		searchBar.sendKeys("Morgantown, WV");
		commonActions.wait(driver, 5);
		// submit the search key
		driver.findElement(homePage.searchButton).click();
		commonActions.wait(driver, 5);

		Boolean sea1 = driver.findElements(listingsPage.sea1).size() > 0;
		Boolean sea2 = driver.findElements(listingsPage.sea2).size() > 0;
		Boolean sea3 = driver.findElements(listingsPage.sea3).size() > 0;
		Boolean sea4 = driver.findElements(listingsPage.sea4).size() > 0;

		if (sea1.equals(true)) {

			String relavantListings = driver.findElement(listingsPage.sea1)
					.getText().trim();

			String[] part = relavantListings.split(" ");

			int listings = Integer.parseInt(part[0]);

			Assert.assertTrue(listings > 0,
					"NUmber of Relavant Listings are zero");

		} else if (sea3.equals(true)) {
			String relavantListings = driver.findElement(listingsPage.sea3)
					.getText();
			int numberOfListings = Integer.parseInt(relavantListings);
			System.out.println("relavantListings: " + numberOfListings);

			// test 1 - make sure the value of relevant listings is greater than zero
			Assert.assertTrue(numberOfListings > 0,
					"NUmber of Relavant Listings are zero");
		}

		String listPagePrice = listingsPage.returnPriceForAListing(driver, 2);

		listingsPage.clickOnAListing(driver, 2);

		String indyListPagePrice = listingDetailsPage
				.returnPriceOnSpecificListingPage(driver);

		// test 2 - make sure that the listing value is same on the listings page and the listing details page
		Assert.assertTrue(listPagePrice.equals(indyListPagePrice),
				"Prices aren't equal.");
		driver.close();
	}
}
