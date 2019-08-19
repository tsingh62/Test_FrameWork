package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	// Properties Class
	Properties pro; 
	
	// Constructor
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
			// Creating File object
		try 
		{
			// Open FileInputStream and Read data 
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // Load config.properties file
		} 
		catch (Exception e) 
		{	
			// If config.properties file is not available it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// Methods to read data from config.properties 
	public String getApplicationURL()                           
	{
		String url=pro.getProperty("baseURL"); // Value from config.properties stored in url variable
		return url;
	}
		
	public String getUseremail()
	{
		String username=pro.getProperty("useremail");
		return username;
	}
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getPassword1()
	{
		String password1=pro.getProperty("password1");
		return password1;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
