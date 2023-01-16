package com.mypages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public String getPageUrl() {

		return driver.getCurrentUrl();
	}

	public String getHeader(By locator) {
		waitForElementPresent(locator);
		return getElement(locator).getText();
	}

	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;

		} catch (Exception ex) {

			System.out.println("Some error has occured while creating element:" + locator.toString());
			ex.printStackTrace();
		}
		return element;

	}

	public void waitForElementPresent(By locator) {
		// TODO Auto-generated method stub
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception ex) {
			System.out.println("Error/exception while waiting for element: " + locator.toString());
			ex.printStackTrace();
		}

	}




	public Select selectElement(By locator) {
			Select item = null;
		try {
			waitForElementPresent(locator);
			item = new Select(driver.findElement(locator));
			return item;

		} catch (Exception ex) {

			System.out.println("Some error has occured while creating element:" + locator.toString());
			ex.printStackTrace();
		}
		return item;
		
	}
	


}
