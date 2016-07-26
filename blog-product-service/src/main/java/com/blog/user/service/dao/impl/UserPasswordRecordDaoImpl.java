package com.blog.user.service.dao.impl;

import java.util.List;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.blog.user.core.entity.UserPasswordRecord;
import com.blog.user.service.dao.UserPasswordRecordDao;

public class UserPasswordRecordDaoImpl extends SqlSessionDaoSupport implements UserPasswordRecordDao {

	@Override
	public List<UserPasswordRecord> findUserPasswordRecordsByUserId(
			long userId, long currPage, int pageSize) {
		return null;
	}

	@Override
	public boolean insert(UserPasswordRecord userPasswordRecord) {

		return false;
	}

}
