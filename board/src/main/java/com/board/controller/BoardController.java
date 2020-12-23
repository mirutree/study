package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<BoardVO> list = null;
		list = service.list();		
		model.addAttribute("list", list);
	}
	
	//게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void getWrite() throws Exception {
		
	}
	// 게시물 작성
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String getWrite(BoardVO vo) throws Exception {
		service.write(vo);
		return "redirect:/board/list";
	}
	
	// 게시물 조회
	// 게시물 목록처럼 모델을 이용하면 되지만 게시물 번호를 받아야 함
	// 주소는 view?bno=[고유번호] 이기 때문에 이주소에서 bno의 값을 걸러냄
	// @RequestParam([문자열])을 이용하면 주소에 있는 특정한 값을 가져올 수 있음 주소에서 bno를 찾아 그 값을 int bno에 넣어줌
	@RequestMapping(value = "view",  method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {
		BoardVO vo = service.view(bno); //BoardVO를 이용하여 서비스에서 데이터를 받고 
		model.addAttribute("viewview", vo); //모델을 이용하여 뷰에 데이터를 넘겨줌. 넘겨주는 모델의 이름은 viewview
	}
	
	

}
