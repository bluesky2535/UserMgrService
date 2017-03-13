package com.javaweb.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javaweb.po.AppUser;
import com.javaweb.utils.PageBean;

@Service
@Transactional
public interface AppUserService {
	public void addAppUser(AppUser appUser) throws Exception;

	public void deleteAppUser(AppUser appUser) throws Exception;

	public void updateAppUser(AppUser appUser) throws Exception;

	public AppUser queryAppUserByID(int vauid) throws Exception;

	public PageBean<AppUser> seletbyPageBean(int pagenum,
			PageBean<AppUser> pageBean) throws Exception;

	public AppUser modifyUI(AppUser appUser) throws Exception;

	public void modify(AppUser appUser) throws Exception;

	public String querypage(String page, String rows) throws Exception;

	public int deletebyVauids(String vauids) throws Exception;

}
