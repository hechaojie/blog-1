package com.blog.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.admin.controller.base.BaseController;
import com.blog.product.core.service.ArticleService;
import com.blog.product.core.service.ArticleTypeService;
import com.blog.user.core.service.UserService;

@Controller
public class IndexController extends BaseController{

	@Resource
	public UserService userService;
	
	@Resource
	public ArticleService articleService;

	@Resource
	public ArticleTypeService articleTypeService;
	
	/**
	 * 网站入口
	 */
	@RequestMapping(value="/")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap model){
//		redirect/forward:url
		return "forward:/p/u/index";
	}
	
	/**
	 * 转发
	 */
	@RequestMapping(value="/p/u/index")
	public String pIndex(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "index";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping(value="/login")
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "page/login/login";
	}
	
	/**
	 * 404页面
	 */
	@RequestMapping(value="/404")
	public String _404(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		return "page/common/404";
	}
	
}
