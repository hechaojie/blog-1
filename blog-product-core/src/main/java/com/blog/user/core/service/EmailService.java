package com.blog.user.core.service;

import java.util.List;

import com.blog.user.core.email.EmailVars;
import com.blog.user.core.entity.EmailAuthToken;

/**
 * @功能描述 邮件业务处理接口
 * @Version V1.0
 * @Date 2016-1-6 下午4:05:08
 * @author hechaojie
 */
public interface EmailService {

	public long saveEmailAuthToken(EmailAuthToken emailAuthToken);

	public EmailAuthToken findByToken(String token);
	/**
	 * 一次发送一个邮件
	 */
	public void sendEmail(String title, String template, EmailVars email);
	/**
	 * 一次发送多个邮件
	 */
	public void sendEmail(String title, String template, List<EmailVars> emailList);
	
	public boolean updateEmailAuthToken(EmailAuthToken emailAuthToken);

}
