package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{
	
	@Test(priority=4,dataProvider="LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException {
		
		/*Login page */ 
		LoginPage lp = new LoginPage(driver);
		lp.btnSigninID();
		logger.info("Click signin button to access authentation page");
		
		lp.txtUsrEmail(user);
		logger.info("Enter user email");
		
		lp.txtPassword(pwd);
		logger.info("Enter password");
		
		lp.btnSignInHomeP();
		logger.info("Click on sign in button to access my account page");
	
		SoftAssert SoftAssert = new SoftAssert();
		if (driver.getTitle().equals("My account - My Store")){
			logger.info("login success");
			Thread.sleep(5000);
			lp.btnSignOut();
			SoftAssert.assertTrue(false);
			captureScreen(driver,"loginTest");
		}else {;
				logger.error("login is failed");
				SoftAssert.assertTrue(true);
				logger.info("Data driven testing negative data - user should not log in");;
		}
		lp.btnSignOut();
		logger.info("Click sign out button");
	
	}
	
			
	@DataProvider(name="LoginData") /*Two dimensional string type array*/
	 public String [][] getData() throws IOException
	 {
		logger.info("Starting data driven testing");
		String path=System.getProperty("user.dir")+"/src/test/java/com/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount]; 
		/*Starting from 1 since index 0 is the header part*/
		 for (int i=1; i<=rownum; i++){	
			 for(int j=0;j<colcount;j++) {/*increment the columns from 0// Since the col values start from index 0*/
			 		/*Get data from Xl and store in a 2 dim array*/
				 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			 }
		 }
		 return logindata;
	 }

}
		 

	