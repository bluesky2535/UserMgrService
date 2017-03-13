package com.javaweb.po;

import java.io.Serializable;
import java.util.Date;


public class AppUserVO {
	
	private int vauid;
	private String vinnercode;
	private String vname;
	private String vtel;
	private int dpoint;
	private String vaddress1;
	private String vaddress2;
	private String vaddress3;
	private String vaddress4;
	private String vaddress5;
	private String vaddress6;
	private String vcard;
	private String vpassword;


	private Date lastvisittime;

	public int getVauid() {
		return vauid;
	}

	public void setVauid(int vauid) {
		this.vauid = vauid;
	}

	public String getVinnercode() {
		return vinnercode;
	}

	public void setVinnercode(String vinnercode) {
		this.vinnercode = vinnercode;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVtel() {
		return vtel;
	}

	public void setVtel(String vtel) {
		this.vtel = vtel;
	}

	public int getDpoint() {
		return dpoint;
	}

	public void setDpoint(int dpoint) {
		this.dpoint = dpoint;
	}

	public String getVaddress1() {
		return vaddress1;
	}

	public void setVaddress1(String vaddress1) {
		this.vaddress1 = vaddress1;
	}

	public String getVaddress2() {
		return vaddress2;
	}

	public void setVaddress2(String vaddress2) {
		this.vaddress2 = vaddress2;
	}

	public String getVaddress3() {
		return vaddress3;
	}

	public void setVaddress3(String vaddress3) {
		this.vaddress3 = vaddress3;
	}

	public String getVaddress4() {
		return vaddress4;
	}

	public void setVaddress4(String vaddress4) {
		this.vaddress4 = vaddress4;
	}

	public String getVaddress5() {
		return vaddress5;
	}

	public void setVaddress5(String vaddress5) {
		this.vaddress5 = vaddress5;
	}

	public String getVaddress6() {
		return vaddress6;
	}

	public void setVaddress6(String vaddress6) {
		this.vaddress6 = vaddress6;
	}

	public String getVcard() {
		return vcard;
	}

	public void setVcard(String vcard) {
		this.vcard = vcard;
	}

	public String getVpassword() {
		return vpassword;
	}

	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}

	public Date getLastvisittime() {
		return lastvisittime;
	}

	public void setLastvisittime(Date lastvisittime) {
		this.lastvisittime = lastvisittime;
	}

}
