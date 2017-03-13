package com.javaweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.po.Announce;
@Repository
public interface AnnounceDao {
	
	public void add(Announce announce);
	public void delete(Announce announce);
	public void update(Announce announce);
	public Announce queryByID(Announce announce);
	public List<Announce> queryAll();
	public int deletebyVanids(List<Integer> vanidslist);
	public List<Announce> queryByModiferID(int parseInt);
	public List<Announce> querybyGrade(int grade);

	
	
}
