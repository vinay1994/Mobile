package com.fliplearn.flipapp.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.internal.IResultListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fliplearn.flipapp.util.ConfigUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class Base implements IResultListener
{
	   
	public static Properties aConfig = null;
	public static Properties eConfig = null;
	public static FileInputStream input = null;
		
	public static boolean isInitialized = false;
	public static boolean isBrowserOpened = false;
		
	String platform = "Android";
	String deviceName = "Galaxy J7 Prime";
	String appPath = "D:\\Apps\\app-production-release.apk";
	WebDriver driver;
	
	static String fileExtension = GenericFunctions.formatDateToString();
	static String reportFileName = "AutomationReport" + "_" + fileExtension + ".html";
	
	// initialize the HtmlReporter
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

	// initialize ExtentReports and attach the HtmlReporter
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentTest extentTest;
	ITestResult result;

	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public void setDriver() throws MalformedURLException
	{
		if(platform.equals("Android"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.APP, appPath);
			
			driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(platform.equals("Web"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			
            System.setProperty("webdriver.chrome.driver", "/Users/Tarun/eclipse-workspace/appiumtest/src/test/java/testing/appiumtest/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://app.fliplearn.com/login");
		

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}
	
	/**
	 * This will intialize config file
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public static void Initialize() 
	{
		if (!isInitialized) 
		{
			try 
			{					
				ConfigUtil.loadProperty(); 			
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}	
	}
	

	/**
	 * Execute before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	@BeforeMethod
	public void befo() throws MalformedURLException 
	{
		Base base = new Base();
		Base.Initialize();
		base.setDriver();

		// attach only HtmlReporter
		extentReports.attachReporter(htmlReporter);
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) 
	{
		extentReports.flush();
		
	}

	public void onConfigurationSuccess(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationFailure(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationSkip(ITestResult itr) {
		// TODO Auto-generated method stub
		
	}
}