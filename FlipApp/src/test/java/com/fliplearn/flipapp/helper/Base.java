package com.fliplearn.flipapp.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fliplearn.flipapp.pagemodules.HeaderModule;
import com.fliplearn.flipapp.util.ConfigUtil;
import com.fliplearn.flipapp.util.ExcelUtil;
import com.fliplearn.flipapp.util.Screenshots;
import com.fliplearn.flipapp.util.SendReportUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base implements ITestListener
{
	public static Properties aConfig;
	public static Properties eConfig = null;
	public static Properties vConfig = null;
	public static FileInputStream input = null;
		
	public static boolean isInitialized = false;
	public static boolean isBrowserOpened = false;
			
	String server;
	public static String platform;
	String deviceName;
	public static String browser;
	String appPath;
	public static String environment;
	public static String url;
	public static RemoteWebDriver driver;
	public static String emailIds;
	public static String suiteType;
	public static String sendReport;
	public static String testName;
	public static String bookstoreSchool;
	public static DesiredCapabilities cap;
	
	static GenericFunctions generic=new GenericFunctions();
	
	static String fileExtension = generic.formatDateToString();
	static String reportFileName = "AutomationReport" + "_" + fileExtension + ".html";
	static String reportPath = generic.reportPath();
	// initialize the HtmlReporter
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath() + reportFileName);

	// initialize ExtentReports and attach the HtmlReporter
	public static ExtentReports extentReports = new ExtentReports();
	public static ExtentTest extentTest;
	ITestResult result;
	ITestContext iTestContext;

	//This will configure report path
	public static String reportPath()
	{
		File file;
		
		if(System.getProperty("os.name").contains("Linux") || System.getProperty("os.name").contains("Mac") )
		{	
				file = new File(System.getProperty("user.dir") + "/reports/");
				
				if(!file.exists())
		            file.mkdir();

				return System.getProperty("user.dir") + "/reports/";
		}
		else
		{		file = new File("C:\\tomcat\\webapps\\fliplearn\\latestreport\\");
				
				if(!file.exists())
					file.mkdir();
		
				return "C:\\tomcat\\webapps\\fliplearn\\latestreport\\";
		}		
	}
	
	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.3
	 */
	public void setDriver() throws MalformedURLException
	{
		server = eConfig.getProperty("Server");
		platform = eConfig.getProperty("Platform");
		browser = eConfig.getProperty("Browser");
		deviceName = eConfig.getProperty("DeviceName");
		environment = eConfig.getProperty("Environment");
		emailIds = eConfig.getProperty("Email");
		suiteType = eConfig.getProperty("SuiteType");
		sendReport = eConfig.getProperty("SendReport");
		bookstoreSchool = aConfig.getProperty(environment+"_Bookstore_School");
		
		url = aConfig.getProperty(platform+"_"+environment+"_Url");
		
		appPath = System.getProperty("user.dir") + "\\apps\\"+platform.toLowerCase()+"_"+environment.toLowerCase()+".apk";
			
		if(platform.equals("Android"))
		{
			cap = new DesiredCapabilities();
			cap.setCapability("automationName", "UiAutomator2");

			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability("appPackage", "com.elss.educomp"); 
		    cap.setCapability("appActivity","com.elss.educomp.prelogin.ui.SplashActivity"); 
		    cap.setCapability("noSign", true);

		    
		    driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if(platform.equals("iOS"))
		{
			
			System.out.println("testing*********************");
			System.getProperty("user.dir");
			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability("platformVersion", "10.3");
//			FlipLearn QC (12.1.4) [33cb75afe59ac83184dbf15a4eb9ed858d7a678e]
		    cap.setCapability("deviceName", "Fliplearn Iphone");
		    cap.setCapability("platformName", "iOS");
		    cap.setCapability("platformVersion", "12.2");
		    cap.setCapability("udid", "af9f8cec090145c64e092f3339fe2f59d832c722");
		    cap.setCapability("bundleId", "com.educomp.smartclassonline");
		   // cap.setCapability(MobileCapabilityType.APP, "/Users/tarungoswami/Downloads/testapp/Fliplearn.app");

		    cap.setCapability("automationName", "XCUITest");
		    cap.setCapability("xcodeOrgId","47M3CKSC66");	
		    cap.setCapability("xcodeSigningId","iPhone Developer");
		    cap.setCapability("noReset", false);

			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}
		
		else if(server.equals("Windows") & platform.equals("Web") & browser.equals("Chrome"))
		{
            System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_CHROME_EXE);
            Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("profile.default_content_setting_values.notifications", 2);
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
	        driver = new ChromeDriver(options);
		System.out.println("Vinay3");
		}
		
		else if(server.equals("Linux") & platform.equals("Web"))
	    {
				if(browser.equals("Chrome"))
				{	
					System.setProperty("webdriver.chrome.driver", Constants.LINUX_CHROME_EXE);
					Map<String, Object> prefs = new HashMap<String, Object>();
			        prefs.put("profile.default_content_setting_values.notifications", 2);
			        ChromeOptions options = new ChromeOptions();
			        options.setExperimentalOption("prefs", prefs);
			        driver = new ChromeDriver(options);
				}
				else if(browser.equals("Firefox")) 
				{
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("start-maximized");
			
					System.setProperty("webdriver.gecko.driver", Constants.LINUX_FIREFOX_EXE);
					driver = new FirefoxDriver();
				}	

		}	
		
		else if(server.equals("Mac") & platform.equals("Web"))
	    {
				if(browser.equals("Chrome"))
				{	
					System.setProperty("webdriver.chrome.driver", Constants.MAC_CHROME_EXE);
					Map<String, Object> prefs = new HashMap<String, Object>();
			        prefs.put("profile.default_content_setting_values.notifications", 2);
			        ChromeOptions options = new ChromeOptions();
			        options.setExperimentalOption("prefs", prefs);
			        driver = new ChromeDriver(options);
				}
				else if(browser.equals("Firefox")) 
				{
					FirefoxOptions options = new FirefoxOptions();
					options.addArguments("start-maximized");
			
					System.setProperty("webdriver.gecko.driver", Constants.MAC_FIREFOX_EXE);
					driver = new FirefoxDriver();
				}	
			
		}

			driver.get(url);
	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	
	
	
	/**
	 * This will intialize config file
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.1
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
	 * This read excel data
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.1
	 */
	public String readData(String platform, String role, String key) throws IOException
	{
		String methodName = new Exception().getStackTrace()[1].getMethodName();
		System.out.println("Calling method name:"+methodName);
		
	 	 Map<String, String> testMap = new HashMap<String, String>();
    	 ExcelUtil excUti = new ExcelUtil();
    	 testMap = excUti.readKeyValue(platform, role, methodName);
    	 
    	 return testMap.get(key);
	}
	/**
	 * Execute before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.1
	 */
	@BeforeMethod
	public void befo(ITestContext it) throws MalformedURLException 
	{
		testName = it.getName();
		System.out.println("TestName is:"+testName);
		Base base = new Base();
		Base.Initialize();
		base.setDriver();
		extentReports.attachReporter(htmlReporter);	
		onTestStart(result);
		if(eConfig.getProperty("Platform").equals("iOS"))
		{	
			((IOSDriver) driver).resetApp();
			System.out.println("App is reset");
		}	

	}

	/**
	 * Before any test method
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	public void onTestStart(ITestResult result) 
	{
	String methodName = new Exception().getStackTrace()[1].getMethodName();
	extentTest = extentReports.createTest(methodName, "Some Description");
		//extentTest = extentReports.createTest(result.getMethod().getMethodName(), "Some Description");

		extentTest.log(Status.INFO, "*******Platform is:"+platform+"*******");
		extentTest.log(Status.INFO, "*******Environment is:"+environment+"*******");
		
		if(platform.equals("WEb"))
		{	
			extentTest.log(Status.INFO, "Browser is:"+browser);
			extentTest.log(Status.INFO, "URL is:"+url);
		}
		
		if(platform.equals("iOS"))
		{	
		HeaderModule heaMod = new HeaderModule(driver);
		try {
			heaMod.clickOnLogoutBtn();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}

	
	/**
	 * After any test method
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@AfterMethod
	public void getResult() throws IOException
	{
		driver.quit();
	//	extentTest.log(Status.INFO, "Browser/Application Closed.");
	}
	
	/**
	 * After Test Suite
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@AfterSuite
	public void aftSuite() throws InterruptedException, IOException
	{
		if(sendReport.equals("True"))
			SendReportUtil.emailReport();
	}


	/**
	 * On Test Failure
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@Override
	public void onTestFailure(ITestResult result) 
	{
	
		
		extentTest.log(Status.FAIL, "Test Failed");	
        String captureScreenshot;
     	
        try 
        {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			captureScreenshot = Screenshots.captureScreenshot(driver,result.getName() + timeStamp);
			extentTest.log(Status.FAIL, result.getThrowable());
			extentTest.log(Status.FAIL, "Snapshot"+extentTest.addScreenCaptureFromPath(captureScreenshot));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}

	}


	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub	
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.log(Status.PASS, "Test Pass");	
		String captureScreenshot;
     	
        try 
        {
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        	captureScreenshot = Screenshots.captureScreenshot(driver,result.getName() + timeStamp);
			extentTest.log(Status.PASS, "Snapshot"+extentTest.addScreenCaptureFromPath(captureScreenshot));
		} 
        catch (IOException e) 
        {
			e.printStackTrace();
		}
	}


	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub	
	}


	/**
	 * On Finish
	 * @author Tarun Goswami
	 * @since 2018-09-30
	 * @version 1.2
	 */
	@Override
	public void onFinish(ITestContext context) 
	{

		extentReports.flush();		
	}
	

	@DataProvider(name = "allusers_old")
	public static Object[] group0_old() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }, { "Parent" }
		  }; 
	}
	
	@DataProvider(name = "allusers")
	public static Object[] group0() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }, { "Parent" }, { "Student" }, { "Guest" }
		  }; 
	}
		
	@DataProvider(name = "staff")
	public static Object[] group2() 
	{
		  return new Object[][]
		  { 
			  { "Admin" }, { "Principal" }, { "Teacher" }
		  }; 
	}
	
	@DataProvider(name = "nostaff")
	public static Object[] group3() 
	{
		  return new Object[][]
		  { 
			  { "Parent" }, { "Student" }, { "Guest" }
		  }; 
	}
	
	@DataProvider(name = "nostaff_new")
	public static Object[] group3_new() 
	{
		  return new Object[][]
		  { 
			  { "Student" }, { "Guest" }
		  }; 
	}
	
	@DataProvider(name="doubt_staff")
	public static Object[] group4_new()
	{
		return new Object[][]
				{
			{ "Teacher" }, { "Student" }, { "Guest" }
				
				};
	}
	
	@DataProvider(name = "logout")
	public static Object[] group4() 
	{
		  return new Object[][]
		  { 
			  { "Logout" }
		  }; 
	}



}
