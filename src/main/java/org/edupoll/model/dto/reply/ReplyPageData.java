package org.edupoll.model.dto.reply;

public class ReplyPageData {
	String page;
	boolean flag;
	
	public ReplyPageData() {
		super();
	}
	
	public ReplyPageData(String page, boolean flag) {
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
