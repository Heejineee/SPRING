package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;


@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(String page,Model model)
	{
		return "main";
	}
	@RequestMapping("community/list.do")
	public String community_list()
	{
		return "community/list";
	}
	
}
