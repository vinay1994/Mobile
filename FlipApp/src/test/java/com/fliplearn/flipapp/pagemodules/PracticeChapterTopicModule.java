package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PracticeChapterTopicModule extends Base{
	GenericFunctions generic = new GenericFunctions();

	public PracticeChapterTopicModule(WebDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(xpath="//*[@class='text-ellipses text-color-black mobilefont14 fontregular ng-binding']")
	public RemoteWebElement verrecomTopText;

    @FindBy(xpath="//*[text()='Book 1 - Science (Biology)']")
    public RemoteWebElement verSubPage;
    
    @FindBy(xpath="//*[contains(@src,'cloudfront')][@class='img-responsive instructionImg border-blue-1 radius10']")
    public RemoteWebElement verImgOnLaunchScreen;
    
    @FindBy(xpath="//*[contains(@src,'cloudfront')][@class='img-responsive radius10']")
    public RemoteWebElement verRecommImg;
    
    @FindBy(xpath="//*[@class='practiceBox1']")
    public RemoteWebElement verRecTopTil;
    
    @FindBy(xpath="//*[contains(text(),'Take basic test')]")
    public RemoteWebElement verTextTakeTest;
    
    @FindBy(xpath="//*[starts-with(text(),'You have to ')]")
    public RemoteWebElement verFliText;
    
    @FindBy(xpath="//*[@class='img-responsive m-t-10']")
    public RemoteWebElement verEasMedDiffImg;
    
    @FindBy(xpath="//*[@class='fontregular font18 itemAligncentermb ng-binding']")
    public RemoteWebElement verTopOnLauScreen;
    
    @FindBy(xpath="//*[@class='font16 textBlack ng-binding']")
    public RemoteWebElement cliOnBackButt;
    
    @FindBy(xpath="(//*[@class='item border-blue-1 border-radius3 padd10 pos-relative cursor practicetopicContent'])[2]")
    public RemoteWebElement cliOnTop2;
    
    @FindBy(xpath="//*[text()='Launch Test']")
    public RemoteWebElement cliOnLauTest;
    
    @FindBy(xpath="(//*[@class='close'])[2]")
    public RemoteWebElement closeLauTest;
    
    @FindBy(xpath="//*[text()='Continue your Learning Flight']")
    public RemoteWebElement verLearnText;
    
    @FindBy(xpath="//*[@class='slider round sliderbground']")
    public RemoteWebElement swiToPraMod;
    
    @FindBy(xpath="//*[text()='What are Life Processes?']")
    public RemoteWebElement verFirstChapter;
    
    @FindBy(xpath="(//*[text()='Autotrophic Nutrition'])")
    public RemoteWebElement cliOnSecTopic;
    
    @FindBy(xpath="(//*[@class='subjectLearn1 ng-scope'])[1]")
    public RemoteWebElement verEarthIcon;
    
    @FindBy(xpath="//div[@class='subjectLearn1 ng-scope']//img[contains(@src,'moon')]")
    public RemoteWebElement verMoonIconforSec; 
    
    @FindBy(xpath="//*[contains(@src,'step_1')]")
    public RemoteWebElement verFirSteImg;
    
    @FindBy(xpath="//h4[text()='You have reached Earth orbit']")
    public RemoteWebElement verReaEarText;
    
    @FindBy(xpath="//*[contains(text(),'Score 60% marks in intermediate')]")
    public RemoteWebElement verInterLevelText;
    
    @FindBy(xpath="//img[contains(@src,'icons/step_2.png')]")
    public RemoteWebElement verSecLevImg;
    
    @FindBy(xpath="//img[@class='img-responsive instructionImg border-blue-1 radius10']")
    public RemoteWebElement verAutoImgOnSubScr;
    
    @FindBy(xpath="//*[text()='1.2 Autotrophic Nutrition']")
    public RemoteWebElement verTopicOnLauScr;
    
    @FindBy(xpath="//*[text()='Instructions']")
    public RemoteWebElement verInsText;
    
    @FindBy(xpath="(//*[text()='Heterotrophic nutrition'])[2]")
    public RemoteWebElement clicOnThiTopic;
      
    @FindBy(xpath="//*[text()='1.3 Heterotrophic nutrition']")
    public RemoteWebElement verMoonTopic;
    
    @FindBy(xpath="//*[text()='You have reached Moon orbit']")
    public RemoteWebElement verMoonOrbText;
    
    @FindBy(xpath="//*[contains(text(),'Score 60% marks in difficult')]")
    public RemoteWebElement verDiffLevText;
    
    @FindBy(xpath="//*[contains(@src,'icons/step_3.png')]")
    public RemoteWebElement verThiSteImg;
    
   public void clickOnFirstTopic() {
	   verFirstChapter.click();
	   }
   
   public void clickOnThirTopic() {
	   clicOnThiTopic.click();
   }
   
    public void clickOnSecTopic() {
    	cliOnSecTopic.click();
    }
    public void clickOnRecommTopic() {
    	verRecTopTil.click();
    }
    
    public void clickOnTopic2() {
    	cliOnTop2.click();
    }
    
    public void clickOnBackButton() {
    	cliOnBackButt.click();
    }
    
    public void clickOnLaunchTest() {
    	cliOnLauTest.click();
    }
    
    public void clickOnCloseLaunchTest() {
    	closeLauTest.click();
    	
    }
    public void switchToPractMod() {
    	swiToPraMod.click();
    }
    
    
    
    
    
    
    
    
   
    
}