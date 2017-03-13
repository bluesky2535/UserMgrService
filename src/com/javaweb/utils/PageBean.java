package com.javaweb.utils;

import java.util.List;

/**
 * 分页类的封装
 */
public class PageBean<T> {
	private int pagenum;	// 当前页数
	private int records; // 总记录数
	private int pagesize=2;	// 每页显示的记录数
	private int sumpage; // 总页数
	private List<T> list; // 每页显示数据的集合.
	
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPagenum() {
		return pagenum;
	}
	@Override
	public String toString() {
		return "PageBean [pagenum=" + pagenum + ", records=" + records
				+ ", pagesize=" + pagesize + ", sumpage=" + sumpage + ", list="
				+ list + "]";
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	
	//需要总记录数和每页的记录数返回总页数
	public int getSumpage() {
		return (records+pagesize-1)/pagesize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
		System.out.println(list);
	}

	
}
