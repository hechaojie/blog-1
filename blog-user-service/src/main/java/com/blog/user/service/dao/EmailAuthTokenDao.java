package com.blog.user.service.dao;

import com.blog.user.core.entity.EmailAuthToken;

public interface EmailAuthTokenDao {
	
	public long save(EmailAuthToken emailAuthToken);
	
	public EmailAuthToken findByToken(String token);
	
	public boolean update(EmailAuthToken emailAuthToken);
}
