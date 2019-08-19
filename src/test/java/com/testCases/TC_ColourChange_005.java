package com.testCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;

public class TC_ColourChange_005 extends BaseClass
{
	@Test(priority=8)
	public void chgColor() throws InterruptedException, IOException {
	
	LoginPage lp = new LoginPage(driver);
	lp.btnSigninID();
	
	WebElement clr = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span"));
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(clr));
	
	XLUtils.scrollIntoview(clr, driver);
	XLUtils.flash(clr, driver);
	logger.info("Changes Color from green to black");
	
	XLUtils.drawBorder(clr, driver);
	captureScreen(driver, "chgColor");
	logger.info("Draws a border on the Sign in button");
	
	XLUtils.clickElementByJS(clr, driver);
	logger.info("Click on sign in button");
	
	logger.info("Genrate alert by clicking on login button"); 
	XLUtils.generateAlert(driver, "Sign in button clicked");
	
	Alert alert=driver.switchTo().alert();
	Thread.sleep(3000);
	String act_msg= alert.getText();
	
	if(act_msg.contains("Sign in button clicked"))
	{
		System.out.println("Test passed.....");
		logger.info("Button clicked");
	}
	else
	{
		System.out.println("Test failed.....");
		captureScreen(driver, "chgColor");
		logger.error("Error button not clicked");
	}
	
	
	}

}
