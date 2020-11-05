package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	//글쓰기 
	public void regist(BoardVO vo) throws Exception;
	
	// 글 목록 전체 가져오기
	public List<BoardVO> listAll() throws Exception;
		
	// 글 상세 페이지 
	// 캐스팅이 되고, 파라미터로 전달되는 것은 Integer로 쓰는 것이 좋다.
	public BoardVO detail(Integer bno) throws Exception;
	
	// 글 번호에 해당하는 글 정보 수정
	public void update(BoardVO vo) throws Exception;
	
	// 글 번호에 해당하는 글 정보 삭제
	public void delete(int bno) throws Exception;
	
	// 글 목록(페이징 처리)
	public List<BoardVO> listCri(Criteria cri) throws Exception;
	
	// 전체 글 개수 가져오기 
	public int listTotalCount() throws Exception;
		
	

}
