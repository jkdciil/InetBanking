package com.InetBankingV1.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
     public static FileInputStream fi;
     public static FileOutputStream fo;
     public static XSSFWorkbook wb;
     public static XSSFSheet ws;
     public static XSSFRow row;
     public static XSSFCell cell;
     
     public static int getRowCount(String xlfile,String xlsheet) throws IOException
     {
    	 fi=new FileInputStream(xlfile);
    	 wb=new XSSFWorkbook(fi);
    	 ws=wb.getSheet(xlsheet);
    	 int rowcount=ws.getLastRowNum();
    	 wb.close();
    	 fi.close();
    	 return rowcount;
    	 
     }
     public static int getCellcount(String xlfile,String xlsheet,int rownum) throws IOException
     {
    	 fi=new FileInputStream(xlfile);
    	 wb=new XSSFWorkbook(fi);
    	 ws=wb.getSheet(xlsheet);
    	 row=ws.getRow(rownum);
    	 int cellcount=row.getLastCellNum();
    	 wb.close();
    	 fi.close();
    	 return cellcount;
    	 
     }
     public static String getCellData(String xlfile,String xlsheet,int rownum,int coloum) throws IOException
     {
    	 fi=new FileInputStream(xlfile);
    	 wb=new XSSFWorkbook(fi);
    	 ws=wb.getSheet(xlsheet);
    	 row=ws.getRow(rownum);
    	 cell=row.getCell(coloum);
    	 String Data;
    	 try
    	 {
    		 DataFormatter formatter=new DataFormatter();
    		 String celldata=formatter.formatCellValue(cell);
    		 return celldata;
    	 }
    	 catch(Exception ex)
    	 {
    		Data="";
    	 }
    	 wb.close();
    	 fi.close();
    	 return Data;
   
     }
     public static void setCellData(String xlfile,String xlsheet,int rownum,int coloum,String data) throws IOException
     {
    	 fi=new FileInputStream(xlfile);
    	 wb=new XSSFWorkbook(fi);
    	 ws=wb.getSheet(xlsheet);
    	 row=ws.getRow(rownum);
    	 cell=row.getCell(coloum);
    	 cell.setCellValue(data);
    	 fo=new FileOutputStream(xlfile);
    	 wb.write(fo);
    	 wb.close();
    	 fi.close();
    	 fo.close();
     }
}
