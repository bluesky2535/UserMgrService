package com.javaweb.service;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javaweb.po.Advertisement;

@Transactional
@Service
public interface AdvertisementService {
	public void publish(Advertisement advertisement, File upload, String uploadFileName, String uploadContentType) throws Exception;

	public Advertisement queryByID(Advertisement advertisement)throws Exception;

	public void delete(Advertisement advertisement)throws Exception;

	public void update(Advertisement advertisement, File upload, String uploadFileName,
			String uploadContentType)throws Exception;

	public List<Advertisement> queryAllAdvertisement();

	public String queryAdvertisementJson()throws Exception;

	public int deletebyVadids(String vadids)throws Exception;
}
