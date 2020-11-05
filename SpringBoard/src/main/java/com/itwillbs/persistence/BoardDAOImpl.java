package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	// DB 접근을 위한 객체 SqlSession
	@Inject
	private SqlSession session;
	
	// mapper의 위치
	private static final String namespace = "com.itwillbs.mapper.BoardMapper";
	
	
	
	// 글쓰기 (create)
	@Override
	public void create(BoardVO vo) throws Exception {
		System.out.println("DAO : create(vo) 호출");
		System.out.println("DAO : mapper 이동 SQL실행");
		
		session.insert(namespace+".create",vo);
		
		System.out.println("DAO : 글쓰기 완료!");
		System.out.println("DAO : 다음 동작 이동");
	}

	
	@Override
	public List<BoardVO> listAll() throws Exception {
		
		System.out.println("DAO : listAll() 호출");
		
		// Sqlsession객체 사용 mapper 호출
		List<BoardVO> boardList =
		session.selectList(namespace+".listAll");
		
		System.out.println("DAO : 글 정보 저장 완료");
		
		return boardList;
	}
	
	@Override
	public BoardVO detail(Integer bno) throws Exception {
		
		System.out.println("DAO : 글 상세 페이지");
		
		BoardVO vo = session.selectOne(namespace+".detail", bno);
		
		
		
		return vo;
	}
	
	
	@Override
	public void update(BoardVO vo) throws Exception {
		System.out.println("DAO : update(vo) 호출 ");
		System.out.println("DAO : mapper - SQL구문 호출");
		
		session.update(namespace+".update", vo);
		
		System.out.println("DAO : SQL 실행완료");
	
	}
	
	@Override
	public void delete(int bno) throws Exception {
		
		session.delete(namespace+".delete",bno);
		
	}
	
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		System.out.println("DAO : listPage(page) 호출 ");
		System.out.println("DAO : mapper-sql 구문 호출 ");
		
		// page정보가 0보다 작은 경우
		if(page <= 0) {
			page = 1;
		}
		
		// 1페이지 - 첫번째(0) ~ 10번째 글(9)
		page = (page - 1) * 10;
		
		List<BoardVO> boardList =
		session.selectList(namespace+".listPage",page);
		
		System.out.println("DAO : SQL구문 실행 완료!");
		
		return boardList;
	}
	
	
	@Override
	public List<BoardVO> listPageCri(Criteria cri) throws Exception {
		
		System.out.println("DAO : listPageCri(cri) 호출 ");
		System.out.println("DAO : mapper - sql 구문 호출");
		System.out.println("DAO : SQL구문 실행 완료");
		
		return session.selectList(namespace+".listCri",cri);
		
	}
	
	@Override
	public int pageCount() throws Exception {
		System.out.println("DAO : pageCount() 호출");
		System.out.println("DAO : DB에서 글 개수 계산");
		
		int result = session.selectOne(namespace+".pageCount");
		
		System.out.println("DAO : 글 개수 -> "+ result);
		
		return result;
		
	}
	

	
	
	
	
}
