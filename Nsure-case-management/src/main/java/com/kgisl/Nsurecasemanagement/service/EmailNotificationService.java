package com.kgisl.Nsurecasemanagement.service;

import org.apache.commons.mail.DefaultAuthenticator;

import org.apache.commons.mail.Email;

import org.apache.commons.mail.EmailException;

import org.apache.commons.mail.SimpleEmail;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.kgisl.Nsurecasemanagement.model.EmailNotificationModel;

@Service
public class EmailNotificationService {
	
	@Value("${office365.username}")

	private String username;

 

	@Value("${office365.password}")

	private String password;

	String EmailSubject = "Documents are Due!!";

//	String EmailBody = "Dear User,\"\r\n"
//			+ "				+ \",\\n\\n Please upload the below mentioned documents that are required for your policy approval.";
	
	String EmailBody = "Dear User,\n"

			+ "\n\n     Please upload the below mentioned documents that are required for your policy approval.";

	String ToAddress = "Java_COE_Team@kgisl.com";
	

	

	public void sendEmail(EmailNotificationModel model) {
	
		EmailBody = EmailBody + " \n" + model.getDocumentName() + "\n"+ model.getEmailTextAreaContent();
		Email email = new SimpleEmail();


		email.setHostName("smtp.office365.com");

		email.setSmtpPort(587);

		email.setAuthenticator(new DefaultAuthenticator(username,password));

		email.setStartTLSEnabled(true);

		try {

		    email.setFrom("test@kgisl.com");

		    email.setSubject(EmailSubject);

		    email.setDebug(true);

		    email.setMsg(EmailBody);

		    email.addTo(ToAddress);

		    email.send();

		} catch (EmailException e) {

		    e.printStackTrace();

		}

		

	}

}
