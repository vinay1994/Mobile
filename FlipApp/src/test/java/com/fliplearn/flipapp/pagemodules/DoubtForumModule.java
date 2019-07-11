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
	
	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	@FindBy(xpath="(//*[text()='Doubt Forum'])[1]")
	public RemoteWebElement clickOnDouFor;
	
	@FindBy(xpath="//*[@class='hidden-xs ng-binding']")    
	public List<RemoteWebElement >verNoOfTab;
	
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
	public RemoteWebElement clickOnAskUrDoubt;
	
	@FindBy(xpath="(//*[@placeholder='Ask your doubt'])[2]")
	public RemoteWebElement entText;
	
	@FindBy(xpath="//*[text()='Search']")
	public RemoteWebElement cliOnSearch;
	
	@FindBy(name="subject")
	public RemoteWebElement selectSubject;
	
	@FindBy(name="chapter")
	public RemoteWebElement slectChap;
	
	@FindBy(xpath="//*[text()='Create']")
	public RemoteWebElement cliOnCreate;
	
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
	
	public void clickOnDoubtForumBtn() {
		clickOnDouFor.click();
		}
	public void clickOnAskYourDoubt() {
		clickOnAskUrDoubt.click();
	}
	
	public String enterAskYourDoubtText() {
		
		String postTitle = "Testing doubtforum Post_"+timeStamp;
		entText.sendKeys(postTitle);
		
		return postTitle;
		}
	public void clickOnSearchButtn() {
		cliOnSearch.click();
	}
	
	public  void verifyNumOfDoubtForuTab(String role) throws InterruptedException, IOException {
		 List<RemoteWebElement> actualList = verNoOfTab;}
	
    public void selectSubjectFromDropDwn() {
    	selectSubject.click();
    	generic.selectByVisibleText(selectSubject,"Maths");
    	
    }
    public void selectChapFromDropdwn() {
    	slectChap.click();
    	generic.selectByVisibleText(slectChap, "Polynomials");
    }
    public void clickOnCreateButton() {
    	cliOnCreate.click();
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
    
    	
    	
    	
    	
        
        
			
			
	       
	     


		
	       
    
    
			 
		    
	

	
		    
			
			
		

	
	


