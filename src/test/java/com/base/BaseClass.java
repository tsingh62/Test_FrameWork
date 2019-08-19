 package com.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.ReadConfig;

public class BaseClass 
{
	ReadConfig  readconfig = new ReadConfig(); // Creating object
	
						// Integrating data from ReadConfig
	public String baseURL=readconfig.getApplicationURL(); 
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword(); // correct password
	public String password1=readconfig.getPassword1(); // incorrect passowrd

	
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser") 
	@BeforeClass
	public void setup(String br) // browser value into br from TextNG.xml
//	public void setup()
	
	{		
		
		logger=Logger.getLogger("automationpractice.com/index.php");// Project Name 
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		// Initialization // Logger initiated within the setup method
		
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
	
		/* Browser test without passing parameter */
		
		/*
		 * System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		driver.get(baseURL);
        driver.manage().window().maximize(); 
		logger = Logger.getLogger("automationpractice.com/index.php");
		PropertyConfigurator.configure("Log4j.properties"); 
		 * */
		
		

		if(br.equalsIgnoreCase("chrome"))
		{
										
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();		//getting Chrome path from readcong and configProperties
		driver.get(baseURL);
		logger.info("Opening base URL - in Chrome");
		
		}
		
		else if (br.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			driver.get(baseURL);
			logger.info("Opening base URL - in FireFox");
		}
		
		// implicit Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();  // maximize browser
			
	}
	
	@AfterClass
	public void tearDown()
	{
	//	driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); 
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(6);// generate random digits with the specified values passed
		return (generatedString2);
	}
	
}