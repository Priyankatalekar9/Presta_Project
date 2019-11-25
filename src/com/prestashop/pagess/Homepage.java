package com.prestashop.pagess;
import com.prestashop.utility.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.prestashop.baseclass.BaseClass;

public class Homepage extends BaseClass {

	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentShipping\"]")
	WebElement shippinglink;
	
	@FindBy(xpath="//*[@id=\"header_foaccess\"]/span[2]")
	WebElement Myshoplink;
	
	@FindBy(xpath="//*[@id=\"orders_notif\"]/a/i")
	WebElement orderNotification;
	
	@FindBy(xpath="//*[@id=\"customer_messages_notif\"]/a/i")
	WebElement CustMsgNotification;
	
	@FindBy(xpath="//a[contains(text(),'Quick Access')]")
	public static	WebElement QuickAcess;
	
	@FindBy(css="#employee_infos > a > span.string-short")
	WebElement SystemAdministration;
	
	@FindBy(xpath="//*[@id=\"header_quick\"]/li/ul/li[4]/a")
	public static WebElement newproduct;
	
	@FindBy(xpath="//*[@id=\"bo_query\"]")
	public static WebElement searchbox;
	
	@FindBy(css="#header_search > div > div > a > i")
	public static WebElement clearsearchbox;
	
	@FindBy(xpath="//*[@id=\"toolbar-nav\"]/li[2]/a/div")
	public static WebElement Helplink;
	
	@FindBy(css="#header_employee_box > li.hidden-sm.hidden-xs > a")
	public static WebElement MarketPlace;
	//like wise for all links
	public Shippingpage clickonshippinglink() throws Throwable
	{
		Thread.sleep(1000);
		shippinglink.click();
		return new Shippingpage();
		
	}
	
	public void clickonMyshopLink()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Myshoplink.click();
	}
	
	public void clickonorderNotification()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		orderNotification.click();
		
		
	}
	public void CheckLatestMessage()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		CustMsgNotification.click();
	}
	
	
	public void SystemAdminLink()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.moveToElement(SystemAdministration).click().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.cssSelector("#header_logout"))).click().build().perform();
		
	}
	
	public void QuickAcess()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action=new Actions(driver);
		action.moveToElement(QuickAcess).click().build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.cssSelector("#header_quick > li > ul > li:nth-child(1) > a"))).click().perform();
		
		
	}
	
	public void ClickingonSearchBox() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchbox.sendKeys("orders");
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
		
		
	}
	
	public void ClickingonclearSearchBox()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		searchbox.sendKeys("hgh");
		clearsearchbox.click();
		
	}
	
	public void ClickingonHelpLink()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Helplink.click();
		
	}
	
	public void ClickinonPrestashopMarketplace()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		MarketPlace.click();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#modal_addons_connect")));
		action.moveToElement(driver.findElement(By.cssSelector("#modal_addons_connect > div > div > div.modal-header > button"))).click().build().perform();
		
	}
	
	public void clickonDate()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#datepickerExpand")).click();
		/*Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("#datepicker > div > div > div > div:nth-child(1)"))).build().perform();
		driver.findElement(By.cssSelector("#datepicker > div > div > div > div:nth-child(1) > div > div > div.daterangepicker-days > table > tbody > tr:nth-child(1) > td:nth-child(3)")).click();
		action.moveToElement(driver.findElement(By.cssSelector("#datepicker"))).build().perform();
		driver.findElement(By.cssSelector("#datepicker > div > div > div > div:nth-child(2) > div > div > div.daterangepicker-days > table > tbody > tr:nth-child(1) > td:nth-child(6)")).click();
		driver.findElement(By.cssSelector("#datepicker-form > div.form-date-actions > button.btn.btn-default.pull-right")).click();*/
	}
	
}
