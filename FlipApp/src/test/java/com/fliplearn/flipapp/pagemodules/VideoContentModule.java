
package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class VideoContentModule {
	@FindBy(xpath="//a[contains(text(),'Class 10')]")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement claConMod;
	
	@FindBy(xpath="(//div[@class='col-md-9 col-sm-8 col-xs-8']//h3[text()='Biology'])[2]")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnSubCon;
	
	@FindBy(xpath="//a[text()='1. Life Processes']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBook;
	
	@FindBy(xpath="//li[text()='Nutrition in Human Beings']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnBookTopCon;
	
	@FindBy(xpath="//h4[text()='Digestion']")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public RemoteWebElement cliOnVidCon;
	
	
	public VideoContentModule(WebDriver driver)
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
         public void clickOnBookContent() {
        	 
        	 cliOnBook.click();
        	 
         }
         public void clickOnBookTopicContent() {
        	 cliOnBookTopCon.click();
         }
         public void clickOnVideoContentandverJWPlayer(WebDriver driver) throws InterruptedException {
        	 cliOnVidCon.click();
        	 
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        	//Click on play button
        	jse.executeScript("jwplayer().play();");
        	Thread.sleep(2000);
        	//Pause
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
        	
        	driver.quit();        	 
         }
         

}