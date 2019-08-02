package com.vocalize.testcases;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.Testbase;
import com.vocalize.pages.Searchwormhole;
import com.vocalize.pages.login;

public class lease_wormhole_testcases extends Testbase{
	static SoftAssert softAssert=new SoftAssert();
	Searchwormhole searchpage= new Searchwormhole();
	public lease_wormhole_testcases() {
		super();	
		
		}
	
	@BeforeMethod
	public void Setup (){
		initialization();
		login login=new login();
		login.login(prop.getProperty("username"),prop.getProperty("Password"));
		
		
				
	
	}

	@Test(priority=02)
public static void  lease_wormhole () throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,20);		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn-empty create-wormhole-tips add-bid')]")));
		
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'form-control search-keyword')]")));
		}
			catch (Exception e) {
				System.out.println("Search for wormhole catch block");
			}
			
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-keyword')]")).clear();
			
			//Lease wormhole key word enter here
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-keyword')]")).sendKeys("dara");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div[1]/div[2]/button")));
		
			//buy wormhole button enter here
			
			try {
				
			driver.findElement(By.xpath("//button[contains(@class,'btn btn-buy-wormhole')]")).click();
			
			}
			catch (StaleElementReferenceException e) {
				System.out.println("No lease button-catch-block");
				driver.findElement(By.xpath("//button[contains(@class,'btn btn-buy-wormhole')]")).click();
				
			}
			
		
			try {
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'title title-email')]")));
				wait.until(ExpectedConditions.urlToBe("http://52.53.129.233:81/checkout-wormhole"));
				System.out.println("Redirecting to lease page ");
			}
			catch (Exception e) {
				System.out.println("lease fail-catch-block");
			}
			String actResult= "http://52.53.129.233:81/checkout-wormhole";
			try {
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div/div/input")));
	}
	catch (Exception e) {
		System.out.println("check for check box");
	}
			//Assert.assertTrue(driver.getCurrentUrl().contains(actResult),"User not  able to go to lease page");
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td[5]/span")));
			//Method-1:
			String before_xpath = "//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr[";
			String after_xpath = "]/td[5]/span";
			
			for(int i=1;i<=45;i++){
				
				try {
					String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
					System.out.println(name);
					  if(name.contains("IL")){ //i=6
							//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")));
							try {
						
								driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")).click();
								
						}
							catch (StaleElementReferenceException e) {
								System.out.print("state element ctach box");
								driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")).click();
							}
		 				}
			      }
				
			 catch (NoSuchElementException ignored) {
			       System.out.print("_No such element catch box_");
			     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'checkmark')]")));
			       //driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label"));
			       
			 }
			}
				driver.findElement(By.xpath(".//*[contains(@class,'checkmark')]")).click();
				
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/div/div[6]/button[2]")).click();  
			
			
			
			   
			
				
					String actResult01= "http://52.53.129.233:81/checkout-wormhole-result";
					
					try {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[2]/div/div[7]/button[2]")));
						//wait.until(ExpectedConditions.urlToBe("http://52.53.129.233:81/checkout-wormhole-result"));
						System.out.println("Redirecting to success page  ");
					}
					catch (Exception e) {
						System.out.println("lease success catch block");
					}
					
					
					
					
					Assert.assertTrue(driver.getCurrentUrl().contains(actResult01),"Lease wormhole purchase unsuccessfull");
				
				}
	
			
			
	
			
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
}
