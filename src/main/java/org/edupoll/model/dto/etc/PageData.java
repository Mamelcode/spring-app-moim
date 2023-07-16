package org.edupoll.model.dto.etc;

public class PageData {
	String page;
	boolean flag;
	
	
	
	public PageData() {
		super();
	}
	
	public PageData(String page, boolean flag) {
		super();
		this.page = page;
		this.flag = flag;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
