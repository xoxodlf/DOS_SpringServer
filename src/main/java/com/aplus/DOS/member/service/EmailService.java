package com.aplus.DOS.member.service;

import javax.mail.MessagingException;

import com.aplus.DOS.member.domain.Email;

public interface EmailService {
	public void sendMail(Email email) throws MessagingException;
}
