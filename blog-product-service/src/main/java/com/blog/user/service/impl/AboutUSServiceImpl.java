package com.blog.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.blog.user.core.entity.AboutUS;
import com.blog.user.core.service.AboutUSService;
import com.blog.user.service.dao.AboutUSDao;

public class AboutUSServiceImpl implements AboutUSService {

	@Resource
	private AboutUSDao aboutUSDao;
	
	@Override
	public List<AboutUS> findAllByCondition(Map<String, Object> params) {
		return aboutUSDao.findAllByCondition(params);
	}

}
