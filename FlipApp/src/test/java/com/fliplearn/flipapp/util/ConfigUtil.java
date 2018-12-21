package com.fliplearn.flipapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Properties;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.Constants;

public class ConfigUtil extends Base 
{
	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2018-09-20
	 * @version 1.0
	 */
	public static void loadProperty() throws IOException
	{
		aConfig = new Properties();
		input =new FileInputStream(Constants.PROP_FILE);
		aConfig.load(input);
		
		eConfig = new Properties();
		if(Inet4Address.getLocalHost().getHostAddress().equals("192.168.109.2"))
		{
			input = new FileInputStream("C:\\tomcat\\webapps\\fliplearn\\Environment.properties");
		}
		else
		input =new FileInputStream(Constants.ENV_FILE);
		eConfig.load(input);
		
		vConfig = new Properties();
		input =new FileInputStream(Constants.VIDEO_FILE);
		vConfig.load(input);
	}
}
