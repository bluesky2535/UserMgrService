package com.javaweb.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "th_advertisement")
@SequenceGenerator(name = "webeseq", sequenceName = "webeseq")
public class Advertisement  {
	

	@Override
	public String toString() {
		return "Advertisement [vadid=" + vadid + ", vadname=" + vadname
				+ ", vpath=" + vpath + ", vhrefpath=" + vhrefpath
				+ ", modifiedtime=" + modifiedtime + ", modifier=" + modifier
				+ "]";
	}

	public Advertisement() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webeseq")
	private int vadid;
	private String vadname;
	private String vpath;
	private String vhrefpath;
	private Date modifiedtime;
	@ManyToOne(cascade = { CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "modifysuid", referencedColumnName = "vsuid")
	private SysUser modifier;

	public Advertisement(int vadid) {
		this.vadid = vadid;
	}

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
