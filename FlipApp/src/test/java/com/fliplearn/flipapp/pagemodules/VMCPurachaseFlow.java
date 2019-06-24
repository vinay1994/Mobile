package com.fliplearn.flipapp.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VMCPurachaseFlow 
{	
	@FindBy(xpath="//img[contains(@src,'/images/vmc_flow_icons/vmc_astronaut.png')]")
	public RemoteWebElement vmcAstronautImg;
	
	public VMCPurachaseFlow(WebDriver driver)
	{
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
