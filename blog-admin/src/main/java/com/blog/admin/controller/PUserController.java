package com.blog.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.admin.controller.base.BaseController;
import com.blog.admin.util.PUserUtil;
import com.blog.user.core.entity.PUser;
import com.blog.user.core.service.PUserService;
import com.hecj.common.utils.ResultJson;
import com.hecj.common.utils.StringUtil;
import com.hecj.common.utils.encryp.MD5;

@Controller
public class PUserController extends BaseController{
	
	private static final Log log = LogFactory.getLog(PUserController.class);
	
	@Resource
	public PUserService pUserService; 
	
	/**
	 * 登录
	 * @param email
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/p/login")
	@ResponseBody
	public ResultJson login(String username, String password, String imageCode, HttpServletRequest request,HttpServletResponse response,ModelMap model){

		log.info("login username {} password {} : " + username + "," + password);
		if (StringUtil.isStrEmpty(username)) {
			log.info("username is empty");
			return new ResultJson(-1l, "username is empty");
		}
		if (StringUtil.isStrEmpty(password)) {
			log.info("password is empty");
			return new ResultJson(-2l, "password is empty");
		}
		String session_random_code = (String) request.getSession().getAttribute("session_random_code");
		if (!session_random_code.equalsIgnoreCase(imageCode)){
			log.info("checkcode is error");
			return new ResultJson(-6l, "checkcode is error");
		}
		try {
			PUser puser = pUserService.findPUserByUsername(username);
			if (puser == null){
				log.info("user not exist");
				return new ResultJson(-3l, "user not exist");
			}
			if (!MD5.md5crypt(password).equals(puser.getPassword())) {
				log.info("password is wrong");
				return new ResultJson(-4l, "password is wrong");
			}
			if (puser.getIsDelete() != 0){
				log.info("user is lock");
				return new ResultJson(-5l, "user is lock");
			}
			PUserUtil.setPUser(puser, request.getSession());
			return new ResultJson(200l,"login success");
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			return new ResultJson(-100000l, " server exception");
		}
	}
	
	/**
	 * 注销
	 */
	@RequestMapping(value="/p/u/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		PUserUtil.removePUser(request.getSession());
		return "redirect:/";
	}
	
}
