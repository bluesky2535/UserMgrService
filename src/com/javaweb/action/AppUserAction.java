package com.javaweb.action;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.javaweb.po.AppUser;
import com.javaweb.service.AppUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("appUserAction")
@Scope("prototype")
public class AppUserAction extends ActionSupport implements
		ModelDriven<AppUser> {

	private static final long serialVersionUID = -2821980033532368737L;

	AppUser appUser = new AppUser();
	@Resource
	private AppUserService appUserService;

	private String vauids;

	public String getVauids() {
		return vauids;
	}

	public void setVauids(String vauids) {
		this.vauids = vauids;
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

	// 分页的两个参数
	private String page;
	private String rows;

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

	// 当前页
	private int pagenum = 1;

	/**
	 * 跳转到注册页面
	 * 
	 * @return
	 */
	public String registUI() {

		return "registUI";
	}

	public String deletebyVauids() {
		try {
			int i = appUserService.deletebyVauids(vauids);

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter p;

			p = response.getWriter();
			p.write(String.valueOf(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String regist() {

		try {
			appUserService.addAppUser(appUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return NONE;
	}

	/**
	 * 登录界面
	 * 
	 * @return
	 */
	public String loginUI() {

		return "loginUI";
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {

		return "login";
	}

	/**
	 * 跳转到更新用户界面
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String modifyUI() throws Exception {
		appUser = appUserService.modifyUI(appUser);
		return "modifyUI";
	}

	/**
	 * 执行更新APPUSER操作
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String modify() throws Exception {
		appUserService.modify(appUser);
		return "modifySuccess";
	}

	/**
	 * ModelDriven的实现方法
	 */
	public AppUser getModel() {

		return appUser;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public String queryAppUserPage() {

		return "queryAppUserPage";
	}

	/**
	 * 查出分页的数据Json
	 * 
	 * @return
	 */
	public String queryAppuserJson() {
		System.out.println(appUserService);
		String appUserjson;
		try {
			appUserjson = appUserService.querypage(page, rows);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf-8");
			PrintWriter p = response.getWriter();
			p.write(appUserjson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
}
