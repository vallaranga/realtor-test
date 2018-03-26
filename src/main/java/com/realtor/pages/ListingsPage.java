package com.realtor.pages;

import org.openqa.selenium.*;

public class ListingsPage {

	public By searchResultCount = By
			.cssSelector("html body.properties.show.ab-desktop-filter div.page-content div.container-srp div.srp-body.ab-desktop-filter div#propertyFound.container.srp-card-wrapper div.row.js-sticky-container section.col-lg-9.col-md-8.srp-list-column header#srp-header.srp-propertyfound-header.clearfix.pos-relative div.row div.col-lg-5.col-md-6.col-sm-9.col-xs-8.srp-header-left div.srp-controls div#srp-sort-count-wrap.srp-sort-count-wrap span.search-result-count.srp-list-header-count.font-bold");

	public By sea1 = By.id("search-result-count");

	public By sea2 = By.cssSelector("#search-result-count");

	public By sea3 = By
			.xpath("/html/body/div[5]/div[3]/div/div[4]/div[3]/section/header/div/div[2]/div/div/span");

	public By sea4 = By.cssSelector(".search-result-count");

	public By listingsList = By.cssSelector(".srp-list-marginless");

	public void clickOnAListing(WebDriver driver, int listing) {

		driver.findElement(
				By.xpath(".//*[contains(@class,'srp-list-marginless')]/li["
						+ listing + "]//img")).click();
		System.out.println("Clicked on the listing: " + listing);

	}

	public String returnPriceForAListing(WebDriver driver, int listing) {

		WebElement priceElement = driver.findElement(By
				.xpath(".//*[contains(@class,'srp-list-marginless')]/li["
						+ listing + "]//div[@class='price']/span"));
		String price = priceElement.getText();
		System.out.println("price:" + price);
		return price;

	}

}