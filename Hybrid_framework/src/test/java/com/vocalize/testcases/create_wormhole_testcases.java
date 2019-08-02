package com.vocalize.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.excell.loginexcell;
import com.qa.base.Testbase;
import com.vocalize.pages.Searchwormhole;
import com.vocalize.pages.login;
import com.vocalize.util.TestUtill;

//create_wormhole_testcases
public class create_wormhole_testcases extends Testbase{
	
	static SoftAssert softAssert=new SoftAssert();
	Searchwormhole searchpage= new Searchwormhole();
	public create_wormhole_testcases() {
		super();	
		
		}
	
	@BeforeMethod
	public void Setup (){
		initialization();
		login login=new login();
		login.login(prop.getProperty("username"),prop.getProperty("Password"));
		
		
				
	
	}
	/*
	@Test(priority=01)
	public void verifycorrectusername() {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Searchwormhole search=new Searchwormhole(); 
		
		
	}
	*/
	/*
	@Test(priority=01)
	public static void  verify_login_page_title () {
		
		WebDriverWait wait=new WebDriverWait(driver,12);		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn-empty create-wormhole-tips add-bid')]")));
		
		System.out.println("Validate the page title");
		String expResult="Vocalize";

		String actResult= driver.getTitle();


		Assert.assertEquals(expResult, actResult, "Titles are not matching");
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn btn-empty create-wormhole-tips add-bid")));
		
		
	/*
		login login_p=new login();
	boolean flag=login_p.validateVocalizeImage_display();
		Assert.assertTrue(flag);
		*/
	//create wormhole
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
			driver.findElement(By.xpath("//input[contains(@class,'form-control search-keyword')]")).sendKeys("lion beer");
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-buy-wormhole')]")));
		
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
			
			for(int i=1;i<=50;i++){
				
				String name = driver.findElement(By.xpath(before_xpath +i+ after_xpath)).getText();
				
				System.out.println(name);
				
				if(name.contains("MT")){ //i=6
					//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")));
					try {
				
						driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")).click();
						
				}
					catch (StaleElementReferenceException e) {
						System.out.print("state element ctach box");
						driver.navigate().refresh();
						driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr["+i+"]/td[6]/div/label")).click();
					}
					
					driver.findElement(By.xpath(".//*[contains(@class,'checkmark')]")).click();
					driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div/div/div[6]/button[2]")).click();
					
					//new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.urlToBe("http://52.53.129.233:81/checkout-wormhole-result"));
					//driver.findElement(By.id("checkoutLink")).click();
					
					
					
				}
			
			}
			
				//	driver.findElement(By.xpath(".//*[contains(@class,'form-control promo-code-input')]")).sendKeys("abc123");
			
			
			
			   
			
				
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
	
			
			
	
			
			
	/*
		login login_p=new login();
	boolean flag=login_p.validateVocalizeImage_display();
		Assert.assertTrue(flag);
		*/
	
	
	/*
	@Test(priority=03)
	public static void verify_Login_with_correct_UP () {
		
		try {
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@class,'title title-email')]")));
			
			WebDriverWait wait=new WebDriverWait(driver,15);  
			wait.until(ExpectedConditions.urlToBe("http://52.53.129.233:81/search-for-wormholes"));
			System.out.println("User Login Pass");
		}
		catch (Exception e) {
			
			System.out.println("User Log in  fail-catch-block");
		}
		String actResult= "http://52.53.129.233:81/search-for-wormholes";
		
		Assert.assertTrue(driver.getCurrentUrl().contains(actResult),"User not  able to login with correct username and password");
		
		/*login login_p=new login();
	String title=login_p.Validateloginpagetitle();
		Assert.assertEquals(title,"Vocalize","Title is not matched");
		}
		*/

	/*
	@Test(priority=04)
	public static void  create_wormhole () {
			
			WebDriverWait wait=new WebDriverWait(driver,10);		
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn btn-empty create-wormhole-tips add-bid')]")));
			
			
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'form-control search-keyword')]")));
			}
				catch (Exception e) {
					System.out.println("Search for wormhole catch block");
				}
				
				driver.findElement(By.xpath("//input[contains(@class,'form-control search-keyword')]")).clear();
				driver.findElement(By.xpath("//input[contains(@class,'form-control search-keyword')]")).sendKeys("Toyota");
				
				
				try {
				
							wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/button")));
				}
				catch (Exception e) {
					System.out.println("No create button-catch-block");
				}
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/button")).click();
				
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
					
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr[1]/td[6]/div/label")));
		}
		catch (Exception e) {
			System.out.println("check for check box");
		}
				//Assert.assertTrue(driver.getCurrentUrl().contains(actResult),"User not  able to go to lease page");
				
				//Method-1:
				String before_xpath = "//*[@id=\"root\"]/div/div/div[3]/div[1]/div/div[1]/table/tbody/tr[1]/td[5]/span";
				String after_xpath = "]/td[6]/div/label\"))";
				
				for(int p=1; p<=49; p++){
					String name = driver.findElement(By.xpath(before_xpath + p + after_xpath)).getText();
					System.out.println(name);
					if(name.contains("AL")){ //i=6
						//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
						driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/div[1]/div/div[1]/table/tbody/tr["+p+"]/td[6]/div/label")).click();
					}
				}
						driver.findElement(By.xpath(".//*[contains(@class,'checkmark')]")).click();
					//	driver.findElement(By.xpath(".//*[contains(@class,'form-control promo-code-input')]")).sendKeys("abc123");
						
						driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[4]/div/div/div[6]/button[2]")).click();
					
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
				
				
				
		
*/
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	
	
	
}