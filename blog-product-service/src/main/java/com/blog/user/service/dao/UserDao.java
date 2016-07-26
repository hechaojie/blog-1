package com.blog.user.service.dao;

import java.util.List;
import java.util.Map;

import com.blog.user.core.entity.User;

public interface UserDao {
	
	public List<User> findAll();
	
	public List<User> findUsersByConditions(Map<String,Object> params,long currPage,int pageSize);
	
	public long totalUsersByConditions(Map<String,Object> params);

	public User findUserById(long userId);
	
	public User findUserByEmail(String email);
	
	public boolean updateUserPasswd(long userId,String password);
	
	public long save(User user);
}
