



package com.vocalize.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.base.Testbase;

import io.qameta.allure.Step;

public class Signuppage extends Testbase {

	
	//PageFactory
	//OR
	@FindBy(how=How.NAME,using="firstName")
	@CacheLookup
	static
	WebElement firstName;
	
	@FindBy(how=How.NAME,using="lastName")
	@CacheLookup
	static
	WebElement lastName;
	
	@FindBy(how=How.NAME,using="lastName")
	@CacheLookup
	static
	WebElement companyName;
	
	
	@FindBy(how=How.NAME,using="phoneNumber")
	@CacheLookup
	static
	WebElement phoneNumber;
	
	@FindBy(how=How.NAME,using="email")
	@CacheLookup
	static
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	@CacheLookup
	static
	WebElement password;
	
	@FindBy(how=How.NAME,using="confirmPassword")
	@CacheLookup
	static
	WebElement confirmPassword;
	
	@FindBy(how=How.NAME,using="tnc")
	@CacheLookup
	WebElement tnc;
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	@CacheLookup
	static
	WebElement register;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	@CacheLookup
	WebElement back;
	//page actions 
public void user_signup(String fn,String ln,String cn,String pn,String emaill,String passwordd,String confirmpasswordd) {
		
		firstName.clear();
		firstName.sendKeys(fn);
		lastName.clear();
		lastName.sendKeys(ln);
		companyName.clear();
		companyName.sendKeys(cn);
		phoneNumber.clear();
		phoneNumber.sendKeys(pn);
		email.clear();
		email.sendKeys(emaill);
		password.clear();
		password.sendKeys(passwordd);
		confirmPassword.clear();
		confirmPassword.sendKeys(confirmpasswordd);
		
	}

@Step("verifing the log in page title displayed step....")
public String gettitle() {
	return driver.getTitle();
}
	
	
}
	

	
	

