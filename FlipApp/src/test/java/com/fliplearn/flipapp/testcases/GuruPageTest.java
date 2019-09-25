package com.fliplearn.flipapp.testcases;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.Guru;
import com.fliplearn.flipapp.pagemodules.LoginModule;

public class GuruPageTest extends Base {
	
	LoginModule logMod;
	Base base;
	GenericFunctions generic;
	Guru guru;
	
   @BeforeMethod
   public void bef3() {
	logMod = new LoginModule(driver);
	base = new Base();
	generic = new GenericFunctions();
	guru=new Guru(driver);
   }
   
	@Test
	public void validatePageTitle() throws InterruptedException, IOException {
		String	role="Student";
		logMod.Login(role, "CBSE", "12", "Single", "Prime", "Yes");

		String MainWindow = driver.getWindowHandle();
		System.out.println("old current window"+MainWindow);

		guru.clickOnCoursePageBtn();
		generic.handelingMultipleWindows(driver);

		guru.clickOnVideos();		
	
}
		
	}
	
	
	
	

	
	
	
	

