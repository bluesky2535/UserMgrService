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
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.javaweb.dao.AdvertisementDao;
import com.javaweb.po.Advertisement;
import com.javaweb.po.AdvertisementVO;
import com.javaweb.po.SysUser;
import com.javaweb.utils.UUIDUtil;

@Service
@Transactional
public class AdvertisementServiceImpl implements AdvertisementService {

	@Resource
	private AdvertisementDao advertisementDao;

	/**
	 * 此处有Bug，需要判断如果没有上传图片
	 */
	public void publish(Advertisement advertisement, File upload,
			String uploadFileName, String uploadContentType) {

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
		advertisement.setModifier(modifier);
		advertisement.setModifiedtime(new Date());
		// 图片路径
		advertisement.setVpath("images/" + imgname + suffix);

		advertisementDao.add(advertisement);
	}

	public Advertisement queryByID(Advertisement advertisement) {
		Advertisement ad = advertisementDao.queryByID(advertisement);
		return ad;
	}

	public void delete(Advertisement advertisement) {
		Advertisement a = advertisementDao.queryByID(advertisement);
		advertisementDao.delete(a);
	}

	/**
	 * 更新广告
	 */
	public void update(Advertisement advertisement, File upload,
			String uploadFileName, String uploadContentType) {

		// 从数据库查出原有的公告记录
		Advertisement a = advertisementDao.queryByID(advertisement);
		// 如果更新时更换图片
		if (upload != null) {
			// 删除服务器图片
			String serverpath = ServletActionContext.getServletContext()
					.getRealPath("/");
			File serverImg = new File(serverpath + a.getVpath());

			String backuppath = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//";
			File backupImg = new File(backuppath + a.getVpath());

			if (serverImg.exists()) {
				serverImg.delete();
			}
			if (backupImg.exists()) {
				backupImg.delete();
			}
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
			a.setVpath("images/" + imgname + suffix);

		}
		// 获取当前登录的管理员
		SysUser s = (SysUser) ServletActionContext.getRequest().getSession()
				.getAttribute("sysUser");
		a.setModifier(s);
		a.setModifiedtime(new Date());
		a.setVadname(advertisement.getVadname());
		a.setVhrefpath(advertisement.getVhrefpath());
		advertisementDao.update(a);
	}

	public List<Advertisement> queryAllAdvertisement() {
		List<Advertisement> advertisements = advertisementDao.queryall();
		return advertisements;
	}

	/**
	 * 查出五条广告的json
	 */
	public String queryAdvertisementJson() {
		List<Advertisement> advertisements = advertisementDao.queryall();
		List<AdvertisementVO> advertisementVOs = new ArrayList<AdvertisementVO>();
		for (Advertisement advertisement : advertisements) {
			AdvertisementVO advertisementVO = new AdvertisementVO();
			try {
				BeanUtils.copyProperties(advertisementVO, advertisement);
			} catch (Exception e) {
				e.printStackTrace();
			}
			advertisementVOs.add(advertisementVO);
		}
		// String s = advertisements.get(0).toString();

		// 此处解析不了SysUser的List<Advertisement>,所以需要将其设置为transient
		// System.out.println(JSONObject.toJSONString(advertisementVOs.get(0)));
		String advertisementJson = JSON.toJSONString(advertisementVOs,
				SerializerFeature.DisableCircularReferenceDetect);
		return advertisementJson;
	}

	/**
	 * 根据vadid删除记录的同时删除相对应记录的图片
	 */
	public int deletebyVadids(String vadids) {
		List<Integer> vadidslist = new ArrayList<Integer>();
		String[] vadidss = vadids.split(",");
		for (String vadid : vadidss) {
			vadidslist.add(Integer.parseInt(vadid));
			Advertisement a = advertisementDao.queryByID(new Advertisement(
					Integer.parseInt(vadid)));
			// 删除服务器图片
			String serverpath = ServletActionContext.getServletContext()
					.getRealPath("/");
			File serverImg = new File(serverpath + a.getVpath());
			if (serverImg.exists()) {
				serverImg.delete();
			}
			String backuppath = "E://myeclipseWorkSpace2//UserMgrService//WebRoot//";
			File backupImg = new File(backuppath + a.getVpath());
			if (backupImg.exists()) {
				backupImg.delete();
			}

		}
		int i = advertisementDao.deletebyVadids(vadidslist);
		return i;
	}
}
