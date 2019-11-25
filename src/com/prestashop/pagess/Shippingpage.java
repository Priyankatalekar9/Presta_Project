package com.prestashop.pagess;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import com.prestashop.baseclass.BaseClass;
import com.prestashop.utility.CommonMethods;

public class Shippingpage extends BaseClass{
	
	CommonMethods utility1;
	static Shippingpage sp;
	
	public Shippingpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentShipping\"]")
	public static WebElement shippinglink;
	
	@FindBy(xpath="//*[@id=\"page-header-desc-carrier-new_carrier\"]/div")
	public static WebElement addnewcarrier;
	
	@FindBy(xpath="//*[@id=\"configuration_form\"]/div/a")
	public static WebElement newCustomcarrier;
	
	@FindBy(xpath="//*[@id=\"name\"]")
	public static WebElement CarrierName;
	
	@FindBy(xpath="//*[@id=\"delay_1\"]")
	public static WebElement TransitTime;

	@FindBy(xpath="//*[@id=\"grade\"]")
	public static WebElement SpeedGrade;
	
	@FindBy(xpath="//*[@id=\"url\"]")
	public static WebElement TrackingURL;
	
	@FindBy(xpath="//*[@id=\"carrier_wizard\"]/div[2]/a[2]")
	public static WebElement NextBtn;
	
	@FindBy(css="#fieldset_form_1_1 > div > div:nth-child(1) > div > span > label:nth-child(2)")
	public static WebElement Handlingcost;
	
	@FindBy(css="#fieldset_form_1_1 > div > div:nth-child(2) > div > span > label:nth-child(2)")
	public static WebElement freeshiping;
	
	@FindBy(xpath="//*[@id=\"billing_weight\"]")
	public static WebElement billing_price ;
	
	@FindBy(xpath="//*[@id=\"id_tax_rules_group\"]")
	public static WebElement Tax;
	
	@FindBy(xpath="//*[@id=\"carrier_wizard\"]/div[2]/a[2]")
	public static WebElement NextBtn2;
	
	
	
	public  void ClickonAddnewcarriers() {
		
		utility1.waittime();
		shippinglink.click();
		utility1.waittime();
		addnewcarrier.click();
		newCustomcarrier.click();
		
	}
	
	public static void checkingspeedgrade(String CarrieName, String Transitime,String Speed, String TrackinURL,String expectedmsg)
	{
		sp.ClickonAddnewcarriers();
		SpeedGrade.sendKeys("12");
		NextBtn.click();
		String actual=driver.findElement(By.xpath("//*[@id=\"step-1\"]/div/ul/li")).getText();
		String expmsg=expectedmsg;
		Assert.assertEquals(actual, expmsg);
	}
	
	public void RefreshCarrierPage()
	{
		utility1.waittime();
		Actions action1=new Actions(driver);
		action1.keyDown(Keys.CONTROL).sendKeys(Keys.F5).build().perform();
	}
	
	public Shippingpage clickonPreferencelink() throws Throwable
	{
		utility1.waittime();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"maintab-AdminParentShipping\"]"))).build().perform();
		driver.findElement(By.xpath("//*[@id=\"subtab-AdminShipping\"]")).click();
		return new Shippingpage();
		
	}
	
	
	
}
