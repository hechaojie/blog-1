package com.blog.user.core.service;

import java.util.Map;

import com.blog.user.core.entity.PUser;
import com.hecj.common.utils.Pagination;
import com.hecj.common.utils.Result;
/**
 * 管理员接口类
 */
public interface PUserService {
	
	/**
	 * @param params 条件
	 * @param pagination 分页参数
	 * @return
	 */
	public Result findPUsersByCondition(Map<String,Object> params,Pagination pagination);
	
	/**
	 * 根据email查询用户
	 * @param email 邮箱
	 * @return
	 */
	public PUser findPUserByUsername(String username);
	
	/**
	 * 添加管理员
	 * @param puser
	 * @return
	 */
	public boolean addPUser(PUser puser);

	/**
	 * 修改密码
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean updatePassword(long id, String password);
	
	/**
	 * 根据puserId查询管理员
	 */
	public PUser findPUserById(long puserId);
	
}
