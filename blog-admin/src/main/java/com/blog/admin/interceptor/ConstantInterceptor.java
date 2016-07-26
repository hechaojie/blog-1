package com.blog.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blog.admin.constant.ConfigProvider;
import com.blog.admin.util.PUserUtil;
import com.blog.user.core.entity.PUser;

public class ConstantInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("STATIC_URL", ConfigProvider.STATIC_URL);
		request.setAttribute("RESOURCE_URL", ConfigProvider.RESOURCE_URL);
		PUser puser = PUserUtil.getPUser(request.getSession());
		if(puser != null){
			request.getSession().setAttribute("puser", puser);
		}
		return super.preHandle(request, response, handler);
	}
}
