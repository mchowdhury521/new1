package com.qtp.selenium.app.saleforce.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webconnector {

	Logger APPLICATION_LOGS=Logger.getLogger("devpinoyLogger");
	Properties OR=null;
	Properties CONFIG=null;
	WebDriver driver =null;
	WebDriver mozilla=null;
	WebDriver chrome=null;
	WebDriver ie=null;
	static Webconnector w;
	
	private Webconnector(){
	  
	  if(OR==null){
		  try{
			  
			  OR=new Properties();
			  FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qtp\\selenium\\app\\saleforce\\config\\or.properties");
			  OR.load(fs);
			  CONFIG=new Properties();
			  fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\qtp\\selenium\\app\\saleforce\\config\\"+OR.getProperty("testenv")+"_config.properties");
			 CONFIG.load(fs);
		  }catch(Exception e){
		  System.out.println("file not found");
	  }
	  }
	}

	
	
   public void openbrowser(String browsertype){
	   if(browsertype.equals("Mozilla") && mozilla==null){
			driver = new FirefoxDriver();
			mozilla=driver;
		}else if(browsertype.equals("Mozilla") && mozilla!=null){
			driver=mozilla;
		}else if(browsertype.equals("Chrome") && chrome==null){
			System.setProperty("webdriver.chrome.driver", OR.getProperty("chromedriver.exe"));
			driver=new ChromeDriver();
			chrome=driver;
		}else if(browsertype.equals("Chrome") && chrome!=null){
			driver=chrome;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
	}
   public void navigate(String URL){
	   driver.get(CONFIG.getProperty("loginurl"));
		
	}

	
	public void click(String objectname){
		driver.findElement(By.xpath(OR.getProperty(objectname))).click();
		
	}
    public void type(String object, String text){
    	driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(text);
    	
		
	}
    
    
   public void select(String text, String objectname){
	   driver.findElement(By.xpath(OR.getProperty(objectname))).sendKeys(text);
		
	}
   
    public boolean isElementPresent(String objectname){
    	int count=driver.findElements(By.xpath(OR.getProperty(objectname))).size();
    	if(count==0)
    		return false;
    	else
    	return true;
    }
    
    
    public boolean isLogedin(){
    	if(isElementPresent("emailtext"))
    		return true;
    	else
    	return false;
    }
    
    public void doDefaultlogin(){
    	navigate("loginurl");
    	click("signinlink");
    	type(OR.getProperty("defaultusername"), "loginusername");
    	type(OR.getProperty("defaultpassword"), "loginpassword");
    	click("loginsubmit");
    	
    	
    }
    
    /********Singleton*********/
	public static Webconnector getInstance(){
		if(w==null)
			w= new Webconnector();
		
		return w;
	}
	
	/*************log**********************/
	public void log(String msg){
		//Logger.getLogger();
		APPLICATION_LOGS.debug(msg);
		
		
	
	}


	


}
