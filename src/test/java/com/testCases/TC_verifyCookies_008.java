package com.testCases;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;

public class TC_verifyCookies_008 extends BaseClass
{
	@Test(priority=11)
	public void verifyCookies() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		logger.info("Login check of correct email and password");
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		
		lp.txtUsrEmail(username);
		logger.info("Enter user email");
		
		
		lp.txtPassword(password);
		logger.info("Enter password");
		
		lp.btnSignInHomeP();
		logger.info("Sign in to access login page from authentation page");
		
		Set <Cookie> cookies = driver.manage().getCookies();
		System.out.println("Size of the cookies " +cookies.size());
		/*Read and print all the cookies*/
		for(Cookie Cookie : cookies) {
			System.out.println(Cookie.getName() + " : " +Cookie.getValue());
		}
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(3000);
		SoftAssert SoftAssert = new SoftAssert();	
		if (driver.getTitle().equals("Login - My Store")){
			logger.info("Successful access Login - My Store, page ");
			SoftAssert.assertTrue(true);
			logger.info("Success browser asks to log in again after deleting cookies");
		}
			else{	// to capture screen on failure 
				captureScreen(driver,"verifyCookies");
				SoftAssert.assertTrue(false);
				logger.error("Error wrong page displayed");
		}
	
		
	}
}
