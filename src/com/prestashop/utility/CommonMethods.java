package com.prestashop.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import com.prestashop.baseclass.BaseClass;

public class CommonMethods extends BaseClass {

	
	public static void waittime()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
