package com.InetBankingV1.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReport extends TestListenerAdapter
{
    
     public ExtentReports extent=new ExtentReports();
     public ExtentTest logger;
      
     
     public void onstart(ITestContext testContext)
     {
    	 String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
    	 String repName="Test-Report-"+timeStamp+".html";
    	 ExtentHtmlReporter htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
    	 htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/Extent.config.xml");
    	 
    	// extent=new ExtentReports();
    	 
    	 extent.attachReporter(htmlreporter);
    	 extent.setSystemInfo("hostName","localhost");
    	 extent.setSystemInfo("Environment","QA");
    	 extent.setSystemInfo("user","Vishnu");
    	 
    	 htmlreporter.config().setDocumentTitle("InetBanking TestProject");
    	 htmlreporter.config().setReportName("Functional Test Report");
    	 htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of chart
    	 htmlreporter.config().setTheme(Theme.DARK);
     }
     public void onTestSuccess(ITestResult tr)
     {
    	 logger=extent.createTest(tr.getName());//create new entry in the report
    	 logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
    	 
     }
     
     public void onTestFailure(ITestResult tr)
     {
    	 logger=extent.createTest(tr.getName());//create new entry in the report
    	 logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
    	 
    	 String screenshotpath=System.getProperty("user.dir")+"\\ScreenShots\\"+tr.getName()+".png";
    	 File f=new File(screenshotpath);
    	 
    	 if(f.exists())
    	 {
    		 try {
    			 logger.fail("ScreenShot is below:" +logger.addScreenCaptureFromPath(screenshotpath));
    		 }
    		 catch(Exception ex)
    		 {
    			 ex.printStackTrace();
    		 }
    	 }
    	 
     }
     
     public void onTestSkipped(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());
		 logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	 }
     
     public void onFinish(ITestContext testcontext)
     {   
    	 extent.flush();
     }
     
}
