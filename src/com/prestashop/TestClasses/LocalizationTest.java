package com.prestashop.TestClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prestashop.baseclass.BaseClass;
import com.prestashop.pagess.Homepage;
import com.prestashop.pagess.Localizationpage;
import com.prestashop.pagess.LoginPage;
import com.prestashop.pagess.Shippingpage;

public class LocalizationTest extends BaseClass {

	LoginPage lp;
	Homepage hp;
	Shippingpage sp;
	Localizationpage lzp;
	
	public LocalizationTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		lzp=new Localizationpage();
		sp=new Shippingpage();
		lp=new LoginPage();
		hp=(Homepage) lp.login(p.getProperty("Uname"), p.getProperty("Pwd"));
		
	}
	
	@Test(priority=1)
	public void verifyLanguagesLink() throws Throwable
	{
		lzp.clickonlocallanguagelink();
		
	}
	
	@AfterMethod
	void tearDown()
	{
		//driver.quit();
	}
	
}
