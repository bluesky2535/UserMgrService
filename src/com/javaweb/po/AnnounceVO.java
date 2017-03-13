package com.javaweb.po;

import java.util.Date;

public class AnnounceVO  {


	private int vanid;
	private String vtitlename;
	private String vimgpath;
	private String vtext;// 公告文本信息

	private SysUser vmodifier;// 公告修改人

	private Date lastmodifyTime;// 最后修改时间

	public Date getLastmodifyTime() {
		return lastmodifyTime;
	}

	public void setLastmodifyTime(Date lastmodifyTime) {
		this.lastmodifyTime = lastmodifyTime;
	}

	private int grade;// 公告等级

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getVanid() {
		return vanid;
	}

	public void setVanid(int vanid) {
		this.vanid = vanid;
	}

	public String getVtitlename() {
		return vtitlename;
	}

	public void setVtitlename(String vtitlename) {
		this.vtitlename = vtitlename;
	}

	public String getVimgpath() {
		return vimgpath;
	}

	public void setVimgpath(String vimgpath) {
		this.vimgpath = vimgpath;
	}

	public String getVtext() {
		return vtext;
	}

	public void setVtext(String vtext) {
		this.vtext = vtext;
	}

	public SysUser getVmodifier() {
		return vmodifier;
	}

	public void setVmodifier(SysUser vmodifier) {
		this.vmodifier = vmodifier;
	}

}
