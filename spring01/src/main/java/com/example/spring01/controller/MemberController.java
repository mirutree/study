package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.spring01.model.dao.MemberDAO;
import com.example.spring01.model.dto.MemberDTO;

@Controller
public class MemberController {
	
	@Inject
	MemberDAO memberDao;
	
	@RequestMapping("member/list.do")
	public String list(Model model) {
		List<MemberDTO> list = memberDao.list();
		model.addAttribute("items", list);
		return "member/list";
	}
	
	//회원등록폼으로 이동
	@RequestMapping("member/write.do")
	public String write() {
		return "member/write";
	}
	
	@RequestMapping("member/insert.do")
	// 모델 어트리뷰트로 멤버디티오를 한꺼번에 받음
	public String insert(@ModelAttribute MemberDTO dto) {
		memberDao.insert(dto);
		return "redirect:/member/list.do";
	}
	
	// 회원 상세정보
	@RequestMapping("member/view.do")
	public String view(@RequestParam String userid, Model model) {
		// 회원정보를 모델에 저장
		model.addAttribute("dto", memberDao.detail(userid));
		// detail.jsp로 포워딩
		return "member/detail";
	}
	
//	//회원 정보 수정
//	@RequestMapping("member/update.do")
//	public String update(@ModelAttribute MemberDTO dto, Model model) {
//		//비밀번호 체크
//		boolean
//	}
	
	
}
