package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardDAO {
	
	// 글쓰기 (create)
	public void create(BoardVO vo) throws Exception; 
	
	// 글 전체 목록 보기 (listAll-select)
	public List<BoardVO> listAll() throws Exception;
	
	// 글 상세 페이지 
	public BoardVO detail(Integer bno) throws Exception;
	
	//글 번호에 해당하는 글정보 수정하기 동작
	public void update(BoardVO vo) throws Exception;

	// 삭제하기
	public void delete(int bno) throws Exception;

	// 특정 페이지에 있는 글정보를 확인 
	public List<BoardVO> listPage(int page) throws Exception;
	
	// 페이징 처리하는 동작(Criteria 객체 사용)
	public List<BoardVO> listPageCri(Criteria cri) throws Exception;
	
	// DB에서 테이블에 있는 모든 글의 개수 가지고 오기
	public int pageCount() throws Exception;
	
}
