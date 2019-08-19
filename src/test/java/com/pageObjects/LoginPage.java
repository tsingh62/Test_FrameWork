package com.pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.XLUtils;

public class LoginPage 
{
	
	
	public WebDriver ldriver;
	
	/*Constructor - invoked at the time of object creation*/
	public LoginPage (WebDriver rdriver) { // driver parameter 
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this); 
		// This represents, the particular page object
	}
	
	/*Elements and methods for Sign in and Authentication Page*/
	
	/* Sign in button  to  open Authentication Page*/
	@FindBy(xpath="//a[@class='login']")
	@CacheLookup
	WebElement btnSigninID;
	
	public void btnSigninID() {
		WebDriverWait wait = new WebDriverWait (ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnSigninID));
		btnSigninID.click();
	}
	
	
	/*User Email - to login*/
	@FindBy(xpath="//input[@id='email']")
	@CacheLookup
	WebElement txtUsrEmail;
	
	public void txtUsrEmail(String uemail) {
		WebDriverWait wait = new WebDriverWait (ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtUsrEmail));
		Actions actions = new Actions(ldriver);
		// Clearing text field 
		actions.click(txtUsrEmail)
		    	.keyDown(Keys.CONTROL)
		    	.sendKeys("a")
		    	.keyUp(Keys.CONTROL)
		    	.sendKeys(Keys.BACK_SPACE)
		    	.build()
		    	.perform();
				txtUsrEmail.sendKeys(uemail);	
	}
	
	/*To verify email text box is - enabled or disabled*/
	public void vrfyTxtEmailfield() {
		try {
			System.out.println(" "+txtUsrEmail.isEnabled());
		}catch (NoSuchElementException e) {
			System.out.println("Element not found " +e.getMessage());
		}
	}
	
	/*Email address text display*/
	@FindBy(xpath="//*[@id=\"login_form\"]/div/div[1]/label")
	@CacheLookup
	WebElement displayEmailtxt;
	
	public void displayEmailtxt() {
		try {
			System.out.println(" " +displayEmailtxt.isDisplayed());
		}catch(NoSuchElementException e) {
			System.out.println(" Element not displayed  " +e.getMessage());
		}
		
	}
	/*Password */ 
	@FindBy(xpath="//*[@id=\"passwd\"]")
	@CacheLookup
	WebElement txtPassword;
	
	public void txtPassword(String pwd) {
		WebDriverWait wait = new WebDriverWait (ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
		Actions actions = new Actions(ldriver);
		// Clearing text field  
		actions.click(txtPassword)
				.keyDown(Keys.CONTROL)
				.sendKeys("a")
				.keyUp(Keys.CONTROL)
				.sendKeys(Keys.BACK_SPACE)
				.build()
				.perform();
				txtPassword.sendKeys(pwd);
	}
	/*Password text field - enabled or disabled*/
	public void vrfyPwdfield() {
		try {
			System.out.println(" " +txtPassword.isDisplayed());
		}catch(NoSuchElementException e) {
			System.out.println(" Element not displayed  " +e.getMessage());
		}
	}

	/*Password text display*/
	@FindBy(xpath="//*[@id=\"login_form\"]/div/div[2]/label")
	@CacheLookup
	WebElement displayPwdtxt;
	
	public void displayPwdtxt() {
		try {
			System.out.println(" " +displayPwdtxt.isDisplayed());
		}catch(NoSuchElementException e) {
			System.out.println(" Element not displayed  " +e.getMessage());
		}
		
	}
	
	/*Sign in Button for User Login*/
	@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
	@CacheLookup
	WebElement btnSignInHomeP;
	
	public void btnSignInHomeP() {
		btnSignInHomeP.click();
	}
	
	/*Check sign in button is - enabled or disabled*/
	public void vrfyBtnSignInHomeP() {
		try {
			System.out.println(" " +btnSignInHomeP.isDisplayed());
		}catch(NoSuchElementException e) {
			System.out.println(" Element not displayed  " +e.getMessage());
		}
	}
	
	public void colorChge() {
		XLUtils.flash(btnSignInHomeP, ldriver);
		XLUtils.drawBorder(btnSignInHomeP, ldriver);
	}
	
	
	
	/*Sign out button*/
	@FindBy(xpath="//a[@class='logout']")
	@CacheLookup
	WebElement btnSignOut;
	
	public void btnSignOut() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btnSignOut));
		btnSignOut.click();
	}
	

	/*Authentication registered text display*/
	@FindBy(xpath="//*[@id=\"login_form\"]/h3")
	@CacheLookup
	WebElement displayAuthRegtxt;
	
	public void displayAuthRegtxt() {
		try {
			System.out.println(" " +displayAuthRegtxt.isDisplayed());
		}catch(NoSuchElementException e) {
			System.out.println(" Element not displayed  " +e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////
	/*Authentication Failed*/
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")
	@CacheLookup
	WebElement msgAuthFail;
	
	public void msgAuthFail() {
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		wait.until(ExpectedConditions.visibilityOf(msgAuthFail));
		System.out.println(msgAuthFail.getText());
		
	}

	/*Missing email*/
	@FindBy(xpath="//li[contains(text(),'An email address required.')]")
	@CacheLookup
	WebElement msgInvalidEmail;
	
	public void msgInvalidEmail(){
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		wait.until(ExpectedConditions.visibilityOf(msgInvalidEmail));
		System.out.println(msgInvalidEmail.getText());
				
	}
	
	/*Incorrect email format*/
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	@CacheLookup
	WebElement msgWrngEmailFormat;
	
	public void msgWrngEmailFormat() {
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		wait.until(ExpectedConditions.visibilityOf(msgWrngEmailFormat));
		System.out.println(msgWrngEmailFormat.getText());
	}
	
	/*Incorrect Password*/
	@FindBy(xpath="//li[contains(text(),'Invalid email address.')]")
	@CacheLookup
	WebElement msgWrngPwd;
	
	public void msgWrngPwd() {
		WebDriverWait wait = new WebDriverWait(ldriver,30);
		wait.until(ExpectedConditions.visibilityOf(msgWrngPwd));
		System.out.println(msgWrngPwd.getText());
	} 
	
}


