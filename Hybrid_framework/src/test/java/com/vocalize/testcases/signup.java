package com.vocalize.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.testng.asserts.SoftAssert;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.project.excell.loginexcell;
//import com.project.excell.sign_up_excell;
import com.qa.base.Testbase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vocalize.pages.Signuppage;
import com.vocalize.pages.login;
//import com.vocalize.pages.Signuppage;
import com.vocalize.util.TestUtill;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

//@Listeners(CustomListners.class)
public class signup extends Testbase {

	Signuppage signup01=PageFactory.initElements(driver,Signuppage.class);
	
	public signup() {
		super();	
		
		}
	
	
	
	@BeforeMethod
	public void Setup (){
	initialization();
	}
	

	@DataProvider
	
	public Iterator<Object[]>getTestData(){
		ArrayList<Object[]> testData=TestUtill.getDatafromExcel();
		return testData.iterator();
		
	}
	
	@Test( priority=1 ,dataProvider="getTestData" ,description = "verifying_the_invalid_signup_testcases")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify the sign up with invalid data")
	@Story("Story Name: To check the sign up")
	public void Verify_signup_with_invalid_Details(String Firstname, String LastName, String Companyname,String PhoneNumber,String Emailaddress,String Password, String ConfirmPassword) {
		
		WebDriverWait wait=new WebDriverWait(driver,15);  
		try {
			driver.get("http://52.53.129.233:81/signup");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Register')]")));
		}
		catch (Exception e) {
			System.out.println("Sign page not found-catch-block");	
		}
	//signup01.user_signup(Firstname,LastName,Companyname,PhoneNumber,Emailaddress,Password,ConfirmPassword);
		
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.name("firstName")).sendKeys(Firstname);
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(LastName);
		driver.findElement(By.name("companyName")).clear();
		driver.findElement(By.name("companyName")).sendKeys(Companyname);
		driver.findElement(By.name("phoneNumber")).clear();
		driver.findElement(By.name("phoneNumber")).sendKeys(PhoneNumber);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(Emailaddress);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.name("confirmPassword")).clear();
		driver.findElement(By.name("confirmPassword")).sendKeys(ConfirmPassword);
		driver.findElement(By.xpath(".//*[contains(@class,'checkmark')]")).click();
		driver.findElement(By.xpath(".//*[contains(@type,'submit')]")).click();
		
		try {
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'title title-email')]")));
			wait.until(ExpectedConditions.urlToBe("http://52.53.129.233:81/email-verification"));
			System.out.println("User Regisration Pass");
		}
		catch (Exception e) {
			System.out.println("User Regisration fail-catch-block");
		}
		String actResult= "http://52.53.129.233:81/signup";
		
		Assert.assertTrue(driver.getCurrentUrl().contains(actResult),"User not  able to register");
		
		
		}
	
	/*
	@Test
	public void asserttrue() {
		
			extentTest = extent.startTest("freemCRMLogoTest");
			boolean b = driver.findElement(By.xpath("//img[@class='img-responsive111']")).isDisplayed();
			Assert.assertTrue(b);
		}
		*/
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
}
