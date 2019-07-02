package com.fliplearn.flipapp.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.EventModule;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.pagemodules.HomeModule;
import com.fliplearn.flipapp.pagemodules.LearnModule;
import com.fliplearn.flipapp.pagemodules.LoginModule;
import com.fliplearn.flipapp.pagemodules.MenuModule;
import com.fliplearn.flipapp.pagemodules.MobileNumberModule;
import com.fliplearn.flipapp.pagemodules.MyWallModule;
import com.fliplearn.flipapp.pagemodules.NoticeboardModule;
import com.fliplearn.flipapp.pagemodules.OnboardingModule;
import com.fliplearn.flipapp.pagemodules.PrimeChapterTopicModule;
import com.fliplearn.flipapp.pagemodules.PrimeResourceViewModule;
import com.fliplearn.flipapp.pagemodules.QuizModule;
import com.fliplearn.flipapp.pagemodules.SignInAsModule;
import com.fliplearn.flipapp.pagemodules.YourProfileModule;

public class Home extends Base
{
	GenericFunctions generic;
	LoginModule logMod;
	OnboardingModule onbMod;
	MobileNumberModule mobNumMod;
	EventModule eveMod;
	MenuModule menMod;
	SignInAsModule signInMod;
	QuizModule quiMod;
	YourProfileModule youProMod;
	HeaderModule heaMod;
	LearnModule learnMod;
	HomeModule homMod;
	PrimeChapterTopicModule PriChaTopMod;
	PrimeResourceViewModule priResVieMod;
	MyWallModule myWalMod;
	NoticeboardModule notMod;
	
	@BeforeMethod
	public void beforeEvent()
	{
		generic = new GenericFunctions();
		logMod = new LoginModule(driver);
		onbMod = new OnboardingModule(driver);
		mobNumMod = new MobileNumberModule(driver);
		eveMod = new EventModule(driver);
		signInMod = new SignInAsModule(driver);
	    quiMod = new QuizModule(driver);
	    youProMod = new YourProfileModule(driver);
	    heaMod = new HeaderModule(driver);
	    homMod = new HomeModule(driver);
	    PriChaTopMod = new PrimeChapterTopicModule(driver);
	    priResVieMod = new PrimeResourceViewModule(driver);
	    myWalMod = new MyWallModule(driver);
	    notMod = new NoticeboardModule(driver);
	}
	
