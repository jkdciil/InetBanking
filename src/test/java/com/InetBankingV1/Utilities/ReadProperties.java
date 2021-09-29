package com.InetBankingV1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties 
{
   Properties prop;
	public ReadProperties()
	{ 
		
try {
		
		File src=new File("./config/Properties");
		FileInputStream flo=new FileInputStream(src);
	    prop=new Properties();
	    prop.load(flo);
	}
	catch(Exception ex)
	{
		System.out.println("Exception is:"+ex.getMessage());
	}
	
	}
	public String getURL()
	{
		String Url=prop.getProperty("BaseURL");
		return Url;
	}
	public String getUserName()
	{
		String Uname=prop.getProperty("UserName");
		return Uname;
	}
	public String getPassword()
	{
		String pass=prop.getProperty("PassWord");
		return pass;
	}
	public String getCDFL()
	{
		String cdfloc=prop.getProperty("CDFL");
		return cdfloc;
	}
	public String getGDFL()
	{
		String gdfloc=prop.getProperty("GDFL");
		return gdfloc;
	}
	public String getMDFL()
	{
		String mdfloc=prop.getProperty("MDFL");
		return mdfloc;
	}
	
}
