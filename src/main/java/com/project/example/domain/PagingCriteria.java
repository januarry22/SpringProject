package com.project.example.domain;

public class PagingCriteria {
	
	private int currentPageNo;	// 현재 페이지 번호
	private int recordsPerPage;	// 페이지 마다 출력할 데이터의 개수
	private int pageSize; 	//화면 하단에 출력할 페이지의 크기
	private String searchkeyword;	// 검색
	private String searchType;		// 검색 키워드
	
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	public int getRecordsPerpage() {
		return recordsPerPage;
	}
	public void setRecordsPerpage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSearchkeyword() {
		return searchkeyword;
	}
	public void setSearchkeyword(String searchkeyword) {
		this.searchkeyword = searchkeyword;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public PagingCriteria() {
		
		this.currentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}
	
	public int getStartPage() {
		return (currentPageNo-1)*recordsPerPage;
	}
	

}
