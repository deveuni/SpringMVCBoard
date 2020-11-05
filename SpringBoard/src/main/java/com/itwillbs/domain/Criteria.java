package com.itwillbs.domain;

public class Criteria {
	// 페이지 정보, 페이지 크기 정보를 저장하는 객체 
	
	private int page;
	private int pageSize;
	
	public Criteria() {
		this.page = 1;
		this.pageSize = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
		    return;
		}
		
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize <= 0 || pageSize > 100) {
			this.pageSize = 10;
			return;
		}
		
		this.pageSize = pageSize;
	}
	

	// 1페이지 - 첫번째(0) ~ 10번째 글(9)
	//page = (page - 1) * 10;
	// -> 이것을 메소드로 만들어 준 것.
	// 페이징처리 시작하는 값
	public int getPageStart() {
		
		return (this.page -1)* this.pageSize;
	}
	// 멤버변수는 없지만, DB에서 처리해야하는 값을 생성하기 위한 구문
	// mapper에서 접근 가능ㅇ(getXXXX() 형태를 가지고 있기 때문)
	// => #{pageStart} 형태로 호툴 가능
	// -> set/get메서드를 만들어 놓으면 xml파일에서 부를 수 있음.
	
	
	

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", pageSize=" + pageSize + "]";
	}
	
	
	
	
	

}
