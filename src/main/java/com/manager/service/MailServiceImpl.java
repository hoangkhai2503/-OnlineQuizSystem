package com.manager.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender sender;
	
	public boolean send(String from, String to, String subject, String content) {
		try {
			// khai bao
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setFrom(from);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setText(content, true);
			sender.send(mimeMessage);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean send(String from, List<String> toList, String subject, String content) {
	    try {
	        // Khởi tạo MimeMessage và MimeMessageHelper
	        MimeMessage mimeMessage = sender.createMimeMessage();
	        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

	        // Thiết lập thông tin email
	        mimeMessageHelper.setFrom(from);
	        
	        // Thiết lập danh sách người nhận
	        String[] toArray = toList.toArray(new String[0]);
	        mimeMessageHelper.setTo(toArray);

	        // Thiết lập tiêu đề và nội dung email
	        mimeMessageHelper.setSubject(subject);
	        mimeMessageHelper.setText(content, true);

	        // Gửi email
	        sender.send(mimeMessage);
	        
	        return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}


}

