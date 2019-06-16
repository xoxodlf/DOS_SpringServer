package com.aplus.DOS.member.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.aplus.DOS.member.domain.Email;

@Service
public class EmailServiceImplement implements EmailService{
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;
	@Override
	public void sendMail(Email email) throws MessagingException{
		MimeMessagePreparator messagePreparator = message -> {
			MimeMessageHelper helper = new MimeMessageHelper(message);
			//helper.addAttachment("img.jpg", new ClassPathResource("/static/img/password.jpg"));
			helper.setSubject("임시 비밀번호 발급 메일입니다.");
			helper.setFrom(new InternetAddress("xoxodlf@gmail.com"));
			helper.setTo(new InternetAddress(email.getRecipient()));
			helper.setSentDate(new Date());
			String content = build("변경된 비밀번호는 " +email.getContent() +" 입니다.");
			helper.setText(content, true);
		};
		
		javaMailSender.send(messagePreparator);
	}
	public String build(String message) {
		Context context = new Context();
		context.setVariable("message", message);
		return templateEngine.process("EmialTemplate", context);
	}
	
//	@Override
//	public void sendMail(Email email) throws MessagingException{
//		MimeMessage message = javaMailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message,
//                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
//                StandardCharsets.UTF_8.name());
//		//helper.addAttachment("img.jpg", new ClassPathResource("/static/img/password.jpg"));
//		helper.setSubject("임시 비밀번호 발급 메일입니다.");
//		helper.setText("변경된 비밀번호는 " +email.getContent() +" 입니다.");
//		helper.setFrom(new InternetAddress("xoxodlf@gmail.com"));
//		helper.setTo(new InternetAddress(email.getRecipient()));
//		helper.setSentDate(new Date());
//		
//		javaMailSender.send(message);
//	}



}
