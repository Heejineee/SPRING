package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/")
public class MainController {
	/*
		@RequestMapping("main/emp.do")
		public String main_emp()
		{
			return "main/emp";	// 입력 폼
		}
		@RequestMapping("main/emp_ok.do")
		public String main_emp_ok(EmpVO vo, Model model)
		{
			model.addAttribute("vo", vo);
			return "main/emp_ok";	// request를 전송 => forward
	}
	*/
	// @RequestMapping이 아래처럼 나눠서 처리되는 걸로 바뀜 ==> 이렇게 분산 처리하는 이유 ==> 처리 속도 높이려고
	@GetMapping("/emp.do")
	public String main_emp()
	{
		return "emp"; 	// 입력 폼
	}
	@PostMapping("emp_ok.do")
	public String main_emp_ok(EmpVO vo, Model model)
	{
		model.addAttribute("vo", vo);
		return "emp_ok";		// request를 전송 => forward
}
}
