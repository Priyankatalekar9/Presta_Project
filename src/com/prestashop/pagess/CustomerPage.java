package com.prestashop.pagess;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashop.baseclass.BaseClass;

public class CustomerPage extends BaseClass{

	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"maintab-AdminParentCustomer\"]/a")
	public static WebElement customerlink;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div/div/div/ul/li[1]/a")
	public static WebElement addnew;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[5]/div/form/div/div[2]/div[2]/div/input")
	public static WebElement firstname;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[5]/div/form/div/div[2]/div[3]/div/input")
	public static WebElement lastname;
	

	public  void Clickoncustomerlink() {
		
		customerlink.click();
		addnew.click();
		
		
	}
	
}
