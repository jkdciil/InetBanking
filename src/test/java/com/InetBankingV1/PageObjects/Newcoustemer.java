package com.InetBankingV1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Newcoustemer 
{    
	WebDriver rdriver;
	
	
     public Newcoustemer(WebDriver ldriver)
     {
    	 rdriver=ldriver;
    	 PageFactory.initElements(ldriver,this);
     }
     
     @FindBy(how = How.PARTIAL_LINK_TEXT ,  using="Customer")
     @CacheLookup
     WebElement txtNewCostemer;
     
     @FindBy(how=How.NAME,using="name")
     @CacheLookup
     WebElement txtCoustemerName;
     
     @FindBy(how=How.XPATH,using="//input[@value='m']")
     @CacheLookup
     WebElement txtGender;
     
     @FindBy(how=How.XPATH,using="//input[@type='date']")
     @CacheLookup
     WebElement txtDate;
     
     @FindBy(how=How.NAME,using="dob")
     @CacheLookup
     WebElement txtMonth;
     
     @FindBy(how=How.ID,using="dob")
     @CacheLookup
     WebElement txtYear;
     
     @FindBy(how=How.NAME,using="addr")
     @CacheLookup
     WebElement txtAddress;
     
     @FindBy(how=How.NAME,using="city")
     @CacheLookup
     WebElement txtCity;
     
     @FindBy(how=How.NAME,using="state")
     @CacheLookup
     WebElement txtState;
     
     @FindBy(how=How.NAME,using="pinno")
     @CacheLookup
     WebElement txtPIN;
     
     @FindBy(how=How.NAME,using="telephoneno")
     @CacheLookup
     WebElement txtMobileNumber;
     
     @FindBy(how=How.NAME,using="emailid")
     @CacheLookup
     WebElement txtEmailID;
     
     @FindBy(how=How.NAME,using="password")
     @CacheLookup
     WebElement txtPassWord;
     
     @FindBy(how=How.NAME,using="sub")
     @CacheLookup
     WebElement txtSUBMIT;
     
     
     public void NewCoustemer()
     {
    	 txtNewCostemer.click();
     }
     
     public void Coustemer(String Cn)
     {
    	 txtCoustemerName.sendKeys(Cn);
     }
     
     public void Gender()
     {
    	 txtGender.click();
     }
     
   /* public void Date(String De,String Mh,String Yr)
     {
    	 txtDate.sendKeys(De);
    	 txtMonth.sendKeys(Mh);
    	 txtYear.sendKeys(Yr);
     }*/
     
     public void Address(String As)
     {
    	 txtAddress.sendKeys(As);
     }
     
     public void City(String Cy)
     {
    	 txtCity.sendKeys(Cy);
     }
     
     public void State(String Se)
     {
    	 txtState.sendKeys(Se);
     }
     
     public void PIN(String PN)
     {
    	 txtPIN.sendKeys(PN);
     }
     
     public void MobileNumber(String MN)
     {
    	 txtMobileNumber.sendKeys(MN);
     }
     
     public void EmailID(String EI)
     {
    	 txtEmailID.sendKeys(EI);
     }
     
     public void PassWord(String PWD)
     {
    	 txtPassWord.sendKeys(PWD);
     }
     
     public void Submit()
     {
    	 txtSUBMIT.click();
     }

	public void Date(String de, String mh, String yr) 
	{
		txtDate.sendKeys(de);
		txtDate.sendKeys(mh);
		txtDate.sendKeys(yr);
		
		
	}
}
