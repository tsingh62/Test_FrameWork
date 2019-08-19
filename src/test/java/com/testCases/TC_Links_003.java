package com.testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;


public class TC_Links_003 extends BaseClass {
	
	@Test(priority=5)
	public void linkChk() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		logger.info("Login with correct email and password");
		
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		
		/* Checking elements are  displayed */
		
		logger.info("Checking all text elements under \"ALREADY REGISTERED\" are displayed");
		lp.displayAuthRegtxt();
		logger.info("ALREADY REGISTERED - text diplayed");
		
		lp.displayEmailtxt();
		logger.info("Email address text - text diplayed");
		
		logger.info("Password text - text diplayed");
		lp.displayPwdtxt();
		
		logger.info("Check email text field is enabled");
		lp.vrfyTxtEmailfield();
		
		logger.info("Check password text field is enabled");
		lp.vrfyPwdfield();
		
		String title = XLUtils.getTitleByJS(driver);
		System.out.println(title);
		
		/*Checking link under "Already Registered section*/
		
		WebElement lnkPwdFgt= driver.findElement(By.xpath("//a[@href=\"http://automationpractice.com/index.php?controller=password\"]")); 
		/* Using href attribute to get the URL of the required link*/
		String url = lnkPwdFgt.getAttribute("href");
		URL link = new URL(url);
		/*Create a connection using URL object*/
		HttpURLConnection httpconn = (HttpURLConnection)link.openConnection();
		Thread.sleep(2000);
		/*Establish connection*/
		httpconn.connect();
		
		/*Response Code above 400 to see link is broken or not*/
		int respCode = httpconn.getResponseCode();
		if(respCode>=400) {
				System.out.println(" "+url + " - "+" Response code = "+respCode);
				captureScreen(driver, "linkChk");
				logger.info("link is broken");
				}else {
					System.out.println(" " + url + " - "+" Response code = "+respCode);
					logger.info("link is valid");
				}
		}
		
	}
	




