package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VMCPurachaseFlow 
{	
	@FindBy(xpath="//h2[text()='Vidyamandir classes online classroom program']")
	public RemoteWebElement vmcHeadline;
	
	public VMCPurachaseFlow(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
