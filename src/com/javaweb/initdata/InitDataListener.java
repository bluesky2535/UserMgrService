package com.javaweb.initdata;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Repository;

import com.javaweb.dao.SysUserDao;
import com.javaweb.po.SysUser;
import com.javaweb.utils.MD5Util;

@Repository
@Transactional
public class InitDataListener implements ApplicationListener<ApplicationEvent> {

	@Resource
	SysUserDao sysUserDao;

	@Override
	public void onApplicationEvent(ApplicationEvent arg0) {
		try {
			SysUser s = sysUserDao.findUserbyName(new SysUser("admin"));
			if (s == null) {
				SysUser sysUser = new SysUser();
				sysUser.setVsuname("admin");
				sysUser.setVpassword(MD5Util.MD5("tonghui666"));
				sysUserDao.add(sysUser);
			}
		} catch (Exception e) {
			System.out.println("初始化超级管理员失败");
			e.printStackTrace();
		}

	}

}
