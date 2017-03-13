package com.javaweb.service;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javaweb.po.Announce;

@Service
@Transactional
public interface AnnounceService {

	public void delete(Announce announce);

	public void update(Announce announce, File upload, String uploadFileName, String uploadContentType);

	public List<Announce> queryAll();

	public void publish(Announce announce, File upload, String uploadFileName,
			String uploadContentType);

	public Announce queryById(Announce announce);

	public String queryAnnounceJson();

	public int deletebyVanids(String vanids);
}
