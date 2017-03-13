package com.javaweb.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SysUserVO  {

	private int vsuid;
	private String vsuname;
	private String vpassword;
	private String vinnwecode;
	private Set<Advertisement> advertisements = new HashSet<Advertisement>();
	private Set<Announce> announces = new HashSet<Announce>();
	public Set<Announce> getAnnounces() {
		return announces;
	}

	public void setAnnounces(Set<Announce> announces) {
		this.announces = announces;
	}

	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public int getVpenelauth() {
		return vpenelauth;
	}

	private Date lastvisittime; // 最后一次访问时间
	private int vpenelauth;// 个人身份

	public void setVpenelauth(int vpenelauth) {
		this.vpenelauth = vpenelauth;
	}

	public int getVsuid() {
		return vsuid;
	}

	public void setVsuid(int vsuid) {
		this.vsuid = vsuid;
	}

	public String getVsuname() {
		return vsuname;
	}

	public void setVsuname(String vsuname) {
		this.vsuname = vsuname;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	public String getVinnwecode() {
		return vinnwecode;
	}

	public void setVinnwecode(String vinnwecode) {
		this.vinnwecode = vinnwecode;
	}

	public Date getLastvisittime() {
		return lastvisittime;
	}

	public void setLastvisittime(Date lastvisittime) {
		this.lastvisittime = lastvisittime;
	}

}
