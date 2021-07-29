package sendemail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sendmail {

	 public static void sendme(String recepient,String sendname) throws Exception {
	       
		 Properties properties = new Properties();
		 
		 properties.put("mail.smtp.auth", "true");
		 properties.put("mail.smtp.starttls.enable", "true");
		 properties.put("mail.smtp.host", "smtp.gmail.com");
		 properties.put("mail.smtp.port", "587");
		 
	     
	       
	       
	        final String myAccount = "psk30198@gmail.com";// set from mail id 
	        final String password="*******";//set password of mail id
	     

	       
	        
	        Session session = Session.getInstance(properties,new Authenticator() {
	        	@Override
	        	protected PasswordAuthentication getPasswordAuthentication() {
	        		
	        		return new PasswordAuthentication(myAccount,password);
	        	}
	        }); 
	     
	        Message message =prepareMessage(session,myAccount,recepient,sendname);
	        Transport.send(message);
	        System.out.println("done");
	           
	 }
	 public static Message prepareMessage(Session session,String myAccount,String recepient,String sendname) {
			
		 Message message=new MimeMessage(session);
			try {
				message.setFrom(new InternetAddress("myAccount"));
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
				//mail of Subject useing setsubject() method
				message.setSubject("A quick hello & congrats on the joining the GitHub Team!!");
				//mail of body  useing Settext () method
				message.setText("Dear "+sendname+" \n\n Greething To You !\n\n WELCOME TO MY GitHub Account.\n\nMy GitHub URL:https://github.com/satheesh30\n\n\nThank & Regards,\nMr. Satheesh kumar\nFullStack Development Trainee,\nHaaris Infotech Pvt.Ltd,\nE.mail:psk30198@gmail.com");
				
				return message;
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			return null;
		
	 }
	       

	            
	    }

	

