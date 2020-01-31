package com.fliplearn.flipapp.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;

public class Test1 extends Base
{
	@Test
	public void testmethod()
	{
		WebElement element = driver.findElement(By.cssSelector("li[id='uh-notifications']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='yns-content'])[2]")));
		
		String text = driver.findElement(By.xpath("(//div[@class='yns-content'])[2]")).getText();
		System.out.println("Text is"+text);
	}	

}