	/**
	 * Verify Default Mode is Practice
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.2
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void verifyDefaultMode(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to learning mode");
		generic.waitForElementVisibility(driver, homMod.practiceModeBtn);
		Assert.assertTrue(homMod.practiceModeBtn.isDisplayed());
	}
	
	/**
	 * Verify User can switch between learning and practice mode
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void verifyLearnPracticeMode(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to learning mode");

		homMod.clickOnlearnPracticeModeBtn();
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to practice mode");
		generic.waitForElementVisibility(driver, homMod.learningModeBtn);
		Assert.assertTrue(homMod.learningModeBtn.isDisplayed());

		homMod.clickOnlearnPracticeModeBtn();
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to learning mode");	
		generic.waitForElementVisibility(driver, homMod.practiceModeBtn);
		Assert.assertTrue(homMod.practiceModeBtn.isDisplayed());
	}
	
	/**
	 * Verify User mode selected on Home Page apply to other pages
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void verifyGlobalModeSelection(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "10", "Single", "Prime", "Yes");
		
		//Default mode is Practice
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to learning mode");

		//Practice on Subject Page
		homMod.selectSubject("Chemistry");
		generic.waitForElementVisibility(driver, homMod.practiceModeBtn);
		Assert.assertTrue(homMod.practiceModeBtn.isDisplayed());
		Assert.assertEquals(PriChaTopMod.learnPracticeModeTxt.getText(), "Switch to learning mode");

		driver.navigate().back();

		//Practice when navigate back
		generic.waitForElementVisibility(driver, homMod.practiceModeBtn);
		Assert.assertTrue(homMod.practiceModeBtn.isDisplayed());
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to learning mode");
		
		//Switch to Learning mode
		homMod.clickOnlearnPracticeModeBtn();
		Assert.assertEquals(homMod.learnPracticeModeTxt.getText(), "Switch to practice mode");
		generic.waitForElementVisibility(driver, homMod.learningModeBtn);
		Assert.assertTrue(homMod.learningModeBtn.isDisplayed());
		
		//Learning on Subject Page
		homMod.selectSubject("Chemistry");
		generic.waitForElementVisibility(driver, homMod.learningModeBtn);
		Assert.assertTrue(homMod.learningModeBtn.isDisplayed());
		Assert.assertEquals(PriChaTopMod.learnPracticeModeTxt.getText(), "Switch to practice mode");
	}
	
	/**
	 * Verify User can switch between previous and next classes
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void verifySwitchClass(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		homMod.selectClass("Class 5"); 
		Assert.assertEquals(homMod.verifySubjectDisplayed("Social Studies"), false);
		
		homMod.selectClass("Class 7"); 
		Assert.assertEquals(homMod.verifySubjectDisplayed("Social Studies"), true);		
	}	
	
	/**
	 * Verify Popular Video Icon, Title and Thumbnail on Homepage
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void popularVideoContent(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.popularVideosHeading);
		
		Assert.assertTrue(homMod.popularVideoName.isDisplayed());
		Assert.assertTrue(homMod.popularVideoBtn.isDisplayed());
		Assert.assertTrue(homMod.popularVideo.isDisplayed());
	}
	
	/**
	 * Verify User can view popular videos on Home Screen
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void playPopularVideos(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.popularVideosHeading);
		
		String firstPopularVideoName = homMod.popularVideoName.getText();
		homMod.clickOnPopularVideo();
		String firstPopularVideoModalHeading = homMod.popularVideoModalHeading.getText();
		
		Assert.assertEquals(firstPopularVideoName, firstPopularVideoModalHeading);	
		priResVieMod.verifyVideoContent(driver, "firstPopularVideoName");
	}
	
	/**
	 * Verify Fliplearn Wall Heading and Thumbnail
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void fliplearnWallContent(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.fliplearnWallHeading);
		
		Assert.assertTrue(homMod.fliplearnWallThumb.isDisplayed());
		Assert.assertEquals(homMod.fliplearnWallThumbs.size(), 5);
	}

	/**
	 * Verify Fliplearn Wall Thumbnail redirect to Wall Content
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void fliplearnWallThumbnail(String role) throws InterruptedException, IOException
	{
		boolean myFlag = false;
		
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.fliplearnWallHeading);
		
		String expectedImg = homMod.fliplearnWallVideoThumb.getAttribute("src");
		
		String[] hello = expectedImg.split("/");
		expectedImg = hello[hello.length - 2];
		
		System.out.println("Expected Image:"+expectedImg);
	
		homMod.clickOnMyWallContent();
		
		generic.waitForElementVisibility(driver, myWalMod.myWallHeading);
		String actualImg = myWalMod.myWallVideoThumb.getAttribute("src");
		System.out.println("Expected Image:"+expectedImg);
		System.out.println("Actual Image:"+actualImg);
	
		Assert.assertTrue(actualImg.contains(expectedImg));
	}
	
	/**
	 * Verify Fliplearn Wall Thumbnail redirect to Wall Content
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test(dataProvider = "nostaff_new")
	public void fliplearnWallMore(String role) throws InterruptedException, IOException
	{
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.fliplearnWallHeading);
		homMod.clickOnFliplearnWallMoreBtn();
		
		generic.waitForElementVisibility(driver, myWalMod.myWallHeading);	
		Assert.assertTrue( myWalMod.myWallThumb.isDisplayed());
	}
	
	/**
	 * Verify Fliplearn Noticeboard Content
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void noticeboardContent() throws InterruptedException, IOException
	{
		String role= "Student";
		
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.noticeboardHeading);
		
		Assert.assertTrue(homMod.noticeboardThumb.isDisplayed());
		Assert.assertEquals(homMod.noticeboardThumbs.size(), 5);
		Assert.assertTrue(homMod.noticeTitle.isDisplayed());
		Assert.assertTrue(homMod.noticeboardEventType.isDisplayed());
	}
	
	/**
	 * Verify Noticeboard Thumbnail redirect to Noticeboard Page
	 * @author Tarun Goswami
	 * @since 2019-04-12
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void noticeboardThumbnail() throws InterruptedException, IOException
	{
		String role = "Student";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.noticeboardHeading);
		
		String expectedTitle = homMod.noticeTitle.getText();
		homMod.clickOnNoticeboardContent();
		
		generic.waitForElementVisibility(driver, notMod.noticeboardHeading);
		
		String actualTitle = notMod.noticeTitle.getText();
	
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	/**
	 * Verify Noticeboard Content redirect to Noticeboard Page Content
	 * @author Tarun Goswami
	 * @since 2019-04-11
	 * @version 1.1
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	@Test
	public void noticeboardMore() throws InterruptedException, IOException
	{
		String role = "Student";
		logMod.Login(role, "CBSE", "6", "Single", "Prime", "Yes");
		
		generic.waitForElementVisibility(driver, homMod.noticeboardHeading);
		homMod.clickOnNoticeboardMoreBtn();
		
		generic.waitForElementVisibility(driver, notMod.noticeboardHeading);	
		Assert.assertTrue(notMod.noticeTitle.isDisplayed());
	}
}

