package com.example.spring01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.dto.PointDto;
import com.example.spring01.model.dto.ProductDto;

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
	
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDto dto, Model model) {
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
//		double average=dto.getTotal()/3.0;
//		dto.setAverage(average);	// 평균 소수점 자리수가 길어짐
		String average = String.format("%.2f", dto.getTotal()/3.0); //%.2f 소수이하 두자리 스트링으로 만든 후 다시 더블로
		dto.setAverage(Double.parseDouble(average));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	
	@RequestMapping("move.do")
	public String move() {
//		return "redirect:/result.do";	//페이지로 가는 것이 아님 액션으로 가는거임
		 return "redirect:/result.do?name=kim&age=20";
	}
	
	@RequestMapping("result.do")
	public String result(Model model,
			@RequestParam(defaultValue="noname") String name, //보내는 값이 없는데 받는 변수가 있으면 에러가 나게 됨. 그런경우 디폴트 값을 줌
			@RequestParam(defaultValue="10") int age) {
		model.addAttribute("name", name); // 전달된 값을 모델에 저장 후
		model.addAttribute("age", age);
		return "test/result"; // result.jsp로 보냄
	}
	
	@RequestMapping("mav.do")
	public ModelAndView mav() {
		Map<String, Object> map = new HashMap<String, Object>(); //해시맵 생성
		map.put("product", new ProductDto("샤프", 1000)); //해시맵에 자료추가 앞이 변수명product, 뒤가 값(객체를담아도 되고 스트링 등 넣어도 됨)
		// ModelAndView(url, key, value)  (전달할 페이지 주소, 변수명, 전달할 값) 값은 하나만 보낼 수 있기 때문에 map이나 Dto 등 객체로 전달하면 됨
		return new ModelAndView("test/mav_result", "map", map);
	}
	
	
}
