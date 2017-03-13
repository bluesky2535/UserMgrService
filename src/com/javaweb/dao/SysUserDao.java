package com.javaweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.po.SysUser;


@Repository
public interface SysUserDao {
	public SysUser  findUserbyNameAndPassword(SysUser sysUser) throws Exception;

	public int selectCount() throws Exception;

	public List<SysUser> queryPage(int parseInt, int parseInt2) throws Exception;

	public int deletebyVsuids(List<Integer> vsuidslist) throws Exception;

	public void add(SysUser sysUser) throws Exception;

	public void update(SysUser sysUser) throws Exception;

	public SysUser findUserbyName(SysUser sysUser)throws Exception;

	public SysUser findSysUserbyID(SysUser sysUser) throws Exception;
}
