package com.fliplearn.flipapp.pagemodules;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DoubtForumModule extends Base{
	
	GenericFunctions generic = new GenericFunctions();
	public DoubtForumModule() 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	@FindBy(xpath="//p[text()='Doubt Forum'] | //div[@class='col-sm-8 col-xs-7 mobilepaddingZero vmcmobileView']/h2[text()='Doubt Forum']")
	public RemoteWebElement doubtForumTileTxt;
	
	@FindBy(xpath="//h3[text()='Fliplearn Guru']")
	public RemoteWebElement doubtForumHeading;
	
	@FindBy(xpath="//*[@class='hidden-xs ng-binding']")    
	public List<RemoteWebElement >doubtForumTabs;
	
	@FindBy(xpath="(//*[text()='My Doubts'])[2]")
	public RemoteWebElement cliOnMyDoubtTab;
	
	@FindBy(xpath="//*[contains(@src,'doubt.png')]")
	public RemoteWebElement verDouFormImg;
	
	@FindBy(xpath="//*[text()='Search Doubt']")
	public RemoteWebElement vercreateDoubtFrame;
	
	@FindBy(xpath="//*[text()='Fliplearn Guru']")
	public RemoteWebElement verFlipGuruTxt;
	
	@FindBy(xpath="//*[contains(@src,'doubtforumastronaut.png')]")
	public RemoteWebElement verAskImg;
	
	@FindBy(xpath="//*[@class='btn-animation']")
	public RemoteWebElement askYourDoubtBtn;
	
	
	// *** Search Doubt Pop-up Elements & Methods *** //
	
	@FindBy(xpath="(//textarea[@placeholder='Ask your doubt'][@id='comment'])[2]")
	public RemoteWebElement askYourDoubtTxt;
	
	@FindBy(xpath="//a[text()='Search']")
	public RemoteWebElement searchBtn;
	
	public String enterAskYourDoubtText() throws InterruptedException 
	{
		generic.waitForElementVisibility(driver, askYourDoubtTxt);
		String postTitle = "Testing doubtforum Post_"+timeStamp;
		askYourDoubtTxt.sendKeys(postTitle);
		
		return postTitle;
	}
	
	public void clickOnSearchBtn() throws InterruptedException 
	{
		generic.waitForElementVisibility(driver, searchBtn);
		searchBtn.click();
	}
	
	// *** Tips to Ask Doubt *** //
	
	@FindBy(xpath="//h3[@class='modal-title text-center'][text()='Tips to Ask Doubt']")
	public RemoteWebElement tipsToAskDoubtHeading;
	
	@FindBy(xpath="//div[@id='help-popup']/div/div/div/button")
	public RemoteWebElement tipsToAskDoubtCloseBtn;
	
	public void closeTipsToAskDoubtPopUp()
	{
		tipsToAskDoubtCloseBtn.click();
	}	
	
	// *** Create Doubt Pop-up Elements *** //
	
	@FindBy(name="subject")
	public RemoteWebElement selectSubjectDrp;
	
	@FindBy(name="chapter")
	public RemoteWebElement selectChapterDrp;
	
	@FindBy(xpath="//*[text()='Create']")
	public RemoteWebElement createBtn;
	
    public void selectSubjectFromDrp() 
    {
    	selectSubjectDrp.click();
    	generic.selectByVisibleText(selectSubjectDrp, "Maths");  	
    }
    
    public void selectChapFromDrp() 
    {
    	selectChapterDrp.click();
    	generic.selectByVisibleText(selectChapterDrp, "Polynomials");
    }
    
    public void clickOnCreateBtn() 
    {
    	createBtn.click();
    }
	
	@FindBy(xpath="(//*[text()='Create Post For Testing'])[1]")
	public RemoteWebElement verPostAftCreat;
	
	@FindBy(xpath="(//*[@class='font16 m-b-15 ng-binding'])[1]")
	public RemoteWebElement verExpDouPost;
	
	@FindBy(xpath="(//*[text()='1 Followers'])[1]")
	public RemoteWebElement verFollCount;
	
	@FindBy(xpath="//*[text()='2 Followers']")
	public RemoteWebElement verTwoFollCount;
	
	@FindBy(xpath="(//*[@ng-click='openMessageDetailPage(gallery)'])[1]")
	public RemoteWebElement cliOnDetailsLnk;
	
	@FindBy(xpath="//*[@class='btn-animation']")
	public RemoteWebElement cliOnPostYouAns;
	
	@FindBy(xpath="(//*[text()='Post Answer'])[1]")
	public RemoteWebElement verPostAnsTxt;
	
	@FindBy(name="comment")
	public RemoteWebElement enterAnswer;
	
	@FindBy(xpath="(//*[text()='Add Image'])[1]")
	public RemoteWebElement addImg;
	
	@FindBy(xpath="//a[text()='Post']")
	public RemoteWebElement cliOnPost;
	
	@FindBy(xpath="(//*[@class='font16 m-b-15 doubtforumDetailTitle ng-binding'])[2]")
	public RemoteWebElement verAns;
	
	@FindBy(xpath="(//*[@class='fa fa-ellipsis-v'])[1]")
	public RemoteWebElement unfollPost;
	
	@FindBy(xpath="//*[text()='Unfollow']")
	public RemoteWebElement clickOnUnfollow;
	
	@FindBy(xpath="//*[text()='Doubt Forum']")
	public RemoteWebElement cliOndouForPrePag;
	
	@FindBy(xpath="(//*[@class='font16 m-b-15 ng-binding'])[1]")
	public RemoteWebElement FirMyDoubtPost;
	
	@FindBy(xpath="//*[@class='font16 m-b-15 doubtforumDetailTitle ng-binding']")
	public RemoteWebElement MyDoubtDetailPost;
	
	public void clickOnPostButtn() {
		cliOnPost.click();
		
	}
	public void cliOnAddImg() {
		addImg.click();
	}
	public void clickOnMyDoubt() {
		cliOnMyDoubtTab.click();
	}
	
	// Click on Doubt Forum Tile on Home Page
	public void clickOnDoubtForumTile()
	{
		doubtForumTileTxt.click();
	}
	
	// Click on Ask Your Doubt Button
	public void clickOnAskYourDoubtBtn() throws InterruptedException 
	{
		generic.waitForElementVisibility(driver, askYourDoubtBtn);
		askYourDoubtBtn.click();
	}

    public void clickOnDetailsLink() {
    	cliOnDetailsLnk.click();
    }
 
    public String enterPostAnsText() {
		
		String ExpectedAns = "Testing doubtforum PostAns_"+timeStamp;
		enterAnswer.sendKeys(ExpectedAns);
		
		return ExpectedAns;}
    public String verMyDoubtDtailPost() {
    	String MyDoubtPost=MyDoubtDetailPost.getText();
    	return MyDoubtPost;
    }
    
    public void clickOnPostYourAns() throws InterruptedException {
    	String mainHandle = driver.getWindowHandle();
    	cliOnDetailsLnk.click();
    	
    	//String newHandle=driver.getWindowHandle();
    	ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
    	Thread.sleep(4000);
        driver.switchTo().window(tabs.get(1));
      	Thread.sleep(2000);
    	cliOnPostYouAns.click();
    	
    	String ExpectedAns=enterPostAnsText();
    	generic.waitForElementVisibility(driver, cliOnPost);
    	clickOnPostButtn();
    	Thread.sleep(6000);
    	JavascriptExecutor jse1 = (JavascriptExecutor)driver;
 		jse1.executeScript("window.scrollBy(0,250)", "");
 		
       // String ActualAns=verAns.getText();
		if(platform.equals("Web"))
     	{	
    		int i = 0;
    			
    		String ActualAns=verAns.getText();
    		
     		while(!(ActualAns.equalsIgnoreCase(ActualAns)) && i < 2)
    		{
     			driver.navigate().refresh();
    			i++;
    		}
    		Assert.assertEquals(ActualAns,ExpectedAns);
    		Thread.sleep(3000);
        }}
		public void unfollowPost() throws InterruptedException {
			
			try {
			generic.mouseHoverAndClick(driver, unfollPost, clickOnUnfollow);
			}
			catch(Exception e) 
     	    {
     	    }}
		
		public void verUnfPostNotDisplayed() {
			
//			try {
//			if(cliOnDetailsLnk.isDisplayed())
//			    return false;
//            else
//          {
//              System.out.println("element not displayed");
//           return true;
//          }
//     }
//     catch(Exception e)
//     {
//         return false;
//     }

				
			
		}
          public String verifyUnFollPost() throws InterruptedException {
        	  String mainHandle = driver.getWindowHandle();
          	cliOnDetailsLnk.click();
          	
          	//String newHandle=driver.getWindowHandle();
          	ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
              driver.switchTo().window(tabs.get(1));
              generic.waitForElementVisibility(driver, unfollPost);
              String MyDoubtPost=MyDoubtDetailPost.getText();
              
              unfollowPost();
              
             
              driver.close();
              driver.switchTo().window(mainHandle);
              Thread.sleep(2000);
              return MyDoubtPost;
              
              
              
        	  }
          }
    
    	
    	
    	
    	
        
        
			
			
	       
	     


		
	       
    
    
			 
		    
	

	
		    
			
			
		

	
	


