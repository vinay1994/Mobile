package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimeChapterTopicModule extends Base
{
	public PrimeChapterTopicModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	@FindBy(css="input[name='schoolName']")
	public RemoteWebElement searchTxt;
	
	@FindBy(xpath="(//h4[contains(text(),'Please access the content from your child')])[1]")
	public RemoteWebElement childAccessTxt;
	
	@FindBy(xpath="(//h4[contains(text(),'Please access the content from your child')])[2]")
	public RemoteWebElement childAccessPopup;
	
	//Search for prime content
	public void searchContent(String title)
	{
		searchTxt.sendKeys(title);
		searchTxt.sendKeys(Keys.ENTER);    
	}
	
	public void selectFirstSearchedContent(String title) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//h4[text()='"+title+"'])[1]")).click();
	}
}
