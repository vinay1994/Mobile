package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserDetailsModule 
{
	public UserDetailsModule(WebDriver driver) 
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);	
		}
		
		@FindBy(xpath="(//div[@class='radiobutton']/input)[2]")
		public RemoteWebElement teacherRadioBtn;
		
		@FindBy(xpath="(//a[@class='leftse10 ng-scope'])[1]")
		public RemoteWebElement classSectionDrp;
		
		@FindBy(xpath="(//a[@class='leftse10 ng-scope'])[2]")
		public RemoteWebElement subjectsDrp;
		
		@FindBy(xpath="(//a[@class='leftse10 ng-scope'])[1]")
		public RemoteWebElement classTeacher;
		
		// Select Class Section Popup
		@FindBy(xpath="//span[@class='pull-right checkbox']")
		public List<RemoteWebElement> selectListDrp;
		
}
