package com.fliplearn.flipapp.helper;

public class Constants 
{
	public final static String PROP_FILE = System.getProperty("user.dir")+"//src//com//fliplearn//flipapp//config//config.properties";
	public final static String ENV_FILE = System.getProperty("user.dir")+"//src//com//fliplearn//flipapp//config//environment.properties";
	public final static String EXCEL_FILE = System.getProperty("user.dir")+"//src//com//fliplearn//flipapp//resources//TestData.xlsx";

	public final static String WINDOWS_CHROME_EXE = System.getProperty("user.dir")+"//driver//chromedriver.exe";
	public final static String WINDOWS_FIREFOX_EXE = System.getProperty("user.dir")+"//driver//firefoxdriver.exe";
	public final static String WINDOWS_IE_EXE = System.getProperty("user.dir")+"//driver//IEDriver.exe";
 
	public final static String LINUX_CHROME_EXE = System.getProperty("user.dir")+"//driver//chromedriver";
	public final static String LINUX_FIREFOX_EXE = System.getProperty("user.dir")+"//driver//firefoxdriver";
	
	public final static String MAC_CHROME_EXE = System.getProperty("user.dir")+"//driver//chromedriver";
	public final static String MAC_FIREFOX_EXE = System.getProperty("user.dir")+"//driver//firefoxdriver";

	
	public final static String EXTENT_REPORT = System.getProperty("user.dir")+"//src//com//fliplearn//flipapp//resources//FinalReport.html";

    public static final String ANDROID_APP_PATH = System.getProperty("user.dir"+"//apps//android");
    public static final String IOS_APP_PATH = System.getProperty("user.dir"+"//apps//ios");
}
