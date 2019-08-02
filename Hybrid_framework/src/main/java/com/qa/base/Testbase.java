package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import org.openqa.selenium.OutputType;
import com.vocalize.util.TestUtill;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public Testbase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\vocalize\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			String driverPath = "config/";
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");	
			driver = new ChromeDriver(); 
			tdriver.set(driver);

			
		}
		else if(browserName.equals("Firefox")){
			String driverPath = "C:\\TestData\\";
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	public  static void failed(String testMethodName) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		try {
		FileUtils.copyFile(scrFile, new File("http://localhost:8080/job/VOCALZIE_GIT_REP/ws/Hybrid_framework/src/test/java/com/failed/screen_shots"+testMethodName+"_"+".jpg"));
	}
		catch(IOException e){
			e.printStackTrace();
		}
	
	}
	}