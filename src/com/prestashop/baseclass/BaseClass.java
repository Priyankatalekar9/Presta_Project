package com.prestashop.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.prestashop.Listeners.SeleniListeners;

public class BaseClass {
	
	public static WebDriver driver;
	//public static Logger log=Logger.getLogger(BaseClass.class.getName());
	public static Properties p;
	public static SeleniListeners sel;
	public static EventFiringWebDriver e_driver;
		
	public static void initialization() throws Throwable
	{
		//PropertyConfigurator.configure("log4j.properties");
		FileInputStream fis=new FileInputStream("D:\\config.properties");
		 p=new Properties();
		 p.load(fis);
		 String Browsername=p.getProperty("TestBrowser");
		 if(Browsername.equals("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Selenium Software\\chromedriver.exe" );
			 driver=new ChromeDriver();
		 }
		 else
		 {
			 //FirefoxDriver driver=new FirefoxDriver();
		 }
		 
		 e_driver=new EventFiringWebDriver(driver);
		 sel=new SeleniListeners();
		 e_driver.register(sel);
		 driver=e_driver;
		 
		 driver.get("http://javaclassesinpune.com/SHOPCART/admin123/index.php?controller=AdminLogin&token=c6d21cf2ef91e87fe51aa19c95ff0a14");
	}

}
