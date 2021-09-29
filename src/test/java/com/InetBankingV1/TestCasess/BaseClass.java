package com.InetBankingV1.TestCasess;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.InetBankingV1.Utilities.ReadProperties;


public class BaseClass 
{    
	ReadProperties Rp=new ReadProperties();
	
	
	
	public String BaseUrl=Rp.getURL();
	public String Username=Rp.getUserName();
	public String PassWord=Rp.getPassword();
    public static WebDriver driver;
    public static Logger logger;
     
   @Parameters("browser")
   @BeforeClass
   public void Before(String browser)
   {
	   logger=Logger.getLogger(BaseClass.class);
	   PropertyConfigurator.configure("Log4j.Properties");
	   
  		logger.info("Launching Browser");
  		
  		if(browser.equals("chrome"))
  		{ 
  			System.setProperty("webdriver.chrome.driver","C:\\Vishnu Projects\\New Projects\\InetBankingV1\\src\\test\\resources\\Drivers\\chromedriver.exe");
	   		driver=new ChromeDriver();
	   	}
  		else if(browser.equals("ie"))
  		{
  			System.setProperty("browser.ie.driver","C:\\Vishnu Projects\\New Projects\\InetBankingV1\\src\\test\\resources\\Drivers\\msedgedriver.exe");
  			driver=new InternetExplorerDriver();
  		}
  		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  		//WebDriverWait wait=new WebDriverWait();//explicitly
  		driver.get(BaseUrl);
	   		
   }
   @AfterClass
   public void After()
   {
	   driver.close();
	   logger.info("window closed");
   }
   
   public void captureScreen(WebDriver driver,String tname) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot)driver;//we need to convert webdriver object to takescreenshot object
	   File source=ts.getScreenshotAs(OutputType.FILE);//we need to store the screen shot in temparary location
	   File target=new File(System.getProperty("user.dir")+"//ScreenShots//"+tname+".png");
	   FileUtils.copyFile(source, target);//we need to move the screen shot from temporary location to permanent location
	   System.out.println("ScreenShot Taken");
	   
   }
   
  /* public String RnadomAlphabet()
   {
	   String Ralphabet=RandomStringUtils.randomAlphabetic(6);
	   return Ralphabet;
   }
   
   public String RandomNumeric()
   {
	   String Rnumeric=RandomStringUtils.randomNumeric(3);
	   return Rnumeric;
   }*/
   
   
}
