package com.fliplearn.flipapp.testcases;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;
import com.fliplearn.flipapp.pagemodules.Guru;
import com.fliplearn.flipapp.pagemodules.LoginModule;

public class VMCGuru extends Base 
{
	
	LoginModule logMod;
	Base base;
	GenericFunctions generic;
	Guru guru;
	
   @BeforeMethod
   public void bef3() 
   {
	   logMod = new LoginModule(driver);
	   base = new Base();
	   generic = new GenericFunctions();
	   guru = new Guru(driver);
   }
   
	@Test
	public void validateGuruVideo() throws InterruptedException, IOException 
	{
		String	role="Student";
		logMod.Login(role, "CBSE", "12", "Single", "Guru", "Yes");

		guru.clickOnCoursePageBtn();
		generic.handelingMultipleWindows(driver);
		
		try
		{
			int skipSize = guru.skipPopup.size();
			
			for(int i = 0; i < skipSize; i++)
			{
				guru.skipPopup.get(i).click();
				Thread.sleep(3000);
			}
		}
		catch(Exception e)
		{
			
		}
		
		guru.clickOnVideos();
		
		
	}
}