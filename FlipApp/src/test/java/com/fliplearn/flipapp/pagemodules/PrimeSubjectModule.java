package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fliplearn.flipapp.helper.Base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PrimeSubjectModule extends Base
{
	
	@FindBy(xpath="//div[@id='subjectsList0']//div[@class='col-sm-4 ng-scope']//h3")
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	public List<RemoteWebElement> subjectList;
	
	@FindBy(xpath="//div[@class='col-md-9 col-sm-8 col-xs-9']/h3")
	@AndroidFindBy(xpath="//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeCell//XCUIElementTypeStaticText")
	public List<RemoteWebElement> studentSubjectList;

	@FindBy(xpath="//select[@id='selectTerm2']/option")
	public List<RemoteWebElement> classList;
	
	public PrimeSubjectModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

	@FindBy(xpath="//select[@id='selectTerm2']")
	@AndroidFindBy(xpath="//*[@text='Long and Short']")
	@iOSXCUITFindBy(xpath="//XCUIElementTypeStaticText")
	public List<RemoteWebElement> classLst;
		
	public void clickOnSubject(WebDriver driver, String role, String subjectName) throws InterruptedException
    {
		if(platform.equals("Web"))
		{	
			if(role.equals("Student")||role.equals("Parent")||role.equals("Guest"))
				driver.findElement(By.xpath("//h3[text()='"+subjectName+"']")).click();
			else
				driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']//h3[text()='"+subjectName+"']")).click();
		}
		else if(platform.equals("iOS"))
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//XCUIElementTypeButton[@name='Learn'])[1]")).click();

			//driver.findElement(By.xpath("(//XCUIElementTypeStaticText[@name='"+subjectName+"'])//XCUIElementTypeButton[@name='Learn'])")).click();
		}
		else {
			driver.findElement(By.xpath("(//*[@text='Learn'])[3]")).click();
		}
		Thread.sleep(2000);
    }

}
