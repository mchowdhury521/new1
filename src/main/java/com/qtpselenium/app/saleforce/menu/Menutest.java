package com.qtpselenium.app.saleforce.menu;

import org.junit.Assert;
import com.qtp.selenium.app.saleforce.util.Webconnector;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Menutest {
	Webconnector selenium=Webconnector.getInstance();
	
    @Given("^i am loged in \"([^\"]*)\"$")
	
	public void i_am_logedin(String browsertype){
		//check u login or not. if not login then loginto system
	
	selenium.openbrowser(browsertype);
	if(!selenium.isLogedin()){//if not loged in
		selenium.doDefaultlogin();
		
	}
		
	}
	
   
   @And("^\"([^\"]*)\" should be present$")
   public void shoulb_present(String object){
   	System.out.println(" should present element  "+object);
   	selenium.click(object);
   	Assert.assertTrue("object not present" +object , selenium.isElementPresent(object));

   }
      
      

}