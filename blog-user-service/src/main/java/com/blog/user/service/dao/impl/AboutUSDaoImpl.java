package com.blog.user.service.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.user.core.entity.AboutUS;
import com.blog.user.service.dao.AboutUSDao;

public class AboutUSDaoImpl extends SqlSessionDaoSupport implements AboutUSDao {
	
	@Override
	public List<AboutUS> findAllByCondition(Map<String, Object> sqlParams) {
		
		return this.getSqlSession().selectList("aboutUS.findAllByCondition", sqlParams);
	}
	
}
