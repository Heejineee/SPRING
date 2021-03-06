package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.*;
@Controller
public class MusicController {
	@Autowired
	private MusicDAO dao;
	// GET(a 태그) / POST (form, ajax)
	@GetMapping("music/list.do")
	public String music_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=10;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		List<MusicVO> list=dao.musicListData(map);
		
		int totalpage=dao.musicTotalPage();
		// 전송
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		return "music/list";	// ViewResolver 가 읽어감 ==> prefix, suffix 붙여서
	}
	@RequestMapping("movie2/main.do")
	public String movie2_main()
	{
		return "movie2/main";
	}
}












