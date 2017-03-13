package com.javaweb.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.javaweb.po.Advertisement;
import com.javaweb.service.AdvertisementService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("advertisementAction")
@Scope("prototype")
public class AdvertisementAction extends ActionSupport implements
		ModelDriven<Advertisement> {

	private static final long serialVersionUID = -3914053452942585120L;
	Advertisement advertisement = new Advertisement();

	public Advertisement getAdvertisement() {
		return advertisement;
	}

	// 接受广告的id，进行删除
	private String vadids;

	public String getVadids() {
		return vadids;
	}

	public void setVadids(String vadids) {
		this.vadids = vadids;
	}

	public void setAdvertisement(Advertisement advertisement) {
		this.advertisement = advertisement;
	}

	List<Advertisement> advertisements = new ArrayList<Advertisement>();

	@Resource
	private AdvertisementService advertisementService;

	// 上传文件的三个属性
	private File upload;// 上传文件
	private String uploadFileName;// 上传文件名
	private String uploadContentType;// 上传文件类型

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public Advertisement getModel() {
		return advertisement;
	}

	/**
	 * 跳转到发布广告页面
	 * 
	 * @return
	 */
	public String publishUI() {

		return "publishUI";
	}

	/**
	 * 发布广告操作
	 * 
	 * @return
	 */
	public String publish() {
		try {
			advertisementService.publish(advertisement, upload, uploadFileName,
					uploadContentType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	public String delete() {
		try {
			advertisementService.delete(advertisement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deleteSuccess";
	}

	/**
	 * 跳转到更改广告页面
	 * 
	 * @return
	 */
	public String modifyUI() {
		try {
			advertisement = advertisementService.queryByID(advertisement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "modifyUI";
	}

	/**
	 * 更改操作
	 * 
	 * @return
	 */
	public String modify() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			advertisementService.update(advertisement, upload, uploadFileName,
					uploadContentType);
		} catch (Exception e) {
			e.printStackTrace();
			p.write("fail");
			return NONE;
		}
		return "modifySuccess";
	}

	/**
	 * 查出所有的广告
	 * 
	 * @return
	 */
	public String allAdvertisement() {
		advertisements = advertisementService.queryAllAdvertisement();
		return "allAdvertisement";
	}

	/**
	 * 广告的Json
	 * 
	 * @return
	 */
	public String queryAdvertisementJson() {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			String advertisementJson = advertisementService
					.queryAdvertisementJson();

			p.write(advertisementJson);
		} catch (Exception e) {
			e.printStackTrace();
			p.write("fail");
			return NONE;
		}
		return NONE;
	}

	public String deletebyVadids() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;
		try {
			p = response.getWriter();
			int i = advertisementService.deletebyVadids(vadids);
			p.write(String.valueOf(i));
		} catch (Exception e) {
			e.printStackTrace();
			p.write("fail");
			return NONE;
		}
		return NONE;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	/**
	 * APP轮播的广告图片
	 * 
	 * @return
	 */
	public String appAdvertisement() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		PrintWriter p = null;

		try {
			p = response.getWriter();
			String advertisementJson = advertisementService
					.queryAdvertisementJson();
			p.write(advertisementJson);
		} catch (Exception e) {
			e.printStackTrace();
			p.write("fail");
			return NONE;
		}
		return NONE;
	}
}
