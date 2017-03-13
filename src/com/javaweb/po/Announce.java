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
@Table(name = "th_announce")
@SequenceGenerator(name = "webeseq", sequenceName = "webeseq")
public class Announce  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webeseq")
	private int vanid;
	private String vtitlename;
	private String vimgpath;
	private String vtext;// 公告文本信息
	@ManyToOne(cascade = { CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "modifysuid", referencedColumnName = "vsuid")
	private SysUser vmodifier;// 公告修改人

	
	
	private Date lastmodifyTime;// 最后修改时间

	public Announce() {
		super();
	}

	public Announce(int vanid) {
		this.vanid = vanid;
	}

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
