
package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimeResourceListModule extends Base
{
	@FindBy(xpath="//a[contains(text(),'Class 10')]")
	@AndroidFindBy(xpath="//*[@text='Class 7']")
	@iOSFindBy(id="")
	public RemoteWebElement claConMod;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Biology'])[2]")
	@AndroidFindBy(xpath="//*[@text='Mathematics']")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnSubCon;
	
	@FindBy(xpath="//a[text()='1. Life Processes']")
	@AndroidFindBy(xpath="//*[@text='Integers']")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBook;
	
	@FindBy(xpath="//li[text()='Nutrition in Human Beings']")
	@AndroidFindBy(xpath="//*[@text='Integers']")
	public RemoteWebElement cliOnBookTopCon;
	
	@FindBy(xpath="//h4[text()='Digestion']")
	@AndroidFindBy(xpath="(//*[@text='Animation'])[1]")
	public RemoteWebElement cliOnVidCon;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Real Life Application']")
	@AndroidFindBy(xpath="//*[@text='Real Life Application']")
	public RemoteWebElement realLife;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Topic Synopsis']")
	@AndroidFindBy(xpath="//*[@text='Topic Synopsis']")
	public RemoteWebElement topicSynopsis;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Mind Maps']")
	@AndroidFindBy(xpath="//*[@text='Mind Maps']")
	public RemoteWebElement mindMaps;

	@FindBy(xpath="(//div[@class='modal-body head_bottom'])[4]//h4")
	public RemoteWebElement childAccessMsg;
	
	public PrimeResourceListModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
        public void clickOnClassContent() 
        {
        	claConMod.click();
	    }
         public void clickOnSubjectContent()
         {
        	 cliOnSubCon.click();
        	 
         }
         public void clickOnBookChapter(WebDriver driver, String chapterName) throws InterruptedException 
         {	 
        	 if(platform.equals("Web"))
        		 driver.findElement(By.partialLinkText(chapterName)).click();  
        	 else
        		 driver.findElement(By.xpath("//*[@text='"+chapterName+"']")).click();;
         }
         
         public void clickOnChapterTopic(WebDriver driver, String topicName) 
         {
        	 if(platform.equals("Web"))
        		 driver.findElement(By.xpath("//li[text()='"+topicName+"']")).click(); 
        	 else
        		 driver.findElement(By.xpath("//*[@text='"+topicName+"']")).click();;
         }

         public void clickOnVideoContent() 
         {
        	 cliOnVidCon.click();	 
         }
         
         public void clickOnRealLifeApplication() throws InterruptedException
         {
        	 realLife.click();
        	 Thread.sleep(3000);
         }
         
         public void clickOnTopicSynopsis() throws InterruptedException
         {
        	 topicSynopsis.click();
        	 Thread.sleep(3000);
         }
       
         public void clickOnMindMaps() throws InterruptedException
         {
        	 mindMaps.click();
        	 Thread.sleep(3000);
         }
         
         public void clickOnViewAllSample(WebDriver driver)
         {
        	 driver.findElement(By.linkText("View all sample content")).click();
         }           
}

