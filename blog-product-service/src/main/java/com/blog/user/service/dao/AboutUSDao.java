package com.blog.user.service.dao;

import java.util.List;
import java.util.Map;

import com.blog.user.core.entity.AboutUS;

public interface AboutUSDao {
	
	public List<AboutUS> findAllByCondition(Map<String,Object> sqlParams);
	
}
