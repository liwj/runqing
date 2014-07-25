package com.jynine.page;

import java.util.List;

import com.jynine.utils.Constant;
/**
 * 分页对象
 * <p>Title: PageBean.java</p>
 * <p>Description: </p>
 * <p>Company: CST</p>
 * @author caijy
 * @date 2014-7-10
 */
public class PageBean {
	private int pageSize = Constant.PAGE_SIZE;//每页条数
	private int totalPage;//总页数
	private List<?> list;//每页集合
	private int pageIndex = 0;//当前页
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	
}
