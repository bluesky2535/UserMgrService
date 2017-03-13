package com.javaweb.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javaweb.po.SysUser;

@Service
@Transactional
public interface SysUserService {

	public int login(SysUser sysUser) throws Exception;

	public String querypage(String page, String rows) throws Exception;

	public int deletebyVsuids(String vsuids) throws Exception;

	public String addSysUser(SysUser sysUser) throws Exception;

	public void modify(SysUser sysUser) throws Exception;

	public SysUser findSysUserbyID(SysUser sysUser) throws Exception;

}
