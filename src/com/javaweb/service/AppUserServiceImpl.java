package com.javaweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.javaweb.dao.AppUserDAO;
import com.javaweb.po.AppUser;
import com.javaweb.po.AppUserVO;
import com.javaweb.utils.MD5Util;
import com.javaweb.utils.PageBean;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService {

	@Resource
	private AppUserDAO appUserDAO;

	/**
	 * 增加用户,并且实现密码加密
	 */
	public void addAppUser(AppUser appUser) throws Exception {

		String vpassword = appUser.getVpassword();
		String md5password = MD5Util.MD5(vpassword);
		appUser.setVpassword(md5password);
		appUserDAO.save(appUser);
	}

	/**
	 * 删除用户
	 */
	public void deleteAppUser(AppUser appUser) throws Exception {
	}

	/**
	 * 更新用户
	 */
	public void updateAppUser(AppUser appUser) throws Exception {

	}

	/**
	 * 根据ID查出用户
	 */
	public AppUser queryAppUserByID(int vauid) throws Exception {
		return null;
	}

	/**
	 * 分页查出AppUser
	 */
	public PageBean<AppUser> seletbyPageBean(int pagenum,
			PageBean<AppUser> pageBean) throws Exception {

		int records = appUserDAO.selectCount();
		List<AppUser> appusers = appUserDAO.queryPage(pagenum,
				pageBean.getPagesize());
		pageBean.setPagenum(pagenum);
		pageBean.setList(appusers);
		pageBean.setRecords(records);

		return pageBean;
	}

	/**
	 * 根据ID查出相应的APPUSER,并返回给Model
	 */
	public AppUser modifyUI(AppUser appUser) throws Exception {
		AppUser a = appUserDAO.queryAppUserByID(appUser.getVauid());
		return a;
	}

	/**
	 * 更新APPUSER
	 */
	public void modify(AppUser appUser) throws Exception {

		appUserDAO.update(appUser);

	}

	/**
	 * 将AppUser转换为AppUserVo
	 */
	public String querypage(String page, String rows) throws Exception {
		int appuserCount = appUserDAO.selectCount();
		List<AppUser> appUsers = appUserDAO.queryPage(Integer.parseInt(page),
				Integer.parseInt(rows));
		List<AppUserVO> appUserVOs = new ArrayList<AppUserVO>();
		for (AppUser appUser : appUsers) {

			AppUserVO appUserVO = new AppUserVO();
			try {
				BeanUtils.copyProperties(appUserVO, appUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
			appUserVOs.add(appUserVO);
		}
		String s = JSON.toJSONString(appUserVOs);
		// 如果让easyUI可以显示总页数，需要格式为{"total"：25,"rows":"[{},{}]"}
		String appUserjson = "{\"total\"" + ":" + appuserCount + ",\"rows\":"
				+ s + "}";
		return appUserjson;
	}

	public int deletebyVauids(String vauids) throws Exception {
		List<Integer> vauidslist = new ArrayList<Integer>();
		String[] vauidss = vauids.split(",");
		for (String vauid : vauidss) {
			vauidslist.add(Integer.parseInt(vauid));
		}
		int i = appUserDAO.deletebyVauids(vauidslist);
		return i;
	}
}
