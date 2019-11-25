package com.prestashop.TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.prestashop.baseclass.BaseClass;
import com.prestashop.pagess.Homepage;
import com.prestashop.pagess.LoginPage;
import com.prestashop.pagess.Shippingpage;
import com.prestashop.utility.CommonMethods;


@Listeners(com.prestashop.Listeners.PrestaListeners.class)

public class ShippingTest extends BaseClass {

	LoginPage lp;
	Homepage hp;
	static Shippingpage sp;
	static CommonMethods utility1;
	String sheetname="Sheet1";
	public ShippingTest()
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
	
	@Test(priority=1)
	public void verifyAddnewshipping() throws Throwable
	{
		utility1.waittime();
		sp.ClickonAddnewcarriers();
		
		
	}
	
	@Test(dataProvider="carrierData", priority=2)
	public void CustomCarrier(String CarrieName, String Transitime,String Speed, String TrackinURL)
	{
		utility1.waittime();
		sp.ClickonAddnewcarriers();
		sp.CarrierName.sendKeys(CarrieName);
		sp.TransitTime.sendKeys(Transitime);
		sp.SpeedGrade.sendKeys(Speed);
		sp.TrackingURL.sendKeys(TrackinURL);
		sp.NextBtn.click();
		utility1.waittime();
		sp.Handlingcost.click();
		sp.freeshiping.click();
		sp.billing_price.click();
		utility1.waittime();
		Select s=new Select(sp.Tax);
		s.selectByVisibleText("No tax");
		sp.NextBtn2.click();
	}
	
	/*@Test(dataProvider="carrierData", priority=3)
	public static void Verifyingspeedgrade(String CarrieName, String Transitime,String Speed, String TrackinURL,String expectedmsg)
	{
		utility1.waittime();
		sp.ClickonAddnewcarriers();
		utility1.waittime();
		sp.CarrierName.sendKeys(CarrieName);
		sp.TransitTime.sendKeys(Transitime);
		sp.SpeedGrade.sendKeys(Speed);
		utility1.waittime();
		sp.NextBtn.click();
		String actual=driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/ul/li")).getText();
		String expmsg=expectedmsg;
		Assert.assertEquals(actual, expmsg,"Verifying Speedgrade not more than 1 CHAR");
	}
	
	@Test(dataProvider="carrierData", priority=4)
	public static void Verifyingcarriername(String CarrieName, String Transitime,String Speed, String TrackinURL,String expectedmsg)
	{
		utility1.waittime();
		sp.ClickonAddnewcarriers();
		sp.CarrierName.sendKeys(CarrieName);
		sp.TransitTime.sendKeys(Transitime);
		utility1.waittime();
		sp.NextBtn.click();
		utility1.waittime();
		String actual=driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/ul/li[1]")).getText();
		String expmsg=expectedmsg;
		Assert.assertEquals(actual, expmsg,"Verifying carriername if it is blank");
	}
	
	@Test(priority=5)
	public void verifyRefreshingPage() throws Throwable
	{
		sp.RefreshCarrierPage();
		
	}
	
	@Test(priority=6)
	public void verifyshippingPreferenceLink() throws Throwable
	{
		sp.clickonPreferencelink();
		
	}*/
	
	
	
	/*@DataProvider(name="getcarrierData")
	public Object[][] getcarrierData(){
		return new Object[][] {
			new Object[] {"Ekart","15 days","3","http://example.com/track.php?num=12"},
			//new Object[] {"oo","12 days","234","","The grade field is too long (1 chars max)."},
			//new Object[] {"","15 days","","","The name field is required."}
		};
		
	}*/
	
	
	
	
	@AfterMethod
	void tearDown()
	{
		driver.quit();
	}
	 
}
