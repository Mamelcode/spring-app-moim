package org.edupoll.model.dto.search;

import java.util.List;

import org.edupoll.model.dto.etc.PageData;

public class SearchListResponseData {
	
	List<SearchMoimResponseData> moims;
	List<SearchUserResponseData> users;
	
	Integer moimCnt;
	Integer userCnt;
	
	List<PageData> pages; // 페이지 몇개까지 보이게 할건지?
	int viewPage; // 글 토탈 갯수
	int nextPage; // 다음페이지
	int prevPage; // 이전페이지
	boolean prev; // 다음페이지가 있는지?
	boolean next; // 이전페이지가 있는지?

	public SearchListResponseData() {
		super();
	}

	public SearchListResponseData(List<SearchMoimResponseData> moims, List<SearchUserResponseData> users,
			Integer moimCnt, Integer userCnt, List<PageData> pages, int viewPage, int nextPage, int prevPage,
			boolean prev, boolean next) {
		super();
		this.moims = moims;
		this.users = users;
		this.moimCnt = moimCnt;
		this.userCnt = userCnt;
		this.pages = pages;
		this.viewPage = viewPage;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.prev = prev;
		this.next = next;
	}

	public List<SearchMoimResponseData> getMoims() {
		return moims;
	}

	public void setMoims(List<SearchMoimResponseData> moims) {
		this.moims = moims;
	}

	public List<SearchUserResponseData> getUsers() {
		return users;
	}

	public void setUsers(List<SearchUserResponseData> users) {
		this.users = users;
	}

	public Integer getMoimCnt() {
		return moimCnt;
	}

	public void setMoimCnt(Integer moimCnt) {
		this.moimCnt = moimCnt;
	}

	public Integer getUserCnt() {
		return userCnt;
	}

	public void setUserCnt(Integer userCnt) {
		this.userCnt = userCnt;
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

	public List<PageData> getPages() {
		return pages;
	}

	public void setPages(List<PageData> pages) {
		this.pages = pages;
	}
}
