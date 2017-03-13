package com.javaweb.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "th_sysuser")
@SequenceGenerator(name = "webeseq", sequenceName = "webeseq")
public class SysUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webeseq")
	private int vsuid;
	private String vsuname;
	private String vpassword;
	private String vinnwecode;
	private Date lastvisittime; // 最后一次访问时间

	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "modifysuid", referencedColumnName = "vsuid")
	@JSONField(serialize = false)
	private Set<Advertisement> advertisements = new HashSet<Advertisement>();

	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name = "modifysuid", referencedColumnName = "vsuid")
	@JSONField(serialize = false)
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

	public SysUser(String vsuname) {
		this.vsuname = vsuname;
	}

	public SysUser() {
		super();
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
