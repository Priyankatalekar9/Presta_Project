package com.prestashop.pagess;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashop.baseclass.BaseClass;

public class LoginPage extends BaseClass{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"email\"]")
	public static WebElement username;
	
	@FindBy(xpath="//*[@id=\"passwd\"]")
	public static WebElement password;
	
	@FindBy(xpath="//*[@id=\"login_form\"]/div[3]/button")
	public static WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"shop-img\"]/img")
	public static WebElement Tuckimage ;
	
	@FindBy(xpath="//*[@id=\"login_form\"]/div[4]/a")
	public static WebElement Forgetpwd;
	
	@FindBy(id="stay_logged_in")
	public static WebElement stayloggedin;
	
	public Object login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new Homepage();
		
	}
	
	public boolean checkTuckimage()
	{
		Tuckimage.isDisplayed();
		return true;
		
	}

	public void checkForgetPwd() {
		
		Forgetpwd.click();
	}

	public void checkStayLogin() {
		
		stayloggedin.click();
		System.out.println(stayloggedin.isSelected());
	}
	
	
}
