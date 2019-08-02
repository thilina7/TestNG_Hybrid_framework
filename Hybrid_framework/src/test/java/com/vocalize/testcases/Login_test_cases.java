package com.vocalize.testcases;
//che
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import static org.testng.Assert.fail;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.excel.utill.Xls_Reader;
import com.project.excell.loginexcell;
import com.qa.base.Testbase;
import com.vocalize.pages.login;
import com.vocalize.pages.Searchwormhole;

public class Login_test_cases extends Testbase {
	
	
	public Login_test_cases() {
		super();	
		
		}
	
	@BeforeMethod
	public void Setup (){
	initialization();
	}
	@Test(priority=01)
	public static void verify_Login_with_Incorrect_UP () {
		
		
		loginexcell k=new loginexcell();
		
		loginexcell.operations();
		
		WebDriverWait wait=new WebDriverWait(driver,30);       
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input [@class='form-control search-keyword']")));
		try {
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'title title-email')]")));
			wait.until(ExpectedConditions.urlToBe("http://52.53.129.233:81/search-for-wormholes"));
			System.out.println("User log in Pass");
		}
		catch (Exception e) {
			System.out.println("Userlog in interupted");
		}
		String actResult= "http://52.53.129.233:81/search-for-wormholes";
		
		Assert.assertFalse(driver.getCurrentUrl().contains(actResult),"User able to log in with invalid scenario");
			
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}

	
	
}

