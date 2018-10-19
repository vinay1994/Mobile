package com.fliplearn.flipapp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.fliplearn.flipapp.helper.Base;
import com.fliplearn.flipapp.helper.GenericFunctions;

public class SendReportUtil extends Base
{
	public static void emailReport() throws InterruptedException, IOException
	{
		GenericFunctions generic=new GenericFunctions();
        final String username = "fliplearnqa@gmail.com";
        final String password = "flipqa@123";

        Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("fliplearnqa","flipqa@123");
				}
			});

     try 
     {
    	 String currentDir = System.getProperty("user.dir");
    	 File getLastFileName = generic.getLatestFilefromDir("C:\\tomcat\\webapps\\fliplearn\\latestreport");


    	 String reportFilePath = getLastFileName.toString();
  
    	 System.out.println("Report File Path:" +reportFilePath);
           
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("tarun.sage@gmail.com"));

           
         System.out.println("email ids are:"+emailIds);
         String emailIds_New = "tarun.goswami@fliplearn.com," + emailIds;   
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailIds_New));
                   
         Multipart multipart = new MimeMultipart();
            
         String subject = platform + " " + environment + " " + suiteType;
        
         message.setSubject("Automation Report: "+subject);
         BodyPart messageBodyPart = new MimeBodyPart();
         
         String bodyMessage = "<font color='blue'>Download Attachment to View Test Case Report </a>";
         messageBodyPart.setContent(bodyMessage, "text/html; charset=utf-8");
         multipart.addBodyPart(messageBodyPart);
         messageBodyPart = new MimeBodyPart();
         DataSource source = new FileDataSource(reportFilePath);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(reportFilePath);
         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart);
         Transport.send(message);
        System.out.println("Mail Sent Successfully!");
        

    

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
