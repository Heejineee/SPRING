package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.manager.*;
// Model => JSP(HTML(태그형) + Java)
// JSP(HTML(태그형)) => View
// JAVA => Model(VO, DAO, Manager)
// Controller => 스프링 안에 제작 되어 있음
//						=> 작동 하려면 ==> 매뉴얼 제작 => XML
// 이 클래스는 Model이다 알려주는 애 => Annotation(@붙은거)
@Controller
public class MovieController {
	@Autowired
	private MovieManager mgr;
	@RequestMapping("movie/main.do")
	public String movie_main(int no, Model model)
	{
		List<MovieVO> list=mgr.jsonAllData(no);
		model.addAttribute("list", list);
		return "movie/main";
	}
}
