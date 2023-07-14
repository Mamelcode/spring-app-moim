package org.edupoll.model.dto.reply;

import java.util.List;

public class ReplyPageResponseData {

	List<ReplyResponseData> replies;
	
	List<ReplyPageData> pages;
	
	int viewPage; // 글 토탈 갯수
	
	int nextPage; // 다음페이지
	int prevPage; // 이전페이지
	
	boolean prev; // 다음페이지가 있는지?
	boolean next; // 이전페이지가 있는지?
	
	public ReplyPageResponseData() {
		super();
	}
	
	public ReplyPageResponseData(List<ReplyResponseData> replies, List<ReplyPageData> pages, int viewPage, int nextPage,
			int prevPage, boolean prev, boolean next) {
		super();
		this.replies = replies;
		this.pages = pages;
		this.viewPage = viewPage;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.prev = prev;
		this.next = next;
	}

	public List<ReplyResponseData> getReplies() {
		return replies;
	}
	public void setReplies(List<ReplyResponseData> replies) {
		this.replies = replies;
	}
	public List<ReplyPageData> getPages() {
		return pages;
	}
	public void setPages(List<ReplyPageData> pages) {
		this.pages = pages;
	}
	public int getViewPage() {
		return viewPage;
	}
	public void setViewPage(int viewPage) {
		this.viewPage = viewPage;
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
