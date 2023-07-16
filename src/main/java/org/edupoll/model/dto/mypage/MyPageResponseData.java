package org.edupoll.model.dto.mypage;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.etc.PageData;

public class MyPageResponseData {
	
	// 참여목록
	List<MyAttendanceMoimData> attendances = new ArrayList<>();
	
	// 개설목록
	List<MyCreatorMoimData> creators = new ArrayList<>();
	
	// 댓글목록
	List<MyReplyData> replies = new ArrayList<>();
	
	List<PageData> pages; // 페이지 몇개까지 보이게 할건지?
	
	int viewPage; // 글 토탈 갯수
			
	int nextPage; // 다음페이지
	int prevPage; // 이전페이지
	
	boolean prev; // 다음페이지가 있는지?
	boolean next; // 이전페이지가 있는지?
	
	// 기본생성자
	public MyPageResponseData() {
		super();
	}
	
	public MyPageResponseData(List<MyAttendanceMoimData> attendances, List<MyCreatorMoimData> creators,
			List<MyReplyData> replies, List<PageData> pages, int viewPage, int nextPage, int prevPage, boolean prev,
			boolean next) {
		super();
		this.attendances = attendances;
		this.creators = creators;
		this.replies = replies;
		this.pages = pages;
		this.viewPage = viewPage;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.prev = prev;
		this.next = next;
	}

	public List<MyAttendanceMoimData> getAttendances() {
		return attendances;
	}
	public void setAttendances(List<MyAttendanceMoimData> attendances) {
		this.attendances = attendances;
	}
	public List<MyCreatorMoimData> getCreators() {
		return creators;
	}
	public void setCreators(List<MyCreatorMoimData> creators) {
		this.creators = creators;
	}
	public List<MyReplyData> getReplies() {
		return replies;
	}
	public void setReplies(List<MyReplyData> replies) {
		this.replies = replies;
	}
	public List<PageData> getPages() {
		return pages;
	}
	public void setPages(List<PageData> pages) {
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
