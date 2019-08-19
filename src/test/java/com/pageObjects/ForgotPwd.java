package com.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPwd 
{
	
	public WebDriver ldriver;
	
	public ForgotPwd (WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	/* Forgot Password Link */
	@FindBy(xpath="//a[@href=\"http://automationpractice.com/index.php?controller=password\"]")
	@CacheLookup
	WebElement lnkForgtPwd;
	
	
	public void lnkForgtPwd() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(lnkForgtPwd));
		lnkForgtPwd.click();
	}
	
	
	/*Check retrieve password*/
	@FindBy(xpath="//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span")
	@CacheLookup
	WebElement btnRetPwd;
	
	public void btnRetPwd() {
		try {
			System.out.println(btnRetPwd.isEnabled());
			btnRetPwd.click();
		}catch(NoSuchElementException e) {
			System.out.println("Retrieve button not found");
		}
	}
	
	/* CLick - back to login- button*/
	@FindBy(xpath="//span[contains(text(),'Back to Login')]")
	@CacheLookup
	WebElement btnBckTLogin;
	
	public void btnBckTLogin() {
		WebDriverWait wait = new WebDriverWait(ldriver,15);
		wait.until(ExpectedConditions.elementToBeClickable(btnBckTLogin));
		btnBckTLogin.click();
	}
	

	/* Checking if the page shows (sign in or sign out) */
	@FindBy(xpath="//a[@href=\"http://automationpractice.com/index.php?controller=my-account\"]")
	@CacheLookup
	WebElement btnSignIn;
	
	public void btnSignIn() {
		try {
			System.out.println(btnSignIn.getText());
			System.out.println("Sign in button present");
		}catch(Exception e) {
			System.out.println("The page shows sign out page instead of sign in");
		}
	}
}
