package spring.rest.loginControler;

import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.rowset.spi.TransactionalWriter;

import org.springframework.stereotype.Component;
@Component
class Mail_Sending {

    	//responsible to send email
	private boolean sendEmail(String message, String subject, String to, String from) {
		
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		//System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("aryasharma9634@gmail.com", "xbcixlfotqjequgx");
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		//System.out.println("Sent success...................");
		
		
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	public  boolean send(String to,String otp) {
		{
			
			System.out.println("preparing to send message ...");
			String message = "Hii ,\nHere is your one-time-password that will sign you in instantly..\nYour OTP is \t"+otp+
					"\nThis OTP is valid for 2 mins. Please do not forward this email to others to prevent anybody else from accessing your account.\r\n"
					+ "The Unitral Team\r\n";
;
			String subject = "Unitral: authentification";
			//String to = "abhirajvarshney27035@gmail.com";
			String from = "aryasharma9634@gmail.com";
			
			return sendEmail(message,subject,to,from);
			
		//	sendAttach(message,subject,to,from);
		}
		// TODO Auto-generated method stub
		
	}
}
