package com.prestashop.pagess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestashop.baseclass.BaseClass;

public class Localizationpage extends BaseClass{
	
	public Localizationpage() {
		PageFactory.initElements(driver, this);
		}
		
		
		//like wise for all links
	 
		public Localizationpage clickonlocallanguagelink() throws Throwable 
		{
			Thread.sleep(2000);
			Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\"maintab-AdminParentLocalization\"]/a/span"))).build().perform();
			
			driver.findElement(By.xpath("//*[@id=\"subtab-AdminLanguages\"]/a")).click();
			return new Localizationpage();
			
		} 
		
}
