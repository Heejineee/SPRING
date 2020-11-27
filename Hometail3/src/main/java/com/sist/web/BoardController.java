package com.sist.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	/*
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   List<BoardVO> list=dao.freeBoardListData(curpage);
		   int totalpage=dao.boardTotalPage();
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);	   
		   model.addAttribute("list", list);
		   return "board/list";
	}
	*/
	@RequestMapping("board/list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   List<BoardVO> list=dao.aReviewBoardListData(curpage);
		   List<BoardVO> fList=dao.freeBoardListData(curpage);
		   int totalpage=dao.boardTotalPage();
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);	   
		   model.addAttribute("list", list);
		   model.addAttribute("fList", fList);
		   return "board/list";
	}
	@RequestMapping("board/board_list.do")
	public String board_board_list(String page,Model model,String no)
	{
		if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   
		   List<BoardVO> list=dao.aReviewBoardListData(curpage);
		   List<BoardVO> fList=dao.freeBoardListData(curpage);
		   int totalpage=dao.boardTotalPage();
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);	   
		   model.addAttribute("list", list);
		   model.addAttribute("fList", fList);
		   model.addAttribute("no", no);
		   return "board_list";
	}
	@RequestMapping("board/insert.do")
	public String board_insert()
	{
		return "board/insert";
	}   
	@RequestMapping("board/insert_ok.do")
	   public String board_insert_ok(BoardVO vo)
	   {
		   dao.freeBoardInsert(vo);
		   return "redirect:../board/list.do";
	   } 
	@RequestMapping("board/detail.do")
	   public String board_detailData(int board_no, Model model)
	   {
		  // int curpage=Integer.parseInt(page);
		   BoardVO vo=dao.aReviewBoardDetailData(board_no);
		   //List<ReplyVO> list=dao.replyListData(3, no, curpage);
		   model.addAttribute("vo", vo);
		   //model.addAttribute("list", list);
		   return "board/detail";
		   
	   }
}
