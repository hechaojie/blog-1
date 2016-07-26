package com.blog.front.mobile.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.blog.front.mobile.controller.base.BaseController;
import com.blog.front.mobile.util.UserUtil;
import com.blog.user.core.entity.User;
import com.blog.user.core.service.UserService;
import com.hecj.common.utils.ResultJson;
import com.hecj.common.utils.StringUtil;
import com.hecj.common.utils.encryp.MD5;

@Controller
public class UserController extends BaseController{

	@Resource
	private UserService userService;
	
	/**
	 * 我
	 */
	@RequestMapping(value="/p/u")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		return "page/user/index";
	}
	

}
