package com.dto;

import java.util.List;

public class PageDTO {

	private List<GoodsDTO> list;
	private int curPage;
	private int perPage = 4;
	private int totalCount;
	
	public PageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<GoodsDTO> getList() {
		return list;
	}
	public void setList(List<GoodsDTO> list) {
		this.list = list;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@Override
	public String toString() {
		return "PageDTO [list=" + list + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount=" + totalCount
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
