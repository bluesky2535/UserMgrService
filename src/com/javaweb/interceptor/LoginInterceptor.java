package com.javaweb.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.javaweb.po.SysUser;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation)
			throws Exception {
		SysUser sysUser = (SysUser) ServletActionContext.getRequest()
				.getSession().getAttribute("sysUser");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		if (sysUser == null) {
			pw.write("您还没有登录，请去登录");
			return "nosysUser";
		}
		return actionInvocation.invoke();
	}

}
