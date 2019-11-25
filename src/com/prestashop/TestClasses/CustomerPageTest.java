package com.prestashop.TestClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.prestashop.baseclass.BaseClass;
import com.prestashop.pagess.CustomerPage;
import com.prestashop.pagess.Homepage;
import com.prestashop.pagess.LoginPage;
import com.prestashop.pagess.Shippingpage;
import com.prestashop.utility.CommonMethods;
import com.prestashop.utility.TestUtil;

public class CustomerPageTest extends BaseClass {

	LoginPage lp;
	Homepage hp;
	static Shippingpage sp;
	static CommonMethods utility1;
	CustomerPage cp;
	String sheetName="Data";
	public CustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		cp=new CustomerPage();
		lp=new LoginPage();
		hp=(Homepage) lp.login(p.getProperty("Uname"), p.getProperty("Pwd"));
		
	}
	
	@Test(priority=1)
	public void clikingoncustomerlink()
	{
		utility1.waittime();
		cp.Clickoncustomerlink();
	}
	
	@Test(priority=2, dataProvider="getdata")
	public void verifyAddNewCustomer(String firstname,String  lastname) throws Throwable
	{
		utility1.waittime();
		cp.Clickoncustomerlink();
		cp.firstname.sendKeys(firstname);
		cp.lastname.sendKeys(lastname);
		
	}
	@DataProvider
	public Object[][] getdata() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	void tearDown()
	{
	//	driver.quit();
	}
}
