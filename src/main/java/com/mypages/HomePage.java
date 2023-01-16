package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.AppConstants;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
//		if (!getPageTitle().equals(AppConstants.HOME_PAGE_TITLE)) {
//			throw new IllegalStateException(
//					"This is not the login page current page url is: " +  getPageUrl());
//		}
	}
	public 	By loginLink = By.xpath("//a[contains(text(),'Login or register')]");
	public 	By continueBtn = By.xpath("//button[@title='Continue']");
	
	


	public WebElement getLoginLink() {
		
		return getElement(loginLink);
	}
	
	public WebElement getContinueBtn() {
		return getElement(continueBtn);
	}
	
	public RegisterPage proceedToSignUp() {
		getLoginLink().click();
		getContinueBtn().click();
		if(getPageTitle().equals(AppConstants.SIGN_UP_PAGE_TITLE)) {
			System.out.println("User is redirected to login page");
			return new RegisterPage(driver);
		}else 
		return null;
		
	}

}
