package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	// DAO 객체 (DI)
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void regist(BoardVO vo) throws Exception {
		System.out.println("S : registe(vo) 호출 - 글쓰기");
		System.out.println("S : DAO 객체 사용 글쓰기 동작 호출");
		
		bdao.create(vo);
		
		System.out.println("S : DAO - 글쓰기 처리 완료");
		System.out.println("S : 페이지 이동");
		
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception {
		System.out.println("S : listAll() 호출");
		
		// DAO객체 활용 정보 가져오기 
		List<BoardVO> boardList = bdao.listAll();
		
		System.out.println("S : 글 목록 리스트");
		
		
		return boardList;
	}

	
	@Override
	public BoardVO detail(Integer bno) throws Exception {
		System.out.println("S : detail(bno) 호출");
		
		BoardVO vo = bdao.detail(bno);
		
		System.out.println("S : 글 상세 페이지");
		
		
		return vo;
	}
	
	
	@Override
	public void update(BoardVO vo) throws Exception {
		System.out.println("S : update(vo) 호출 ");
		System.out.println("S : DAO-update(vo)호출 ");
		
		bdao.update(vo);
		
		System.out.println("S : DAO 실행완료");
		
	}	
	
	@Override
	public void delete(int bno) throws Exception {
		bdao.delete(bno);
	}
	
	
	@Override
	public List<BoardVO> listCri(Criteria cri) throws Exception {

		System.out.println("S : listCri(cri) 호출");
		System.out.println("S : dao 호출");
		List<BoardVO> boardList =  bdao.listPageCri(cri);
		
		System.out.println("S : dao 실행완료");
		
		return boardList;
	}
	
	@Override
	public int listTotalCount() throws Exception {

		System.out.println("S : listTotalCount() 호출");
		
		int result = bdao.pageCount();
		
		System.out.println("S : 글 개수 -> " + result);
		
		return result;
	}
	
	
	
}
