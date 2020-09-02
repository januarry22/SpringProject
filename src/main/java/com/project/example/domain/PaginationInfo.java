package com.project.example.domain;

public class PaginationInfo {

	private PagingCriteria criteria;
	/** 전체 데이터 개수 */
	private int totalRecordCount;

	/** 전체 페이지 개수 */
	private int totalPageCount;

	/** 페이지 리스트의 첫 페이지 번호 */
	private int firstPage;

	/** 페이지 리스트의 마지막 페이지 번호 */
	private int lastPage;

	/** SQL의 조건절에 사용되는 첫 RNUM */
	private int firstRecordIndex;

	/** SQL의 조건절에 사용되는 마지막 RNUM */
	private int lastRecordIndex;

	/** 이전 페이지 존재 여부 */
	private boolean hasPreviousPage;

	/** 다음 페이지 존재 여부 */
	private boolean hasNextPage;

	
	public PagingCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(PagingCriteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
		if(totalRecordCount>0) {
			calculation();
		}
	}



	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public PaginationInfo(PagingCriteria criteria) {
		
		if(criteria.getCurrentPageNo()<1) {
			criteria.setCurrentPageNo(totalPageCount);
		}
		if(criteria.getRecordsPerpage()<1|| criteria.getRecordsPerpage()>100) {
			criteria.setRecordsPerpage(10);
		}
		if(criteria.getPageSize()<5||criteria.getPageSize()>20) {
			criteria.setPageSize(10);
		}
		this.criteria=criteria;
	}
	
	private void calculation() {
		// TODO Auto-generated method stub
		totalPageCount=((totalPageCount-1)/criteria.getRecordsPerpage())+1;
		if(criteria.getCurrentPageNo()>totalPageCount) {
			criteria.setCurrentPageNo(totalPageCount);
		}
		
		firstPage=((criteria.getCurrentPageNo()-1)/criteria.getPageSize())*criteria.getPageSize()+1;
		
		lastPage=firstPage+criteria.getPageSize()-1;
		if(lastPage>totalPageCount) {
			lastPage=totalPageCount;
		}
		
		firstRecordIndex=(criteria.getCurrentPageNo()-1)*criteria.getRecordsPerpage();
		
		hasPreviousPage=firstPage!=1;
		hasNextPage=(lastPage*criteria.getRecordsPerpage())<totalRecordCount;
	}


}
