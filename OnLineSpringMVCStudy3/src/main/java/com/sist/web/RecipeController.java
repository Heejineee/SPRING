package com.sist.web;
import java.util.*;
/*
 * 1. 데이터베이스 설정(BasicDataSource) 
 * 2. 설정된 데이터를 받아서
 * 		SqlSessionFactory : getConnection, disConnection()
 * 3. RecipeDAO
 * =========================================== 스프링에서 함
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.RecipeDAO;
import com.sist.dao.RecipeVO;
@Controller
public class RecipeController {
	@Autowired	
	private RecipeDAO dao;
	
	// 웹 => 사용자 요청(URL주소) ==> 서버주소(X) ==> URI ==> .do
	@RequestMapping("recipe/list.do")
	// 사용자 요청 처리
	public String recipe_list(String page, Model model)	// page String으로 잡는 이유 => 맨 첫페이지는 1로 줘야해서
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// 데이터 받기 => 스프링에서 메모리 할당 => 한개만 저장(재사용) = 싱글턴
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		// Map에서 채워서 DAO로 전송
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<RecipeVO> list=dao.recipeListData(map);
		for(RecipeVO vo:list)
		{
			String title=vo.getTitle();
			if(title.length()>22)
			{
				title=title.substring(0, 22);
				title+="...";
			}
			vo.setTitle(title);
		}
		// 총 페이지
		int totalpage=dao.recipeTotalPage();
		
		// 전송
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "recipe/list"; 	// forward => list.jsp => request를 전송
	}
	/*
	 * 	@RequestMapping()	=>  통합(GET, POST)
	 * 	@GetMapping => GET방식으로 전송
	 * 						  		 => <a>, sendRedirect(), location.href
	 * 	@PostMapping => POST 방식으로 전송
	 * 								 => ajax, form
	 */
	@GetMapping("recipe/chef.do")
	public String recipe_chef(String page, String chef, Model model)
	{
		// DB 연동
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("chef", chef);
		List<RecipeVO> list=dao.recipeChefData(map);
		for(RecipeVO vo:list)
		{
			String title=vo.getTitle();
			if(title.length()>22)
			{
				title=title.substring(0, 22);
				title+="...";
			}
			vo.setTitle(title);
		}
		// 총페이지 받기
		int totalpage=dao.recipeChefTotalPage(chef);
		
		// 전송
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("chef", chef);
		model.addAttribute("list", list);
		
		return "recipe/chef";
	}
		
}








