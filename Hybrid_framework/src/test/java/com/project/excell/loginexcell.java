package com.project.excell;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;import com.excel.utill.Xls_Reader;
import com.qa.base.Testbase;
import com.vocalize.pages.login;
import com.vocalize.pages.Searchwormhole;
import com.excel.utill.Xls_Reader;
import com.qa.base.Testbase;
import com.vocalize.pages.login;

public class loginexcell extends Testbase {
	static Xls_Reader excell=new Xls_Reader("C:\\Users\\DELL\\Desktop\\Last_table.xlsx");
	public static void operations() {
	int rowcount1=excell.getRowCount("login");
	
	for(int rownum=2;rownum<=rowcount1;rownum++) {
		login home=PageFactory.initElements(driver,login.class);

		
		String UN =excell.getCellData("login", "username", rownum);
		String PW =excell.getCellData("login", "password", rownum);
		try {
			home.login(UN,PW);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		home.clear_textbox(); 
	//	WebDriverWait wait=new WebDriverWait(driver,05);
		
		//wait.until(ExpectedConditions.urlContains("http://54.176.59.138/ro/offers"));
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-container")));
		/*
		if(driver.getCurrentUrl().equals("http://52.53.129.233:81/login")) {
		excell.setCellData("login","State",rownum, "Pass");
		}
		else {
			excell.setCellData("login","State",rownum, "Fail");	
		}
		*/
		
	
	}
	
	}
	
}


