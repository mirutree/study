package com.example.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
