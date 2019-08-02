package com.vocalize.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.vocalize.util.TestUtill;

public class login extends Testbase {
//PageFactory
//OR
@FindBy(id="email")
@CacheLookup
WebElement username;

@FindBy(id="password")
@CacheLookup
WebElement password;

@FindBy(how=How.NAME,using="password")
@CacheLookup
WebElement password1;

@FindBy(how=How.LINK_TEXT,using="Sign Up")
@CacheLookup
WebElement signuplink;

@FindBy(how=How.LINK_TEXT,using="forgot password?")
@CacheLookup
WebElement forgotpassword;
@FindBy(xpath="//button[@type='submit']")
WebElement submit_b;

@FindBy(xpath="//button[contains(text(),'Sign Up')]")
@CacheLookup
WebElement signup;

@FindBy(xpath="//img[contains(@class,'class=\"navbar-brand navbar-brand\"')]")
@CacheLookup
WebElement logo;

//intializing the page objects
public login() {
	PageFactory.initElements(driver, this);
	
	// Use PageFactory to init elements.
	

}



public String  Validateloginpagetitle(){
	return driver.getTitle();
}

public boolean validateVocalizeImage_display() {
	return logo.isDisplayed();
	
}
public boolean validateVocalizeImage_enable() {
	return logo.isEnabled();
	
}
public void clear_textbox() {
	username.clear();
    password.clear();
	
}

public void refereshpage() {;
	driver.get("http://52.53.129.233:81/login");
	
}


/*
public Searchwormhole login(String UN,String PW) {
	driver.get("http://52.53.129.233:81/login");
	username.sendKeys(UN);
	password.sendKeys(PW);
	driver.manage().timeouts().implicitlyWait( 15,TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	submit_b.submit();
	return  new Searchwormhole();
	
	
	
	}
*/

public void  login(String UN,String PW) {
	driver.get("http://52.53.129.233:81/login");
	username.sendKeys(UN);
	password.sendKeys(PW);
	submit_b.submit();
	
	
	
	
	}



}