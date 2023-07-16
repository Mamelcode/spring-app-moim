package org.edupoll.model.dto.etc;

public class CateSeleteWapper {
	String cate;
	boolean isCate;
	
	
	
	public CateSeleteWapper() {
		super();
	}
	public CateSeleteWapper(String cate, boolean isCate) {
		super();
		this.cate = cate;
		this.isCate = isCate;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public boolean isCate() {
		return isCate;
	}
	public void setCate(boolean isCate) {
		this.isCate = isCate;
	}
}
