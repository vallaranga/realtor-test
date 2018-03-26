package com.realtor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListingDetailsPage {

	public String returnPriceOnSpecificListingPage(WebDriver driver) {

		WebElement priceElement = driver
				.findElement(By
						.xpath(".//*[@class='qv-container qv-content-wrapper']//*[@itemprop='price']"));
		String price = priceElement.getText();
		System.out.println("price on the Indy Listing Page:" + price);
		return price;

	}

}
