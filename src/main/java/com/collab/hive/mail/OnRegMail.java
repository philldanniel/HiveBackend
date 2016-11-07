package com.collab.hive.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;


@Repository("OnRegMail")
public class OnRegMail {
	
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String to) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Welcome to Hive!");
		message.setText("You have been successfully registered on Hive!");
		mailSender.send(message);
	}
	
}
