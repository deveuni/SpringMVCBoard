package com.itwillbs.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.domain.PageMaker;
import com.itwillbs.service.BoardService;

@Controller
@RequestMapping("/board/*")
//@SessionAttributes() - "해당 컨트롤러에 정보를 저장" / 컨트롤러 안에서만 정보를 가지고 다님
// -> 정상처리 완료후 메서드를 사용해서 사용완료 표시 
public class BoardController {

	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
			
	// 서비스 객체 생성
	@Inject
	private BoardService service;
	
	// 글쓰기 (입력 GET)
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("C : /register -> /register.jsp 이동");
		logger.info("C : registerGET() 호출");
		logger.info("C : 정보 입력창으로 이동");
	}
	
	// 글쓰기(처리 POST)
	//@RequestMapping(value = "/register",method = {RequestMethod.POST, RequestMethod.GET})
	// -> method 속성은 배열로 지정 가능(한번에 여러가지 속성값을 사용가능)
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String registerPOST(BoardVO vo, /*Model model*/ RedirectAttributes rttr) throws Exception{
		logger.info("C : /register (get-submit) -> list 이동");
		logger.info("C : registerPOST() 호출!");
		logger.info("C : 정보처리 (글쓰기동작)");
		logger.info("C : 전달받은 정보(글정보 파라미터)" + vo);
		
		logger.info("C : 서비스 글쓰기 기능 호출");
		service.regist(vo);
		
		logger.info("C : 글쓰기 처리 완료");
		
		// 정상처리 일 때 -> 다음 페이지로 정보 전달
		//model.addAttribute("result", "SUCCESS");
		rttr.addFlashAttribute("result", "SUCCESS");
		
		// 페이지 이동
		// /board/success.jsp
		//return "/board/success"; (F5 중복 글쓰기)
		return "redirect:/board/listAll";
	}
	
	
	// 글 목록 보기 (listAll - GET)
	@RequestMapping(value = "/listAll",method = RequestMethod.GET)
	public void listAllGET(@ModelAttribute("result") String result,Model model) throws Exception{
		logger.info("C : /listAll -> listAll.jsp");
		logger.info("C : listAllGET() 호출");
		
		logger.info("C : 전달정보 -> "+result);
		
		// 성공 정보를 전달
		//model.addAttribute("msg",result);
		
		// 서비스 <-> DAO <-> mapper <-> DB
		List<BoardVO> boardList = service.listAll();
		
		logger.info("C : 글 목록");
		logger.info("C "+boardList);
		// 글 정보를 가지고 오기
		model.addAttribute("boardList", boardList);
		
		// 뷰 페이지로 이동
	}
	
	// /board/read?bno=${boardVO.bno}
	// 글 상세내용 보기
	@RequestMapping(value = "/read",method = RequestMethod.GET)
	public void readGET(@RequestParam("bno") int bno,Model model) throws Exception{
		// 글번호 받아오는 방법 
		// ModelAttribute("bno") => Model 객체 안의 정보들을 가져오는 동작
		// @RequestParam("bno") => request.getparameter() 의미로 사용 
		// => 타입 상관없이 처리 가능(문자열, 정수형, 날짜)
		// 큰 차이는 없고 모델객체로 큰 단위로 가져오느냐, 파라미터객체의 작은 단위로 가져오느냐 차이다.
		// model객체는 요청정보 중에서 파라미터 값이 없어도 되지만, request객체는 파라미터 정보가 없으면 문제가 생긴다.
		
		//@RequestParam Map<String,String> m => 키 value의 여러가지를 한번에 받아올 수 있음.
		
		// => 단순 타입(알수 있는 타입)은 어노테이션 생략 가능하지만, 어떤것인지 정확하게 모르므로 가능하면 앞에 어노테이션 명시하는 것이 좋음
		   
		
		logger.info("C : /read?bno=00 -> /read.jsp");
		logger.info("C : readGET() 호출");
		
		logger.info("C : 글 번호 -> " + bno);
		
		// 서비스 객체 (해당 글번호 사용해서 글 정보 가지고 오기)
		BoardVO vo = service.detail(bno);
		logger.info("C : 글정보 -> "+vo);
		
		model.addAttribute("vo", vo);
		
		// 페이지 이동
		
	}
	
	
	@RequestMapping(value = "/readPage",method = RequestMethod.GET)
	public void readPageGET(@ModelAttribute("cri") Criteria cri, @RequestParam("bno") int bno,Model model) throws Exception{
		
		logger.info("C : /read?bno=00 -> /read.jsp");
		logger.info("C : readGET() 호출");
		
		logger.info("C : 글 번호 -> " + bno);
		logger.info("C : cri -> " + cri);
		
		// 서비스 객체 (해당 글번호 사용해서 글 정보 가지고 오기)
		BoardVO vo = service.detail(bno);
		logger.info("C : 글정보 -> "+vo);
		
		model.addAttribute("vo", vo);
		
		// 페이지 이동
		
	}
		

	// 수정하기 
	// /board/modify?bno=458748
	@RequestMapping(value = "/modify",method = RequestMethod.GET)
	public void modifyGET(@RequestParam("bno") int bno,Model model) throws Exception{
		logger.info("C : /modify  -> /modify.jsp ");
		logger.info("C : modifyGET() 호출 ");
		
		// 글번호 (파라미터)
		logger.info("C : 글번호 -> " + bno);
		
		// DB이동해서 해당 정보가져오기 -> view 페이지 이동
		model.addAttribute(service.detail(bno));
		
		
	}
	
	// modifyPageGET
	@RequestMapping(value = "/modifyPage",method = RequestMethod.GET)
	public void modifyPageGET(Criteria cri, @RequestParam("bno") int bno,Model model) throws Exception{
		logger.info("C : /modifyPage  -> /modifyPage.jsp ");
		logger.info("C : modifyPageGET() 호출 ");
		
		// 글번호 (파라미터)
		logger.info("C : 글번호 -> " + bno);
		
		// DB이동해서 해당 정보가져오기 -> view 페이지 이동
		model.addAttribute(service.detail(bno));
		
		model.addAttribute("cri",cri);
		
		
	}
	
	
	@RequestMapping(value = "/modify",method = RequestMethod.POST)
	public String modifyPOST(BoardVO vo, RedirectAttributes rttr) throws Exception{
			logger.info("C : modifyPOST() 호출");
			
			// 수정할 데이터 저장 
			logger.info("C : " + vo);
			
			// 데이터 수정 (서비스 - DAO -> DB)
			service.update(vo);
			
			// 수정완료 ㄷ데이터 전달 
			rttr.addFlashAttribute("result","upok");
		
		return "redirect:/board/listAll";
	}
	
	// modifyPagePost
	@RequestMapping(value = "/modifyPage",method = RequestMethod.POST)
	public String modifyPagePOST(Criteria cri, BoardVO vo, RedirectAttributes rttr) throws Exception{
			logger.info("C : modifyPagePOST() 호출");
			
			// 수정할 데이터 저장 
			logger.info("C : " + vo);
			
			// 데이터 수정 (서비스 - DAO -> DB)
			service.update(vo);
			
			// 수정완료 ㄷ데이터 전달 
			rttr.addFlashAttribute("result","upok");
			rttr.addAttribute("page",cri.getPage());
			rttr.addAttribute("pageSize",cri.getPageSize());
			
		return "redirect:/board/listPage";
	}
	
	
	// 삭제하기
	@RequestMapping(value = "/delete",method = {RequestMethod.GET,RequestMethod.POST})
	public String deletePOST(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
		// 글 번호 저장
		logger.info("D : "+ bno);
		// 서비스 객체 사용 글 삭제 
		service.delete(bno);
		// '삭제정보' 저장해서 이동
		rttr.addFlashAttribute("result", "deok");
		
		// 리스트 이동 ("삭제완료" - 출력)
		
		
		return "redirect:/board/listAll";
	}
	
	// 삭제하기
		@RequestMapping(value = "/deletePage",method = {RequestMethod.GET,RequestMethod.POST})
		public String deletePagePOST(Criteria cri,@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception{
			// 글 번호 저장
			logger.info("D : "+ bno);
			// 서비스 객체 사용 글 삭제 
			service.delete(bno);
			// '삭제정보' 저장해서 이동
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("pageSize", cri.getPageSize());
			rttr.addFlashAttribute("result", "deok");
			
			// 리스트 이동 ("삭제완료" - 출력)
			
			
			return "redirect:/board/listPage";
		}
		
	
	
	// 글 목록 보기(페이징처리)
	@RequestMapping(value = "/listCri",method = RequestMethod.GET)
	public void listCriGET(Criteria cri, Model model) throws Exception{
		logger.info("C : listCriGET() 호출");
		logger.info("C : cri -> " + cri);
		
		
		model.addAttribute("boardList", service.listCri(cri));
		
	}
	
	
	// 글 목록 보기 (PageMaker 객체 사용)
		// http://localhost:8088/board/listPage
		@RequestMapping(value = "/listPage",method = RequestMethod.GET)
		public void listPageGET(Criteria cri,Model model) throws Exception{
			
			logger.info("C : cri -> "+cri);
			// 페이징 처리된 목록을 가져오기 
			model.addAttribute("boardList", service.listCri(cri));
			
			// 하단부 페이징처리 
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			// select count(*) from  tbl_board;
			// -> 사용 직접 계산후 입력
			//pm.setTotalCount(1408); 
			pm.setTotalCount(service.listTotalCount());
			
			
			// -> 뷰 페이지로 전달 
			model.addAttribute("pm", pm);
			
					
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
}
