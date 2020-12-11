package com.example.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	// http://localhost:8080/spring01
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("name","이원희");
		model.addAttribute("message", "홈페이지 방문을 환영합니다 :)");
		return "main";	//main.jsp
	}
	
	@RequestMapping("gugu.do")
	public String gugu() {
		return "test/gugu";
	}
	
	@RequestMapping("gugu_result.do")
	public String gugu(@RequestParam(defaultValue = "3") int dan, Model model) {
		String result ="";
		for (int i = 1; i <=9; i++) {
			result += dan + "x" + i + "=" + dan * i + "<br>";
		}
		model.addAttribute("result", result);
		return "test/gugu_result";
	}
}
