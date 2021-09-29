package com.InetBankingV1.TestCasess;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.InetBankingV1.PageObjects.LoginPage;
import com.InetBankingV1.Utilities.XLUtils;

public class TC_HomePage_002 extends BaseClass 
{
     @Test(dataProvider="LogInData")
     public void LogInDDT(String Username,String PassWord) throws InterruptedException
     {
    	 LoginPage lp=new LoginPage(driver);
    	 lp.SetUsername(Username);
    	 logger.info("user name provided");
    	 lp.SetPassWord(PassWord);
    	 logger.info("password is provided");
    	 lp.ClickLogIN();
    	 logger.info("click on login operation done");
    	 Thread.sleep(2000);
    	 
    	 //if the data is wrong then alert will open in WA
    	 if(isAlertPresent()==true)
    	 {    logger.info("login failed");
    		driver.switchTo().alert().accept();
    		 logger.info("alert is accepted");
    		driver.switchTo().defaultContent();//this one will open home page
    		 logger.info("naviggated to home page");
    		Assert.assertTrue(false);
    	 }
    	 else
    	 {
    		 Assert.assertTrue(true);
    		 logger.info("Login passed");
    		 Thread.sleep(2000);
    		 lp.LogOut();
    		 logger.info("click on log out button");
    		 driver.switchTo().alert().accept();
    		 logger.info("alert for log out rised and accepted");
    		 driver.switchTo().defaultContent();
    		 logger.info("navigated to home page");
    	 }
    	 
     }
     
     public boolean isAlertPresent()  //user difind methods to check whether alert is present or not
     {   try {
    	 driver.switchTo().alert();
    	 return true;
              }
     catch(NoAlertPresentException ex)
     {
    	 return false;
     }
     }
     
     
     
     
     
     @DataProvider(name="LogInData")
     String[][] getData() throws IOException
     {
    	 String path="C:\\Vishnu Projects\\New Projects\\InetBankingV1\\src\\test\\java\\com\\InetBankingV1\\TestData\\TestData one.xlsx";
    	 int rownum=XLUtils.getRowCount(path,"Sheet1");
    	 int colcount=XLUtils.getCellcount(path, "Sheet1",1);
    	 
    	 String LogInData[][]=new String[rownum][colcount];
    	 for(int i=1;i<=rownum;i++)
    	 {
    		 for(int j=0;j<colcount;j++)
    		 {
    			 LogInData[i-1][j]=XLUtils.getCellData(path, "Sheet1",i, j); 
    		 }
    	 }
    	 return LogInData;
     }
     
}
