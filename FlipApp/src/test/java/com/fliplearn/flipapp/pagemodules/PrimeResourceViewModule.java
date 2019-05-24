package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PrimeResourceViewModule  extends Base
{
	GenericFunctions generic=new GenericFunctions();

	@FindBy(xpath="//a[contains(@class,'ng-binding collapsed')]")
	public List<RemoteWebElement> cliOncla12;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Chemistry'])[4]")
	public RemoteWebElement clickOnChemSubj;
	
	@FindBy(xpath="//a[text()='1. The Solid State")
	public RemoteWebElement clickOnsolidchapter;
	
	@FindBy(xpath="//li[text()='Crystal Lattices and Unit Cells']")
	public RemoteWebElement clickOntopic;
	
	@FindBy(xpath="//h6[text()='Real Life Application']")
	public RemoteWebElement clickOnRealLifApp;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	@AndroidFindBy(id="com.elss.educomp:id/title_name")
	public RemoteWebElement synopsisHeading;
	
	@FindBy(xpath="//h1[text()='Topic Synopsis']")
	@AndroidFindBy(xpath="//*[@text='Topic Synopsis']")
	public RemoteWebElement synopsisTitle;
	
	@FindBy(xpath="//h1[text()='Mind Maps']")
	@AndroidFindBy(xpath="//*[@text='Mind Maps']")
	public RemoteWebElement mindMapsTitle;
	
	@FindBy(xpath="//h1[text()='Real Life Application']")
	@AndroidFindBy(xpath="//*[@text='Real Life Application']")
	public RemoteWebElement realLifeApplicationTitle;
	
	@FindBy(xpath="//div[@class='container']/div[@class='header']")
	@AndroidFindBy(xpath="//*[@text='Real Life Application']")
	public RemoteWebElement interactiveWorksheetTitle;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	public RemoteWebElement synopsisHeadingStudent;

	
	@FindBy(xpath="//button[@type='button'])[4]")
	public RemoteWebElement closeRealLifeSyn;
	
	@FindBy(xpath="//h6[text()='Topic Synopsis']")
	public RemoteWebElement clickOnTopicSynop;
	
	@FindBy(xpath="(//button[@class='close'])[3]")
	public RemoteWebElement closeTopSyn;
	
	@FindBy(xpath="//h6[text()='Web Links']")
	public RemoteWebElement clickOnWebLink;
	
	@FindBy(xpath="//button[@class='close']")
	public RemoteWebElement closeWebLink;
	
	@FindBy(xpath="//h6[@class='ng-binding' and text()='Animation']")
	
//	@iOSXCUITFindBy(xpath="//XCUIElementTypeOther[@name='"+videoTitle+"']")
//	public RemoteWebElement title;
	
	public RemoteWebElement firstAnimatedVideo;
	
	
	public void clickOnClass() {
		cliOncla12.get(10).click();
	}
	
	public void clickOnSubject() {
		clickOnChemSubj.click();
		
	}
	public void clickOnConTopic() {
		clickOntopic.click();
	}
		
		public void clickRealLifeSynop() {
			clickOnRealLifApp.click();
			}
		
		public void closeRealLifeSyn() {
			closeRealLifeSyn.click();
			
		}
		public void clickOnTopicSyn() {
			clickOnTopicSynop.click();
		}
		public void closeTopicSyn() {
			closeTopSyn.click();
		}
		public void clickOnWebLink() {
			clickOnWebLink.click();
			
			}
		public void closeWebLink() {
			
			
		}
		
		
	@FindBy(xpath="//a[contains(text(),'Class 10')]")
	@AndroidFindBy(xpath="//*[@text='Class 10']")
	public RemoteWebElement claConMod;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Biology'])[2]")
	@AndroidFindBy(xpath="//*[@text='Biology']")
	public RemoteWebElement schoolSubName;
	
	@FindBy(xpath="//div[@class='col-md-9 col-sm-8 col-xs-9']//h3[text()='English']")
	@AndroidFindBy(xpath="//*[@text='Life Processes']")
	public RemoteWebElement studentSubName;
 	
	@FindBy(xpath="//a[text()='1. Life Processes']")
	@AndroidFindBy(xpath="//*[@text='Life Processes']")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBook;
	
	@FindBy(xpath="//li[text()='Nutrition in Human Beings']")
	@AndroidFindBy(id="//*[@text='Nutrition in Human Beings']")
	public RemoteWebElement cliOnBookTopCon;
	
	@FindBy(xpath="//h4[text()='Digestion']")
	@AndroidFindBy(id="//*[@text='Biology']")
	public RemoteWebElement schoolVideoContent;
	
	@FindBy(xpath="//h4[text()='Countable and Uncountable Nouns']")

	public RemoteWebElement studentVideoContent;
	
	
	
	public PrimeResourceViewModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void clickOnVideoContent(WebDriver driver, String videoContentName) throws InterruptedException
    {
    	Thread.sleep(4000);
    	if(platform.equals("Web"))
    	{	
    		generic.waitForElementVisibility(driver, firstAnimatedVideo);
    		firstAnimatedVideo.click();
    	}	
    	else if(platform.equals("iOS")) {
    		driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='Animation'])[1]")).click();
    		
    	}
    	else
    		driver.findElement(By.xpath("//*[@text='Animation']")).click();
    }
    
    public void verifyVideoContent(WebDriver driver, String videoTitle) throws InterruptedException 
    {
    	if(platform.equals("Web"))
    	{	
    		Thread.sleep(5000);
    		JavascriptExecutor jse = (JavascriptExecutor) driver;
     
    		jse.executeScript("jwplayer().pause()");
    		Thread.sleep(2000);
        
    		//Play
    		jse.executeScript("jwplayer().play();");
    		Thread.sleep(2000);
        
    		// Set Volume
    		Thread.sleep(2000);
        
    		jse.executeScript("jwplayer().setVolume(50);");
    		Thread.sleep(2000);
        
    		//Mute Player
    		jse.executeScript("jwplayer().setMute(true);");
    		Thread.sleep(2000);
        
    		//UnMute Player
    		jse.executeScript("jwplayer().setMute(false);");
        
    		Thread.sleep(2000);
    		//Stop the player
    		jse.executeScript("jwplayer().stop()");
    		Thread.sleep(2000);
    	}
    	
    	else if(platform.equals("iOS")) {
    		
    	//	generic.waitForElementVisibility(driver, By.xpath("//XCUIElementTypeOther[@name='"+videoTitle+"']"));
    		Assert.assertTrue(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='"+videoTitle+"']")).isDisplayed());
    	}
    	else
    	{
    		Thread.sleep(6000);
    		Assert.assertTrue(driver.findElement(By.xpath("//*[@text='"+videoTitle+"']")).isDisplayed());
    	}
    	
    }
}