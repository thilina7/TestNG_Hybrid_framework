package com.vocalize.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.excel.utill.Xls_Reader;
import com.qa.base.Testbase;
public class TestUtill extends Testbase {
	public static long PAGE_LOAD_TIME_OUT=1000;
	//public static long IMPLICIT_WAIT=1000;
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]>getDatafromExcel(){
		ArrayList<Object[]> myData=new ArrayList <Object[]>();
	
		
		try {
		reader=new Xls_Reader("config/Last_table.xlsx");
		
		
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		for (int rowNum = 22; rowNum <= reader.getRowCount("signup");rowNum++) {
			String firstname =reader.getCellData("signup", "Firstname", rowNum);
			String lName =reader.getCellData("signup", "Lastname", rowNum);
			String cName =reader.getCellData("signup", "Companyname", rowNum);
			String pNumber =reader.getCellData("signup", "PhoneNumber", rowNum);
			String mail =reader.getCellData("signup", "Emailaddress", rowNum);
			String pass=reader.getCellData("signup", "Password", rowNum);
			String cPass=reader.getCellData("signup", "ConfirmPassword", rowNum);
			Object ob []= {firstname,lName,cName,pNumber,mail,pass,cPass};
			myData.add(ob);
			
			
	}
		return myData;	
	
	}
}