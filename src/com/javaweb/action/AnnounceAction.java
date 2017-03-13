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

import com.javaweb.po.Announce;
import com.javaweb.service.AnnounceService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller("announceAction")
@Scope("prototype")
public class AnnounceAction extends ActionSupport implements
		ModelDriven<Announce> {

	private static final long serialVersionUID = -5283614734166213285L;
	Announce announce = new Announce();
	private String vanids;
	public String getVanids() {
		return vanids;
	}

	public void setVanids(String vanids) {
		this.vanids = vanids;
	}

	@Resource
	private AnnounceService announceService;

	// 全部的公告放在值栈中
	private List<Announce> announces = new ArrayList<Announce>();

	// 上传文件的三个属性
	private File upload;// 上传文件
	private String uploadFileName;// 上传文件名
	private String uploadContentType;// 上传文件类型

	public String deletebyVanids() {
		int i = announceService.deletebyVanids(vanids);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p;
		try {
			p = response.getWriter();
			p.write(String.valueOf(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}

	/**
	 * 发布公告页面
	 * 
	 * @return
	 */
	public String publishUI() {

		return "publishUI";
	}

	/**
	 * 发布公告
	 * 
	 * @return
	 */
	public String publish() {

		announceService.publish(announce, upload, uploadFileName,
				uploadContentType);
		return NONE;
	}

	/**
	 * 修改公告
	 * 
	 * @return
	 */
	public String modify() {
		announceService.update(announce, upload, uploadFileName,
				uploadContentType);
		return NONE;
	}

	/**
	 * 跳转到修改公告页面
	 * 
	 * @return
	 */
	public String modifyUI() {
		announce = announceService.queryById(announce);
		return "modifyAnnounceUI";
	}

	// 查出所有公告的json
	public String queryAnnounceJson() {
	//	String announcejson = announceService.querypage(page, rows);
		String announceJson = announceService.queryAnnounceJson();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter p;
		try {
			p = response.getWriter();
			p.write(announceJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	/**
	 * 删除公告
	 * 
	 * @return
	 */
	public String delete() {

		announceService.delete(announce);

		return "deleteAnnounceSuccess";
	}

	public String queryAllAnnounce() {
		announces = announceService.queryAll();
		return "allAnnounce";
	}

	public Announce getModel() {
		return announce;
	}

	public Announce getAnnounce() {
		return announce;
	}

	public void setAnnounce(Announce announce) {
		this.announce = announce;
	}

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

	public List<Announce> getAnnounces() {
		return announces;
	}

	public void setAnnounces(List<Announce> announces) {
		this.announces = announces;
	}
}
