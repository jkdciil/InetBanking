package com.InetBankingV1.TestCasess;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.InetBankingV1.PageObjects.LoginPage;

public class TC_HomePage_001 extends BaseClass
{
	
	
	
	@Test
	public void TstOne() throws IOException, InterruptedException
	{
		logger.info("navigated to url");
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(Username);
		logger.info("username have been provided");
		Thread.sleep(2000);
		lp.SetPassWord(PassWord);
		logger.info("password have been provided");
		Thread.sleep(2000);
		lp.ClickLogIN();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("our test case passed");
		}
		else
		{   captureScreen(driver,"LoginTest");
			Assert.assertTrue(false, "Page title not mached");
		
		}
		Thread.sleep(5000);
		logger.info("clicking operation has been completed");
	}
}
