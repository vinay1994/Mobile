package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PrimeResourceViewModule 
{
	//@FindBy(xpath="//a[text()='Class 12']")
	@FindBy(xpath="//a[contains(@class,'ng-binding collapsed')]")
	@AndroidFindBy()
	@iOSFindBy()
	public List<RemoteWebElement> cliOncla12;
	//public RemoteWebElement cliOncla12;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Chemistry'])[4]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnChemSubj;
	
	@FindBy(xpath="//a[text()='1. The Solid State")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnsolidchapter;
	
	@FindBy(xpath="//li[text()='Crystal Lattices and Unit Cells']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOntopic;
	
	@FindBy(xpath="//h6[text()='Real Life Application']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnRealLifApp;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	public RemoteWebElement synopsisHeading;
	
	@FindBy(xpath="//div[@id='demo-html']//h3")
	public RemoteWebElement synopsisHeadingStudent;

	
	@FindBy(xpath="//button[@type='button'])[4]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeRealLifeSyn;
	
	@FindBy(xpath="//h6[text()='Topic Synopsis']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnTopicSynop;
	
	@FindBy(xpath="(//button[@class='close'])[3]")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeTopSyn;
	
	@FindBy(xpath="//h6[text()='Web Links']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement clickOnWebLink;
	
	@FindBy(xpath="//button[@class='close']")
	@AndroidFindBy()
	@iOSFindBy()
	public RemoteWebElement closeWebLink;
	
	
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
	@iOSFindBy(id="")
	public RemoteWebElement claConMod;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Biology'])[2]")
	@AndroidFindBy(xpath="//*[@text='Biology']")
	@iOSFindBy(id="")
	public RemoteWebElement schoolSubName;
	
	@FindBy(xpath="//div[@class='col-md-9 col-sm-8 col-xs-9']//h3[text()='English']")
	@AndroidFindBy(xpath="//*[@text='Life Processes']")
	@iOSFindBy(id="")
	public RemoteWebElement studentSubName;
 	
	@FindBy(xpath="//a[text()='1. Life Processes']")
	@AndroidFindBy(xpath="//*[@text='Life Processes']")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBook;
	
	@FindBy(xpath="//li[text()='Nutrition in Human Beings']")
	@AndroidFindBy(id="//*[@text='Nutrition in Human Beings']")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBookTopCon;
	
	@FindBy(xpath="//h4[text()='Digestion']")
	@AndroidFindBy(id="//*[@text='Biology']")
	@iOSFindBy(id="")
	public RemoteWebElement schoolVideoContent;
	
	@FindBy(xpath="//h4[text()='Countable and Uncountable Nouns']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement studentVideoContent;
	
	public PrimeResourceViewModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void clickOnVideoContent(WebDriver driver, String videoContentName)
    {
    	driver.findElement(By.xpath("//h4[text()='"+videoContentName+"']")).click();	
    }
    
    public void clickOnVideoContentandverJWPlayer(WebDriver driver) throws InterruptedException 
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
}