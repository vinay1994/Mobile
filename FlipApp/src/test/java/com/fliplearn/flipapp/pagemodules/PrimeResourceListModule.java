
package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimeResourceListModule 
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
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBookTopCon;
	
	@FindBy(xpath="//h4[text()='Digestion']")
	@AndroidFindBy(xpath="(//*[@text='Animation'])[1]")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnVidCon;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Real Life Application']")
	@AndroidFindBy(xpath="//*[@text='English']")
	@iOSFindBy(id="")
	public RemoteWebElement realLife;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Topic Synopsis']")
	@AndroidFindBy(xpath="//*[@text='Topic Synopsis']")
	@iOSFindBy(id="")
	public RemoteWebElement topicSynopsis;
	
	@FindBy(xpath="//div[@class='row learnResourcesInner']//h6[text()='Mind Maps']")
	@AndroidFindBy(id="//*[@text='Mind Maps']")
	@iOSFindBy(id="")
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
         public void clickOnBookChapter(WebDriver driver, String role, String chapterName) 
         {	 
        	 driver.findElement(By.xpath("//a[text()='"+chapterName+"']")).click();      
         }
         
         public void clickOnBookTopicContent(WebDriver driver, String role, String topicName) {
        	 driver.findElement(By.xpath("//li[text()='"+topicName+"']")).click(); 
         }

         public void clickOnVideoContent() {
        	 cliOnVidCon.click();
        	 
        	 }
         
         public void clickOnRealLife()
         {
        	 realLife.click();
         }
         
         public void clickOnTopicSynopsis()
         {
        	 topicSynopsis.click();
         }
       
         public void clickOnMindMaps()
         {
        	 mindMaps.click();
         }
         
         public void clickOnViewAllSample(WebDriver driver)
         {
        	 driver.findElement(By.linkText("View all sample content")).click();
         }
         
   
              
                  
}

