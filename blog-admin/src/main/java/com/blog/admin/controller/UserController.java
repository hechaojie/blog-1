package com.blog.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.container.page.Page;
import com.blog.admin.controller.base.BaseController;
import com.blog.user.core.entity.User;
import com.blog.user.core.service.UserService;
import com.hecj.common.utils.Pagination;
import com.hecj.common.utils.Result;
import com.hecj.common.utils.StringUtil;

@Controller
public class UserController extends BaseController{
	
	private static final Log log = LogFactory.getLog(UserController.class);
	
	@Resource
	public UserService userService; 
	
	/**
	 * user list
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/p/u/user/manager")
	public String manager(Long pageNumber, Integer pageSize, String email, HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		if(pageNumber == null){
			pageNumber = 1l;
		}
		if(pageSize == null){
			pageSize = 20;
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("page", pageNumber);
		params.put("size", pageSize);
		if(!StringUtil.isStrEmpty(email)){
			params.put("email", email);
		}
		try {
			
			Pagination pagination = new Pagination();
			pagination.setCurrPage(pageNumber);
			pagination.setPageSize(pageSize);
			
			Result result = userService.findUsersByCondition(params, pagination);
			model.addAttribute("result", result);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("email", email);
		
		return "page/user/manager";
	}
	
}
