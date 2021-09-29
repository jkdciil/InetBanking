package com.InetBankingV1.TestCasess;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.InetBankingV1.PageObjects.LoginPage;
import com.InetBankingV1.PageObjects.Newcoustemer;

public class TC_HomePage_003 extends BaseClass
{
     String email=RnadomAlphabet()+"@gmail.com";
	
	@Test
	public void FillCustumerDetails() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		          lp.SetUsername(Username);
		          lp.SetPassWord(PassWord);
		          lp.ClickLogIN();
	 Newcoustemer NewC=new Newcoustemer(driver);
	              NewC.NewCoustemer();
	              NewC.Coustemer("VIshnu");
	              NewC.Gender();
	              NewC.Date("22","07","1996");
	              Thread.sleep(2000);
	              NewC.Address("asdfghjklpoiuytrewq zxxcvbnm");
	              NewC.City("Nandyal");
	              NewC.State("AP");
	              NewC.PIN("518500");
	              NewC.MobileNumber("9989917442");
	              NewC.EmailID(email);
	              NewC.PassWord("Vishnu001");
	              NewC.Submit();
	              
	}

	private String RnadomAlphabet() {
		 String Ralphabet=RandomStringUtils.randomAlphabetic(6);
		   return Ralphabet;
	}
	

}
