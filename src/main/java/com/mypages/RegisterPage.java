package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage{
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
			
	}

	
	protected By firstName = By.id("AccountFrm_firstname");
	protected By lastName = By.id("AccountFrm_lastname");
	protected By email = By.id("AccountFrm_email");
	protected By telephone = By.id("AccountFrm_telephone");
	protected By fax = By.id("AccountFrm_fax");
	protected By company = By.id("AccountFrm_company");
	protected By address1 = By.id("AccountFrm_address_1");
	protected By zip = By.id("AccountFrm_postcode");
	protected By city = By.id("AccountFrm_city");
	protected By state = By.id("AccountFrm_zone_id");
	protected By country = By.id("AccountFrm_country_id");
	protected By loginName = By.id("AccountFrm_loginname");
	protected By password = By.id("AccountFrm_password");
	protected By confimPass = By.id("AccountFrm_confirm");
	protected By check = By.xpath("//input[@name='agree']");
	protected By continueBtn = By.xpath("//button[@title='Continue']");
	protected By errorMessage = By.xpath("//div[@class='alert alert-error alert-danger']");
	


	protected WebElement getFirstName() {
		return getElement(firstName);
	}
	
	protected WebElement getLastName() {
		return getElement(lastName);
	}
	
	protected WebElement getEmail() {
		return getElement(email);
	}

	protected WebElement getTelephone() {
		return getElement(telephone);
	}
	
	protected WebElement getFax() {
		return getElement(fax);
	}

	protected WebElement getCompany() {
		return getElement(company);
	}
	
	protected WebElement getAddress1() {
		return getElement(address1);
	}
	protected WebElement getZip() {
		return getElement(zip);
	}

	protected WebElement getCity() {
		return getElement(city);
	}

	protected Select getState() {
		return selectElement(state);
	}
	
	protected Select getCountry() {
		return selectElement(country);
	}
	
	protected WebElement getLoginName() {
		return getElement(loginName);
	}
	
	protected WebElement getPassword() {
		return getElement(password);
	}
	
	protected WebElement getConfimPass() {
		return getElement(confimPass);
	}
	protected WebElement getCheckBox() {
		return getElement(check);
	}
	protected WebElement getContinueButton() {
		// TODO Auto-generated method stub
		return getElement(continueBtn);
	}
	
	public WebElement checkErrorText() {
		return getElement(errorMessage);
	}
	public String getErrorText() {
		return getElement(errorMessage).getText();
	}
	
//	public boolean getAccountStatus() {
//		if(getErrorText().contains(AppConstants.ERROR_IN_ACOUNT_CREATION)) {
//			//return getErrorText();
//			return false;
//		}else{
//			//return "Account created sucessfully" ;
//			return true;
//		}
//	}
	
	public AccountCreated fillSignUpForm(String fName, String lName, String emailD, String telephoneD,
			String faxD, String companyD, String addressD, String zipD, String cityD, 
			String countryD,String stateD, String loginND, String passD, String confirmD) {
		
	
		
		getFirstName().sendKeys(fName);
		getLastName().sendKeys(lName);
		getEmail().sendKeys(emailD);
		getTelephone().sendKeys(telephoneD);
		getFax().sendKeys(faxD);
		getCompany().sendKeys(companyD);
		getAddress1().sendKeys(addressD);
		getZip().sendKeys(zipD);
		getCity().sendKeys(cityD);
		getState().selectByVisibleText(stateD);
		getCountry().selectByVisibleText(countryD);
		getLoginName().sendKeys(loginND);
		getPassword().sendKeys(passD);
		getConfimPass().sendKeys(confirmD);
		
		getCheckBox().click();
		getContinueButton().click();
		
		return new AccountCreated(driver);
		
		
	}

	

	


	
	
	

}


