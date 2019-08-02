package com.vocalize.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;
import com.vocalize.util.TestUtill;


import com.qa.base.Testbase;

public class Searchwormhole extends Testbase {
	
	
	@FindBy(xpath="//textbox[@type='text']")
	@CacheLookup
	static
	WebElement searchwormhole;
	
	@FindBy(xpath="//td[contains(text('c. kkkk')]")
	@CacheLookup
	static
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[text()='My Wormholes']")
	@CacheLookup
	static
	WebElement mywormholeslink;
	
	@FindBy(xpath="//td[contains(text('My Current  Bids')]")
	@CacheLookup
	static
	WebElement mycurrentbidlink;
	
	@FindBy(xpath="//img[contains(@class,'vocalize-logo')]")
	@CacheLookup
	WebElement logo;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-empty create-wormhole-tips add-bid')]")
	@CacheLookup
	public
	static
	WebElement tooltip;
	
	public  Searchwormhole() {
		PageFactory.initElements(driver, this);
	}
	
	public  static void lease(String leaseword) {
		searchwormhole.sendKeys(leaseword);

		}
	
	public  static my_wormholes clickmywormhole() {
		mywormholeslink.click();
		return new  my_wormholes();

		}
	public  static mycurrentbid clickmycurrentbid(){
		mycurrentbidlink.click();
		return new  mycurrentbid();

		}
	
	public boolean verifyusername(){
		return usernamelabel.isDisplayed();
		
	}
	public static String tooltip() {
		return tooltip.getText();
	}
	
	
	public boolean validateVocalizeImage_display() {
		return logo.isDisplayed();
		
	}
}
