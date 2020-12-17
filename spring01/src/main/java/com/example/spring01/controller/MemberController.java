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
	
	//회원 정보 수정
	@RequestMapping("member/update.do")
	// detail.jsp의 폼에서 작성한것이 컨트롤러에 전달되서 모델어트리뷰트에 쌓임
	public String update(@ModelAttribute MemberDTO dto, Model model) {
		//비밀번호 체크
		// memberDao.check_passwd에 id와 pw전달해서 result값 받음
		boolean result = memberDao.check_passwd(dto.getUserid(), dto.getPasswd()); 
		if (result) { // result가 true면 (아이디, 비밀번호가 맞으면)
			memberDao.update(dto);	//update 처리를 해라
			return "redirect:/member/list.do"; //다시 list.jsp로 감
		} else {	 //r esult가 false면 (아이디, 비밀번호가 틀렸다면)
			// 가입일자가 지워지지 않도록 처리
			MemberDTO dto2 = memberDao.detail(dto.getUserid()); // 다시 정보 꺼냄 
			dto.setJoin_date(dto2.getJoin_date());	// 날짜를 다시 기본값으로 세팅
			model.addAttribute("dto", dto);
			model.addAttribute("message", "비밀번호가 일치하지 않습니다.");
			return "member/detail";			
		}
	}
	
	//회원 삭제
	@RequestMapping("member/delete.do")
	public String delete(@RequestParam String userid, @RequestParam String passwd, Model model) {
		// 비밀번호 체크
		boolean result = memberDao.check_passwd(userid, passwd);
		if (result) { // result가 true면 (아이디, 비밀번호가 맞으면)
			// 삭제처리
			memberDao.delete(userid);
			return "redirect:/member/list.do";
		} else {
			model.addAttribute("message", "비밀번호가 일치하지 않습니다");
			model.addAttribute("dto", memberDao.detail(userid));
			return "member/detail"; //detail. jsp로 포워드
		}
		
		
	}
	
	
}
