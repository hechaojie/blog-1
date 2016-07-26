package com.blog.front.mobile.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.front.mobile.controller.base.BaseController;
import com.blog.front.mobile.util.UserUtil;
import com.blog.user.core.entity.User;
import com.blog.user.core.service.UserService;
import com.hecj.common.utils.ResultJson;
import com.hecj.common.utils.StringUtil;
import com.hecj.common.utils.encryp.MD5;

@Controller
public class IndexController extends BaseController{

	@Resource
	private UserService userService;
	
	/**
	 * 网站入口
	 */
	@RequestMapping(value="/")
	public String index(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
//		redirect/forward:url
//		ModelAndView mav = new ModelAndView("index");
		return "redirect:/p/article";
	}
	
	/**
	 * to login
	 */
	@RequestMapping(value="/login")
	public String toLogin(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
//		redirect/forward:url
//		ModelAndView mav = new ModelAndView("index");
		return "page/index/login";
	}
	
	/**
	 * do Login
	 */
	@RequestMapping(value="/doLogin")
	public String doLogin(String email, String passwd, HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		try {
			
			User user = userService.findUserByEmail(email);
			if(user == null){
				model.addAttribute("data", new ResultJson(-1l,"用户不存在"));
				return "page/index/login";
			}
			
			if(StringUtil.isStrEmpty(passwd)){
				model.addAttribute("data", new ResultJson(-1l,"请输入密码"));
				return "page/index/login";
			}
			
			if(!MD5.md5crypt(passwd).equals(user.getPassword())){
				model.addAttribute("data", new ResultJson(-1l,"密码不正确"));
				return "page/index/login";
			}
			
			UserUtil.setUser(user, request.getSession());
			
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("data", new ResultJson(-1l,"服务器异常"));
			return "page/index/login";
		}
	}
	
	/**
	 * 关于我们
	 */
	@RequestMapping(value="/p/us")
	public String us(HttpServletRequest request,HttpServletResponse response,ModelMap model){

		return "page/index/us";
	}

	/**
	 * 注销
	 */
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		
		UserUtil.removeUser(request.getSession());
		return "redirect:/";
	}
}
