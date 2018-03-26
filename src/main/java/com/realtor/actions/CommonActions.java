package com.realtor.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonActions {

	public WebDriver DriverInstantiation(WebDriver driver, String browser) {

		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"src/main/resources/com/realtor/drivers/chromedriver");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"src/main/resources/com/realtor/drivers/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

		return driver;
	}
	
	public void wait(WebDriver driver, int timeInSeconds){
		
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		
	}
}