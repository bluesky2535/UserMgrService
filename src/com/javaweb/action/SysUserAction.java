package com.javaweb.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.javaweb.po.SysUser;
import com.javaweb.service.SysUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("sysUserAction")
@Scope("prototype")
public class SysUserAction extends ActionSupport implements
		ModelDriven<SysUser> {
	private static final long serialVersionUID = -761260003660048718L;
	@Resource
	private SysUserService sysUserService;
	private String page;
	private String rows;
	private String vsuids;

	public String getVsuids() {
		return vsuids;
	}

	public void setVsuids(String vsuids) {
		this.vsuids = vsuids;
	}

	SysUser sysUser = new SysUser();

	/**
	 * 跳转到SysUser的登录界面
	 * 
	 * @return
	 */
	public String loginUI() {

		return "loginUI";
	}

	public String login() {
		int flag;
		try {
			flag = sysUserService.login(sysUser);
			if (flag == 0) {
				ServletActionContext.getRequest().setAttribute("loginFail",
						"您的用户名或密码错误，请重新登录！");
				return "loginFail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("loginFail", "登录失败");
			return "loginFail";
		}
		return "loginSuccess";
	}

	public SysUser getModel() {
		return sysUser;
	}

	/**
	 * 登录成功后显示的后台管理界面
	 * 
	 * @return
	 */
	public String mainUI() {

		return "mainUI";
	}

	/**
	 * 跳转到修改SysUser的界面
	 * 
	 * @return
	 */
	public String modifyUI() {
		try {
			sysUser = sysUserService.findSysUserbyID(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifyUI";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String modify() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			sysUserService.modify(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
			p.write("N");
			return NONE;
		}
		return NONE;
	}

	/**
	 * 管理员退出系统
	 * 
	 * @return
	 */
	public String quit() {
		ServletActionContext.getRequest().getSession()
				.removeAttribute("sysUser");
		return "quitSuccess";
	}

	/**
	 * 查出分页的数据Json
	 * 
	 * @return
	 */
	public String querySysUserJson() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			String sysUserjson = sysUserService.querypage(page, rows);
			p.write(sysUserjson);
		} catch (Exception e1) {
			e1.printStackTrace();
			p.write("fail");
			return NONE;
		}

		return NONE;
	}

	public String querySysUserPage() {

		return "querySysUserPage";
	}

	public String deletebyVsuids() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			int i = sysUserService.deletebyVsuids(vsuids);
			p.write(String.valueOf(i));
		} catch (Exception e1) {
			e1.printStackTrace();
			p.write("fail");
			return NONE;
		}
		return NONE;
	}

	public String registUI() {
		return "registUI";
	}

	public String regist() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			String flag = sysUserService.addSysUser(sysUser);
			if (flag.equals("Y")) {
				p.write("Y");
				return NONE;
			}
			p.write("N");
		} catch (Exception e) {
			e.printStackTrace();
			p.write("N");
			return NONE;
		}
		return NONE;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

}
