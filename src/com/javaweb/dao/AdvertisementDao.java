package com.javaweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.po.Advertisement;


@Repository
public interface AdvertisementDao {
	
	public void delete(Advertisement advertisement);
	public void add(Advertisement advertisement);
	public void update(Advertisement advertisement);
	public Advertisement  queryByID(Advertisement advertisement);
	public List<Advertisement> queryall();
	public int deletebyVadids(List<Integer> vauidslist);
	public List<Advertisement> queryByModiferID(int parseInt);

}
