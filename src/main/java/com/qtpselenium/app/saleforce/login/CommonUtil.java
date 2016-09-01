package com.qtpselenium.app.saleforce.login;

import com.qtp.selenium.app.saleforce.util.Webconnector;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CommonUtil {
	Webconnector selenium=Webconnector.getInstance();
	

	@And("^i click in \"([^\"]*)\" button$")
	public void i_click_button(String object){
		System.out.println(" i click on  "+object);
		selenium.click(object);
	}
	
	@And("^i click on \"([^\"]*)\"$")
	public void i_click(String object){
		System.out.println(" i click on  "+object);
		selenium.click(object);
	}
	
	@Given("^Runmode is \"([^\"]*)\"$")
	
	public void Runmode_is(String runmode){
		if(runmode.equalsIgnoreCase("N"))
			throw new PendingException("skipping test");
		
	}
	
}
