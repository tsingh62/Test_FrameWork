package com.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass
{
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException, IOException
	{
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Login check of correct email and password");
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		
		lp.txtUsrEmail(username);
		logger.info("Enter user email");
		
		lp.txtPassword(password);
		logger.info("Enter password");
		
		lp.btnSignInHomeP();
		logger.info("Click on sign in button to access my account page");
		
		SoftAssert SoftAssert = new SoftAssert();
		if (driver.getTitle().equals("My account - My Store")){
			logger.info("login success");
			Thread.sleep(5000);
			lp.btnSignOut();
			SoftAssert.assertTrue(true);
		}
			else{	// to capture screen on failure 
				captureScreen(driver,"loginTest");
				SoftAssert.assertTrue(false);
				logger.error("login is failed");
		}
	}
	
	
		@Test(priority=2, invocationCount = 5)
		public void authenticationLockOut() throws InterruptedException {
			LoginPage lp = new LoginPage(driver);
			logger.info("To check if there is a limit to enter wrong user ids using 5 wrong attempts");
			lp.btnSigninID();
			logger.info("Click signin button to access authentation page");
			
			// Random incorrect email(s) to check if there is a limit to enter wrong entries for email
			
			String email = randomestring() + "@gmail.com";
			lp.txtUsrEmail(email);
			logger.info("Enter user email");
					
			lp.txtPassword(password);
			logger.info("Enter password");
			
			lp.btnSignInHomeP();
			Thread.sleep(5000);
			logger.info("Click on sign in button to access my account page");
			SoftAssert SoftAssert = new SoftAssert();

			String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]")).getText();
			String result = "Authentication failed.";
			SoftAssert.assertEquals(msg, result);
			System.out.println(result);
			logger.info("incorrect email entries were more than 3");
			SoftAssert.assertAll();
		
			}
			
		
		
		@Test(priority=3, invocationCount=5)
		public void authLockoutpwd() throws InterruptedException{
			
			LoginPage lp = new LoginPage(driver);
			lp.btnSigninID();
			
			// Random incorrect password(s) Entries to check the limit of wrong password(s) that can be entered
			logger.info("Enter Random passwords to check the limit of wrong passwords that can be entered");
			logger.info("Click signin button to access authentation page");
						
			lp.txtUsrEmail(username);
			logger.info("Enter user email");
						
			logger.info("Random incorrect password attampts - 5");
			String pwd = randomeNum();
			lp.txtPassword(pwd);
			logger.info("Enter password");
						
			lp.btnSignInHomeP();
			Thread.sleep(5000);
			logger.info("Click on sign in button to access my account page");
			
			SoftAssert SoftAssert = new SoftAssert();
			String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]")).getText();
			String result = "Authentication failed.";
			SoftAssert.assertEquals(msg, result);
			System.out.println(result);
			logger.info("incorrect password entries were more than 3");
			SoftAssert.assertAll();
						
						
		}
		
		
	 	

}

