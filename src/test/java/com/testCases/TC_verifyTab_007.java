package com.testCases;

import java.io.IOException;
import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class TC_verifyTab_007 extends BaseClass
{
	@Test(priority=10)
	public void verfyWindowtab() throws InterruptedException, IOException {
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
	
	((JavascriptExecutor)driver).executeScript("window.open()");
    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs.get(1));
    driver.get("http://automationpractice.com/index.php");
    
    lp.btnSignOut();
    logger.info("Sign out of current tab");
    driver.switchTo().window(tabs.get(0));
   
    /*Checking if after signing out does the new tab still keeps the user logged in */
    logger.info("Checking if after signing out does the new tab still keeps the user logged in");
    
    String parent = driver.getWindowHandle();
	System.out.println("Window handle id is : " +parent);
	Thread.sleep(3000);
	
	XLUtils.refreshBrowserByJS(driver);
    SoftAssert SoftAssert = new SoftAssert();
	if (driver.getTitle().equals("My account - My Store")){
		SoftAssert.assertTrue(false);
		logger.error("Test failed");
		captureScreen(driver,"test");
		Thread.sleep(5000);
		lp.btnSignOut();
	}
		else{	
			logger.info(" Test Success");
			SoftAssert.assertTrue(true);
	}
}

}
