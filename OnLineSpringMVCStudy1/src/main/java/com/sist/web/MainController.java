package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// MVC => Model 클래스 설정 : 요청처리 => 결과값 전송(B)
/*
 * 	Model(재사용 목적)
 * 		- ~VO
 * 		- ~DAO
 * 		- ~Manager
 * 		- ~Controller
 * 	View(재사용 목적)
 * 		- CSS
 * 		- JavaScript
 * 		- JSP
 * 		- HTML
 *	 ---------------------------- Model + View = 서블릿(DispatcherServlet)
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	// ID, Password 받기
	// 1. 입력하는 JSP 
	@RequestMapping("main/output.do")
	// 매개변수는 DispatcherServlet이 설정해준다(순서도 상관 없음)
	public String main_output(HttpServletRequest request)
	{
		// 스프링 2.5 이하 => request
		// 스프링 2.5 이상 => request 사용 X를 권장 ==> 보안 때문에(request 안에는 접속자의 IP 확인이 가능해서)
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		return "main/output";
		/*
		 * 	return "" => forward
		 * 		- return "폴더명/JSP명" ==> .jsp를 생략한다 ex) return "main/main"
		 * 	return "" => sendRedirect
		 * 		- "redirect:main.do"
		 */
	}
	@RequestMapping("main/input.do")
	public String main_input()
	{
		return "main/input";
	}
	
	
	@RequestMapping("main/output2.do")
	public String main_output2(String id, String pwd, Model model)
	{
		// Model => 인터페이스(해당 JSP로 데이터 전송)
		// 전송
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		// Spring => 요청값 받는 경우 매개변수로 받는다 / 전송 시에는 Model을 이용해 전송
		return "main/output2";
	}
}








