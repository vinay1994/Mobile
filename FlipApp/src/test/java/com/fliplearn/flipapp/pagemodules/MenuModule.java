package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MenuModule 
{
	@FindBy(xpath="//button[contains(text(),'Skip')]")
	@AndroidFindBy(id="com.elss.educomp:id/btn_finish")
	@AndroidFindBy(className="android.widget.ImageButton")
	public RemoteWebElement menuBtn;
	
	public MenuModule(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public void skipScreen()
	{
		menuBtn.click();
	}
}
