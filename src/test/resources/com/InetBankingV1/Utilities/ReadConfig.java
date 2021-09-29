package com.InetBankingV1.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
     Properties prop;
    
     public ReadConfig()
     {try {
    	 File src=new File("C:\\Vishnu Projects\\New Projects\\InetBankingV1\\src\\test\\resources\\Configuration\\Config.Properties");
    	 FileInputStream Floc=new FileInputStream(src);
    	 prop=new Properties();
    	 prop.load(Floc);
          }
     catch(Exception ex)
     {
    	 System.out.print("Exception is:"+ex.getMessage());
     }
     }
     
     public String getappurl()
     {
    	 String url=prop.getProperty("APPURL");
    	 return url;
     }
     public String getappusername()
     {
    	 String uname=prop.getProperty("APPUserName");
    	 return uname;
     }
     public String getpassword()
     {
    	 String apassword=prop.getProperty("APPPassWord");
    	 return apassword;
     }
     public String getcdfileloc()
     {
    	 String CDF=prop.getProperty("CDriverFileLoc");
    	 return CDF;
     }
     public String getmdfileloc()
     {
    	 String Mdf=prop.getProperty("MDriverrFileloc");
    	 return Mdf;
     }
     
}
