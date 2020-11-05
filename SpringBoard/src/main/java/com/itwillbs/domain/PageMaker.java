package com.itwillbs.domain;

public class PageMaker {
	
	
	/*------------------------------
	// 페이지 이동시 가져올 데이터
	 [Criteria 객체]
	 page - 현재 페이지 번호
	 pageSize - 한 페이지에 출력할 개수   
	-------------------------------
	// DB에서 계산해서 가져오기
	 totalCount - 총 글의 수
	--------------------------------
	// 직접 계산해서 가져올 데이터
	 startPage - 시작페이지 번호
	 endPage - 끝페이지 번호
	 prev - [이전] 
	 next - [다음]*/
    
	
	//*************************************************************************************************************************
	// 멤버 변수 
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	// page, pageSize
	private Criteria cri;
	
	// 화면에 보여지는 페이지의 번호 수(페이지 블럭)
	private int displayPageNum = 10;

	//*************************************************************************************************************************
	
	
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		// 총 글의 개수를 가지고 왔을때 필요한 정보를 계산
		calcData();
	}
	
	private void calcData() {
		System.out.println(" 페이징 처리 정보 계산 시작! ");
		
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndpage 
		  = (int) Math.ceil(totalCount/(double)cri.getPageSize());
		
		if(endPage > tempEndpage) {
			endPage = tempEndpage;
		}
		
		prev = (startPage == 1? false:true);
		
		next = (endPage * cri.getPageSize() >= totalCount? false:true);
		
		System.out.println(" 페이징 처리 정보 계산 끝! ");		
	}
	
	
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrex(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Criteria getCri() {
		return cri;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	
	
	
	
	
	
	
	

}
