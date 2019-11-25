package com.prestashop.TestClasses;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.prestashop.baseclass.BaseClass;
import com.prestashop.pagess.Homepage;
import com.prestashop.pagess.LoginPage;
import com.prestashop.pagess.Shippingpage;
import com.prestashop.utility.ScreenshotUtility;

public class HomepageTest extends BaseClass{

	LoginPage lp;
	Homepage hp;
	Shippingpage sp;
	ScreenshotUtility su;
	public static Logger log=Logger.getLogger(HomepageTest.class.getName());
	
	public HomepageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		sp=new Shippingpage();
		lp=new LoginPage();
		hp=(Homepage) lp.login(p.getProperty("Uname"), p.getProperty("Pwd"));
		
	}
	
	/*@Test(priority=1)
	public void verifyMyShoplink()
	{
		hp.clickonMyshopLink();
	}
	
	@Test(priority=2)
	public void verifyOrdersNotification()
	{
		hp.clickonorderNotification();
	}
	
	@Test(priority=3)
	public void verifyCustMsgNotification()
	{
		hp.CheckLatestMessage();
	}
	
	@Test(priority=4)
	public void verifySystemAdminLink()
	{
		hp.SystemAdminLink();
	}
	
	@Test(priority=5)
	public void verifyQuickAcess()
	{
		hp.QuickAcess();
	}
	
	@Test(priority=6)
	public void verifyshippingLink() throws Throwable
	{
		sp=hp.clickonshippinglink();
	}
	
	@Test(priority=7)
	public void verifySearchBox() throws Throwable
	{
		hp.ClickingonSearchBox();
	}
	
	
	/*@Test(priority=8)
	public void verifySearchClearBox() throws Throwable
	{
		
		hp.ClickingonclearSearchBox();
	}
	
	@Test(priority=9)
	public void verifyHelplink() throws Throwable
	{
		
		hp.ClickingonHelpLink();
	}
	
	@Test(priority=10)
	public void verifyPrestaMarketPlace() throws Throwable
	{
		
		hp.ClickinonPrestashopMarketplace();
	}*/
	
	@Test(priority=11)
	public void SelectingCalenderDate() throws Throwable
	{
		
		hp.clickonDate();
	}
	
	@AfterMethod
	void tearDown(ITestResult result)
	{
		su.CaptureScreenshot(result);
		driver.quit();
	}	
	
}
