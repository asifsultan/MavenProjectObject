package com.mytests;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.constants.AppConstants;
import com.mypages.AccountCreated;
import com.mypages.HomePage;
import com.mypages.RegisterPage;
import com.utilities.ExcelHelper;


public class MainTest {
	
	public static void main(String[] args) throws Exception {
			
		
//		
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		WebDriver driver =   new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		ExcelHelper excel = new ExcelHelper("D:\\Automation scripts\\data.xlsx");
		int rows = excel.getTotalRows("login");
		//int col = excel.getTotalColumns("login", 1);
		System.out.println("Total number of rows: " + rows );
		//System.out.println("Total number of column: " + col);

		HomePage home  = new HomePage(driver);
	
	
		for(int i = 1; i <=rows; i++) {
		try {
			driver.get("https://automationteststore.com/");
			System.out.println("Home Page url: "+home.getPageUrl());
			System.out.println("Home Page title: "+ home.getPageTitle());
			RegisterPage register =  home.proceedToSignUp();
			System.out.println("Registration Page url: "+register.getPageUrl());
			System.out.println("Registration Page title: "+ register.getPageTitle());
			AccountCreated created = register.fillSignUpForm(
					excel.getStringData("login", i, 0),	excel.getStringData("login", i, 1),
					excel.getStringData("login", i, 2),excel.getStringData("login", i, 3),
					excel.getStringData("login", i, 4),excel.getStringData("login", i, 5),
					excel.getStringData("login", i, 6),excel.getStringData("login", i, 7),
					excel.getStringData("login", i, 8),excel.getStringData("login", i, 9),
					excel.getStringData("login", i, 10),excel.getStringData("login", i, 11),
					excel.getStringData("login", i, 12),excel.getStringData("login", i, 13)
					
					);
		
			System.out.println("Registration Page url: "+created.getPageUrl());
			System.out.println("Registration Page title: "+ created.getPageTitle());	
			created.logout();
			excel.writeData("login", i, 14, "Pass");
			excel.writeData("login", i, 15, AppConstants.REGISTERED_SUCCESS_PAGE_TITLE );
			
			
			System.out.println("Test execution for user " + excel.getStringData("login", i, 0) + " is sucessful");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			excel.writeData("login", i, 14, "Fail");
			excel.writeData("login", i, 15, AppConstants.ERROR_IN_ACOUNT_CREATION );
			e.printStackTrace();
		}
	}
		
	
		
	}

}


