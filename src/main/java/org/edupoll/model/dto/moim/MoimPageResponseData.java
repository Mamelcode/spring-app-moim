package org.edupoll.model.dto.moim;

import java.util.List;

import org.edupoll.model.dto.etc.PageData;

public class MoimPageResponseData {
	
	List<MoimListResponseData> moims;
	
	List<PageData> pages; // 페이지 몇개까지 보이게 할건지?
	
	int viewPage; // 글 토탈 갯수
			
	int nextPage; // 다음페이지
	int prevPage; // 이전페이지
	
	boolean prev; // 다음페이지가 있는지?
	boolean next; // 이전페이지가 있는지?
	
	public MoimPageResponseData() {
		super();
	}

	public MoimPageResponseData(List<PageData> pages, int viewPage, int nextPage, int prevPage, 
			boolean prev, boolean next, List<MoimListResponseData> moims) {
		super();
		this.pages = pages;
		this.viewPage = viewPage;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.prev = prev;
		this.next = next;
		this.moims = moims;
	}
	
	public List<MoimListResponseData> getMoims() {
		return moims;
	}
	public void setMoims(List<MoimListResponseData> datas) {
		this.moims = datas;
	}
	public List<PageData> getPages() {
		return pages;
	}
	public void setPages(List<PageData> pages) {
		this.pages = pages;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getViewPage() {
		return viewPage;
	}
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
	}
}
