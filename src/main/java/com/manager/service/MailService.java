package com.manager.service;

import java.util.List;

public interface MailService {
	public boolean send(String from, String to, String subject, String content);
	 public boolean send(String from, List<String> to, String subject, String content);
}
