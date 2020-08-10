package com.project.springmvc.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 로그인 상태 확인을 위한 Session 객체 확인
		HttpSession session=request.getSession(false);
		if(session!=null && session.getAttribute("loginMember") != null) {
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/member/login");
		return false;
	}
	
	

}
