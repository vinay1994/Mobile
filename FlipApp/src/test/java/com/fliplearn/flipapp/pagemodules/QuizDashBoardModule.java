package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class QuizDashBoardModule extends Base
{
	GenericFunctions generic = new GenericFunctions();
	
	@FindBy(xpath="//h4//strong[text()='Quiz Dashboard']")
	@AndroidFindBy(xpath="//*[@text='Quiz Dashboard']") 
	public RemoteWebElement quizDashboardTile;	
	
	@AndroidFindBy(id="com.elss.educomp:id/buy_btn")
	public RemoteWebElement playQuizBtn;
	
	@FindBy(xpath="//ul[@class='dropdown-menu quizMobileDropdown']/li/a")
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View/android.widget.ListView/android.view.View/android.view.View")
	public List<RemoteWebElement> quizDashboardClassLst;
	
	@FindBy(xpath="//div[@class='dropdown section-dropdown']/button")
	@AndroidFindBy(xpath="(//*[@class='android.widget.Button'])[2]")
	public RemoteWebElement classListBtn;
	
	
	@AndroidFindBy(xpath="//*[@text='Play Quiz']")
	public RemoteWebElement playQuizBtn1;
	
	
	@AndroidFindBy(xpath="//*[@text='3']")
	public RemoteWebElement class3;
	
	
	@AndroidFindBy(xpath="//*[@text='Next']")
	public RemoteWebElement Next;
	
	@AndroidFindBy(xpath="//*[@text='Next']")
	public RemoteWebElement Next1;
	
	
	@AndroidFindBy(xpath="//*[@text='ok']")
	public RemoteWebElement ok;
	
	@AndroidFindBy(xpath="//*[@text='Maths']")
	public RemoteWebElement Maths;
	
	public QuizDashBoardModule(WebDriver driver) 
	{
		 PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickOnQuizDashboardTile() throws InterruptedException
	{
		Thread.sleep(2000);
		quizDashboardTile.click();
	}

	public void clickOnClassLst()
	{
		classListBtn.click();
	}
}