package com.javaweb.po;

import java.io.Serializable;
import java.util.Date;

public class AdvertisementVO {

	
	private int vadid;
	private String vadname;
	private String vpath;
	private String vhrefpath;
	private Date modifiedtime;

	private SysUser modifier;

	public int getVadid() {
		return vadid;
	}

	public void setVadid(int vadid) {
		this.vadid = vadid;
	}

	public String getVadname() {
		return vadname;
	}

	public void setVadname(String vadname) {
		this.vadname = vadname;
	}

	public String getVpath() {
		return vpath;
	}

	public void setVpath(String vpath) {
		this.vpath = vpath;
	}

	public String getVhrefpath() {
		return vhrefpath;
	}

	public void setVhrefpath(String vhrefpath) {
		this.vhrefpath = vhrefpath;
	}

	public Date getModifiedtime() {
		return modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		this.modifiedtime = modifiedtime;
	}

	public SysUser getModifier() {
		return modifier;
	}

	public void setModifier(SysUser modifier) {
		this.modifier = modifier;
	}

}
