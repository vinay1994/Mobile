package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fliplearn.flipapp.helper.Base;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class PrimeChapterTopicModule extends Base
{
	public PrimeChapterTopicModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	/*** Old UI ***/
	
	@FindBy(css="input[name='schoolName']")
	public RemoteWebElement searchTxt;
	
	@FindBy(xpath="(//h4[@class='panel-title'])[3]")
	public RemoteWebElement clickOnTopics;
	
	@FindBy(xpath="(//li[@class='col-xs-10 col-sm-11 col-md-11 ng-binding'])[1]")
	public RemoteWebElement clickOnresource;

	
	@FindBy(xpath="(//h4[contains(text(),'Please access the content from your child')])[2]")
	public RemoteWebElement childAccessTxt;
	
	@FindBy(xpath="//div/h4[contains(text(),'Please access the content from your child')]")
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
	
	/*** New UI ***/
	
	@FindBy(css="span[id='learnPracticeModeSwitch'][class='checkbtnnewcheckleft']")
	public RemoteWebElement learningModeBtn;
	
	@FindBy(css="span[id='learnPracticeModeSwitch'][class='checkbtnnewcheck']")
	public RemoteWebElement practiceModeBtn;
	
	@FindBy(css="span[id='learnPracticeModeSwitch']")
	public RemoteWebElement learnPracticeModeBtn;
	
	@FindBy(css="p[class='fontregular mobilefont12 m-t-12']")
	public RemoteWebElement learnPracticeModeTxt;
	
	
}
