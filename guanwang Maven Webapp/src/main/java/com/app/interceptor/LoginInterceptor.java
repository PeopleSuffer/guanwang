package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.entiey.Manager;


public class LoginInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/javascript; charset=utf-8");
		//如果不是，判断用户是否登陆
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		if(manager == null){
			//request.getRequestDispatcher("/login.html").forward(request, response);
			//PrintWriter writer = response.getWriter();
			//request.getRequestDispatcher("/login.html").forward(request, response);
			//writer.print("please login");
			//writer.close();
			response.sendRedirect("http://www.yehaikeji.com:8080/guanwang/dist/login.html");
			return false;
		}
		return true;
	}

}
