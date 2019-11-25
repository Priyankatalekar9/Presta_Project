package com.prestashop.TestClasses;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.prestashop.baseclass.BaseClass;
import com.prestashop.pagess.Homepage;
import com.prestashop.pagess.LoginPage;
import com.prestashop.utility.CommonMethods;
import com.prestashop.utility.ScreenshotUtility;

public class LoginTest extends BaseClass{

	
	LoginPage lp;
	Homepage hp;
	static CommonMethods utility1;
	ScreenshotUtility su;
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws Throwable {
		initialization();
		lp=new LoginPage();
		
	}
	

	@Test(priority=1)
	public void loginTest()
	{
		hp=(Homepage) lp.login(p.getProperty("Uname"), p.getProperty("Pwd"));
		
	}
	
	@Test(priority=2)
	public void verifyTuckimage()
	{
		lp.checkTuckimage();
	}
	
	@Test(priority=3)
	public void verifyInvalidUsername()
	{
		utility1.waittime();
		lp.username.sendKeys("hghg");
		lp.password.sendKeys("password");
		lp.loginbtn.click();
		String act=driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/span")).getText();
		String exp="Please enter a valid email address.";
		Assert.assertEquals(act, exp,"If username is incorrect");
	}
	

	@Test(priority=4)
	public void verifyPasswordisMandatory()
	{
		utility1.waittime();
		lp.username.sendKeys("admin@javaclassesinpune.com");
		lp.password.sendKeys("");
		lp.loginbtn.click();
		String act=driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/span")).getText();
		String exp="This field is required.";
		Assert.assertEquals(act, exp," password This field is required.");
	}
	
	@Test(priority=5)
	public void verifyForgetPwdLink()
	{
		lp.checkForgetPwd();
	}
	
	@Test(priority=6)
	public void verifyStayLoginCheckbox()
	{
		lp.checkStayLogin();
	}
	
	@AfterMethod
	void tearDown(ITestResult result)
	{
		su.CaptureScreenshot(result);
		driver.quit();
	}
}
