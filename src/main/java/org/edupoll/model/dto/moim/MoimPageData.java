package org.edupoll.model.dto.moim;

public class MoimPageData {
	String page;
	boolean flag;
	
	
	
	public MoimPageData() {
		super();
	}
	
	public MoimPageData(String page, boolean flag) {
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
