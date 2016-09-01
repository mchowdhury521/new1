package com.qtpselenium.app.saleforce.login;

import org.testng.Assert;

import com.qtp.selenium.app.saleforce.util.Webconnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login {
	Webconnector selenium=Webconnector.getInstance();
	
	@Given("^i go to \"([^\"]*)\" on \"([^\"]*)\"$")
	
	public void i_go_salesforce(String url, String browser){
		selenium.log("executing test");
		System.out.println(" i am going sales force "+url+"  on  "+browser);
		selenium.openbrowser(browser);
		selenium.navigate(url);
		
		selenium.log("able to open browser"+url);
	}
	
	
	@And("^i enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_enter(String object, String text ){
		System.out.println(" i enter "+object+" on  "+text);
		selenium.log("able to click"+object);
		selenium.type(object, text);
	}
	
	
	
	public void login_success(String expectedresult){
		selenium.log(" login is "+ expectedresult);
		boolean result=selenium.isElementPresent("emailtext");
		String actualresult=null;
		if(result)
			actualresult="success";
		else
			actualresult="failure";
		Assert.assertEquals(expectedresult, actualresult);
	}

}
