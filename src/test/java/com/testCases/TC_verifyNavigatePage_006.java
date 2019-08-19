package com.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.LoginPage;


public class TC_verifyNavigatePage_006 extends BaseClass 
{
	@Test(priority=9)
	public void verifyNavigatePage() throws IOException 
	{
		LoginPage lp = new LoginPage(driver);
		
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		
		lp.txtUsrEmail(username);
		logger.info("Enter user email");
		
		lp.txtPassword(password);
		logger.info("Enter password");
		
		lp.btnSignInHomeP();
		logger.info("Click on sign in button to access my account page");
		
		SoftAssert SoftAssert = new SoftAssert();
		String msg1 = "My account - My Store";
		driver.getTitle().equals(msg1);
		SoftAssert.assertTrue(true);
		logger.info("login success");
		
		driver.navigate().back();
		logger.info("Checking is the brower signs outs after navigating back");
			
		String btnlsingin = driver.findElement(By.xpath("//a[@class='login']")).getText();
		String msg2 = "Sign in";
		SoftAssert.assertEquals(btnlsingin, msg2);
		logger.info("Sign in button present in Login page");
		
		if (driver.getTitle().equals("Login - My Store")){
			logger.info("Navigated backed to login page");
			SoftAssert.assertTrue(true);
		
		}
		else{	// to capture screen on failure 
			captureScreen(driver, "verifyNavigatePage");
			SoftAssert.assertTrue(false);
			logger.error("login is failed");
		}
}
	
}

