package com.javaweb.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javaweb.dao.AnnounceDao;
import com.javaweb.po.Announce;
import com.javaweb.po.AnnounceVO;
import com.javaweb.po.SysUser;
import com.javaweb.utils.UUIDUtil;

@Service
@Transactional
public class AnnounceServiceImpl implements AnnounceService {

	@Resource
	private AnnounceDao announceDao;

	public void delete(Announce announce) {
		Announce a = announceDao.queryByID(announce);
		announceDao.delete(a);
	}

	public void update(Announce announce, File upload, String uploadFileName,
			String uploadContentType) {

		// 从数据库查出原有的公告记录
		Announce a = announceDao.queryByID(announce);
		// 如果更新时更换图片
		if (upload != null) {
			// 删除服务器图片
			String serverpath = ServletActionContext.getServletContext()
					.getRealPath("/");
			File serverImg = new File(serverpath + a.getVimgpath());

			String backuppath = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//";
			File backupImg = new File(backuppath + a.getVimgpath());
			// 删除原有的图片
			backupImg.delete();
			serverImg.delete();
			/****************** 上传新的图片 ***************************/
			// 截取上传图片的后缀
			String suffix = uploadFileName.substring(uploadFileName
					.lastIndexOf("."));
			// 产生新的图片名称，防止重名
			String imgname = UUIDUtil.getUUID();

			// 保存到服务器的硬盘备份
			String path = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//images";
			File backupimg1 = new File(path + "//" + imgname + suffix);

			// 获取服务器中Tomcat所在的路径
			String serverpath1 = ServletActionContext.getServletContext()
					.getRealPath("/images");
			File serverImg1 = new File(serverpath1 + "//" + imgname + suffix);
			try {
				FileUtils.copyFile(upload, serverImg1);
				FileUtils.copyFile(upload, backupimg1);

			} catch (IOException e) {
				e.printStackTrace();
			}
			// 更新图片路径
			a.setVimgpath("images/" + imgname + suffix);

		}
		// 获取当前登录的管理员
		SysUser s = (SysUser) ServletActionContext.getRequest().getSession()
				.getAttribute("sysUser");
		a.setVmodifier(s);
		a.setLastmodifyTime(new Date());
		a.setVtext(announce.getVtext());
		a.setGrade(announce.getGrade());
		a.setVtitlename(announce.getVtitlename());
		announceDao.update(a);
	}

	/**
	 * 查出所有公告
	 */
	public List<Announce> queryAll() {
		List<Announce> announces = announceDao.queryAll();
		return announces;
	}

	/**
	 * 发布公告,没有注释完
	 */
	public void publish(Announce announce, File upload, String uploadFileName,
			String uploadContentType) {
		SysUser modifier = (SysUser) ServletActionContext.getRequest()
				.getSession().getAttribute("sysUser");

		// 截取上传图片的后缀
		String suffix = uploadFileName.substring(uploadFileName
				.lastIndexOf("."));
		// 产生新的图片名称，防止重名
		String imgname = UUIDUtil.getUUID();

		String path = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//images";
		File backupimg = new File(path + "//" + imgname + suffix);

		// 获取服务器的路径
		String serverpath = ServletActionContext.getServletContext()
				.getRealPath("/images");
		File serverimg = new File(serverpath + "//" + imgname + suffix);
		try {
			FileUtils.copyFile(upload, serverimg);
			FileUtils.copyFile(upload, backupimg);

		} catch (IOException e) {
			e.printStackTrace();
		}
		announce.setVmodifier(modifier);
		announce.setLastmodifyTime(new Date());
		// 图片路径
		announce.setVimgpath("images/" + imgname + suffix);
		announceDao.add(announce);
	}

	/**
	 * 根据Id查出相应的Announce
	 */
	public Announce queryById(Announce announce) {
		Announce a = announceDao.queryByID(announce);
		return a;
	}

	public String queryAnnounceJson() {
		List<Announce> announces = announceDao.queryAll();
		List<AnnounceVO> announceVOs = new ArrayList<AnnounceVO>();
		for (Announce announce : announces) {
			AnnounceVO announceVO = new AnnounceVO();
			try {
				BeanUtils.copyProperties(announceVO, announce);
			} catch (Exception e) {
				e.printStackTrace();
			}
			announceVOs.add(announceVO);
		}
		String announceJson = JSON.toJSONString(announceVOs,
				SerializerFeature.DisableCircularReferenceDetect);
		return announceJson;
	}

	public int deletebyVanids(String vanids) {
		List<Integer> vanidslist = new ArrayList<Integer>();
		String[] vanidss = vanids.split(",");
		for (String vanid : vanidss) {
			vanidslist.add(Integer.parseInt(vanid));
			Announce a = announceDao.queryByID(new Announce(Integer
					.parseInt(vanid)));
			// 删除服务器图片
			String serverpath = ServletActionContext.getServletContext()
					.getRealPath("/");
			File serverImg = new File(serverpath + a.getVimgpath());

			String backuppath = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//";
			File backupImg = new File(backuppath + a.getVimgpath());
			// 删除原有的图片
			backupImg.delete();
			serverImg.delete();
		}
		int i = announceDao.deletebyVanids(vanidslist);
		return i;
	}

}
