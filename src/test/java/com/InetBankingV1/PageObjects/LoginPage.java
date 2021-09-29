package com.InetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   WebDriver ldriver;
  public LoginPage(WebDriver rdriver)
   {
	   ldriver=rdriver;
	   PageFactory.initElements(rdriver,this);
   }
   
   
   @FindBy(name="uid")
   WebElement txtUserName;
   
   @FindBy(name="password")
   WebElement txtPassWord;
   
   @FindBy(name="btnLogin")
   WebElement txtLogIn;
   
   @FindBy(partialLinkText="out")
   WebElement txtLogOut;
   
   
   public void SetUsername(String Uname)
   {
	   txtUserName.sendKeys(Uname);
   }
   
   public void SetPassWord(String pwd)
   {
	   txtPassWord.sendKeys(pwd);
   }
   
   public void ClickLogIN()
   {
	   txtLogIn.click();
   }
   
   public void LogOut()
   {
	   txtLogOut.click();
   }
}
