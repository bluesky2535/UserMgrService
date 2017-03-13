package com.javaweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.po.AppUser;

@Repository
public interface AppUserDAO {
	public void save(AppUser appUser)throws Exception;

	public void delete(AppUser appUser)throws Exception;

	public void update(AppUser appUser)throws Exception;

	public AppUser queryAppUserByID(int vauid)throws Exception;

	public int selectCount()throws Exception;

	public List<AppUser> queryPage(int page, int rows)throws Exception;

	public int deletebyVauids(List<Integer> vauidslist)throws Exception;

	public AppUser findUser(AppUser appUser)throws Exception;

	public AppUser  findUserbyVtel(AppUser appUser) throws Exception;

}
