package com.fliplearn.flipapp.pagemodules;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SubjectContentModule {
	
	@FindBy(xpath="//a[contains(text(),'Class 10')]")
	@AndroidFindBy(id="")
	@iOSFindBy(id="")
	public List<RemoteWebElement> claConMod;
	
//	@FindBy(xpath="//h3[text()='Biology']")
//	@AndroidFindBy(id="")
//	@iOSFindBy(id="")
//	public List<RemoteWebElement> subConMod;
	
	
	
	
	
	

}
