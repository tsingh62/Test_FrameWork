package com.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.ForgotPwd;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class TC_FrgPwd_004 extends BaseClass
{ 
	@Test(priority=6)
	public void FrgPwd() throws InterruptedException, IOException {
		/*Login Page*/
	LoginPage lp = new LoginPage(driver);
	lp.btnSigninID();
	logger.info("Click signin button to access authentation page");
	
	ForgotPwd Pwd = new ForgotPwd(driver);
	Pwd.lnkForgtPwd();
	logger.info("Click link - forgot password");
	
	SoftAssert SoftAssert = new SoftAssert();
	if (driver.getTitle().equals("Forgot your password - My Store")){
		logger.info("Successful access to -Forgot your password - My Store, page ");
		SoftAssert.assertTrue(true);
	}
		else{	// to capture screen on failure 
			captureScreen(driver,"FrgPwd");
			SoftAssert.assertTrue(false);
			logger.error("Error linking to - Forgot your password - My Store, page");
	}
	
	String email = randomestring() + "@gmail.com";
	lp.txtUsrEmail(email);
	logger.info("Enter user email");
	Pwd.btnRetPwd();
	logger.info("Click retrieve password button");
	
	String msg = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div")).getText();
	String result = "There is no account registered for this email address.";
	SoftAssert.assertEquals(msg, result);
	System.out.println(result);
	logger.info("Insert incorrect email ");
	Pwd.btnBckTLogin();
	logger.info("Click back to login button");
	
	if(driver.getTitle().equals("Login - My Store")) {
		SoftAssert.assertTrue(true);
		logger.info("Successful access to -Login - My Store, page ");
		driver.navigate().to(baseURL);
	}else {
		SoftAssert.assertTrue(false);
		captureScreen(driver,"FrgPwd");
		logger.error("Error linking to - Login - My Store - My Store, page");
	}
	
}  
	@Test(priority=7)
	public void verifyRtBtn() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		ForgotPwd Pwd = new ForgotPwd(driver);
		Pwd.lnkForgtPwd();
		logger.info("Click link - forgot password");
		// refresh page
		Thread.sleep(3000);
		XLUtils.refreshBrowserByJS(driver);	
		lp.txtUsrEmail(username);
		logger.info("Enter user email");
		Pwd.btnRetPwd();
		logger.info("Click retrieve password button");

		SoftAssert SoftAssert = new SoftAssert();
		String msg1 = driver.findElement(By.xpath("//p[@class='alert alert-success']")).getText();
		String result1 = "A confirmation email has been sent to your address: 123abc456@gmail.com";
		SoftAssert.assertEquals(msg1, result1);
		System.out.println(result1);
		SoftAssert.assertAll();
		
		
	}
}
