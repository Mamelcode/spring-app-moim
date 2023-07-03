package org.edupoll.model.dto.response;

import java.util.List;

public class MoimPageResponseData {
	
	List<String> pages;
	
	int nextPage;
	int prevPage;
	
	boolean prev;
	boolean next;
	
	public MoimPageResponseData() {
	}
	
	public MoimPageResponseData(List<String> pages, int nextPage, int prevPage, boolean prev, boolean next) {
		this.pages = pages;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.prev = prev;
		this.next = next;
	}
	
	public List<String> getPages() {
		return pages;
	}
	public void setPages(List<String> pages) {
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
}
