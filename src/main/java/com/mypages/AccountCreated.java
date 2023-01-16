package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.AppConstants;

public class AccountCreated extends BasePage {

	By logoutBtn = By.xpath("//ul[@class='side_account_list']/li/a[@href='https://automationteststore.com/index.php?rt=account/logout']");
	By continueBtn = By.xpath("//a[@title='Continue']");
	
	public AccountCreated(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		if (!driver.getTitle().equals("Your Account Has Been Created!")) {
			throw new IllegalStateException(
					"Account is not created " );
		}
	

	}
	
	public  void logout() {
		getElement(logoutBtn).click();
		getElement(continueBtn).click();
	}


	
}
