package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class RecipeController {
	@Autowired
	private RecipeDAO dao;
	@RequestMapping("recipe/list.do")
	public String recipe_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<RecipeVO> list=dao.recipeListData(curpage);
		int count=dao.recipeCount();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("count", count);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "recipe/list";
	}
	@RequestMapping("recipe/detail.do")
	public String recipe_detail(int no, Model model)
	{
		RecipeDetailVO vo=dao.recipeDetailData(no);
		StringTokenizer st=new StringTokenizer(vo.getFoodmake(), "\n");
		while(st.hasMoreTokens())
		{
			vo.getmList().add(st.nextToken());
		}
		model.addAttribute("vo", vo);
		return "recipe/detail";
	}
	@RequestMapping("recipe/chef_list.do")
	public String recipe_chef_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<ChefVO> list=dao.chefListData(curpage);
		model.addAttribute("list", list);
		return "recipe/chef_list";
	}
}
