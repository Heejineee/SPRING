package com.sist.web;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		int totalpage=dao.boardTotalPage();
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "board/list";
	}
	@RequestMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) throws Exception
	{
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	@RequestMapping("board/detail.do")
	public String board_detail(int no,Model model)
	{
		// DB연동 
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
}
