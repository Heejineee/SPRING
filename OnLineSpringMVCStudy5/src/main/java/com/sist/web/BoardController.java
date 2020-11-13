package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@Controller
public class BoardController {
	// 1. 스프링으로부터 필요한 클래스 객체를 받아둔다
	// 스프링에서 생성된 객체 주소를 받을 경우에 지역변수는 사용할 수 없다
	@Autowired
	private BoardDAO dao;
	@RequestMapping("board/list.do")
	public String board_list(String page, Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// 현재 페이지 데이터 값을 읽어 온다
		Map map=new HashMap();
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		// 총페이지
		int totalpage=dao.boardTotalPage();
		// JSP로 데이터 전송 => 전송만 담당 => Model
		// Spring => request를 사용하지 않는다
		/*
		 * 	request
		 * 		1. 사용자가 보내준 데이터를 받을 수 있다 => getParameter()
		 * 			==> 스프링에서 메소드의 매개변수를 이용해서 데이터값을 받는다
		 * 		2. 결과값을 모아서 전송해준 기능
		 * 			==> Model 인터페이스를 이용해서 데이터 전송
		 * 		3. request 안에는 사용자의 정보(IP, PORT) 존재 ==> 보안 목적으로 request 사용 안하는 쪽으로..
		 * 			==================================================================
		 * 			request에 첨부되어 있는 값을 DispatcherServlet이 처리
		 * 			** 필요한 모든 데이터나 객체는 매개변수로 받는다 ==> 매개변수는 순서 없음
		 * 				ex) 일반 MVC에서 HttpSession 생성
		 * 							public String login(HttpServletRequest request)
		 * 							{
		 * 								HttpSession session=request.getSession();
		 * 							}
		 * 					==> Spring
		 * 							public String login(HttpSession session) {}
		 */
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
	/*
	 * 	스프링 => 데이터를 받는 경우
	 * 		일반 데이터(String, int...)
	 * 		VO 단위로 데이터를 받는다 => <input type=text name=subject>
	 * 																										  ======= VO에 변수명이 동일
	 * 		List로 데이터를 받을 수 있다 => <input type=text name=name[0]>
	 * 
	 * 		같은 값 여러개 ==> String[]
	 * 		<input type=checkbox name=cb>
	 * 		<input type=checkbox name=cb>
	 * 		<input type=checkbox name=cb>
	 */
	public String board_insert_ok(BoardVO vo) throws Exception	// transferTo가 예외처리 해줘야 해서 throws Exception 붙임
	{
		List<MultipartFile> list=vo.getFiles();
		if(list==null || list.size()<1)
		{
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}
		else
		{
			String fn="";
			String fs="";
			for(MultipartFile mf:list)
			{
				// System.out.println(mf.getOriginalFilename());
				String filename=mf.getOriginalFilename();
				File file=new File("c:\\upload\\"+filename);
				mf.transferTo(file);	// 업로드하는 소스
				fn+=filename+",";
				fs+=file.length()+",";
			}
			fn=fn.substring(0, fn.lastIndexOf(","));	// 파일이 몇개일 지 모르니까 ,로 일단 묶는거!
			fs=fs.substring(0, fn.lastIndexOf(","));
			vo.setFilename(fn);
			vo.setFilesize(fs);
			vo.setFilecount(list.size());
		}
		dao.boardInsert(vo);
		return "redirect:list.do"; 
	}
	@RequestMapping("board/detail.do")
	public String board_detail(int no, Model model)
	{
		// DB 연동
		BoardVO vo=dao.boardDetailData(no);
		List<String> fList=new ArrayList<String>();
		List<Integer> sList=new ArrayList<Integer>();
		if(vo.getFilecount()>0)
		{
			StringTokenizer st=new StringTokenizer(vo.getFilename(), ",");
			while(st.hasMoreTokens())
			{
				fList.add(st.nextToken());
			}
			
			StringTokenizer st1=new StringTokenizer(vo.getFilesize(), ",");
			while(st1.hasMoreTokens())
			{
				sList.add(Integer.parseInt(st1.nextToken()));
			}
		}
		model.addAttribute("fList", fList);
		model.addAttribute("sList", sList);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	@RequestMapping("board/update.do")
	public String board_update(int no, Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
	@RequestMapping("board/delete.do")
	public String board_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
	/*
	 * 	1. 사용자 요청(브라우저) ==> .do
	 * 		.do(요청)
	 * 			1) <a>
	 * 			2) <form>
	 * 			3) ajax
	 * 			4) location.href=""
	 * 	2. DispatcherServlet ==> 스프링에서 지원
	 * 		==============
	 * 			1) 해당 RequestMapping()을 찾는다 => HandlerMapping
	 * 			2) 찾은 클래스에서 요청 처리 => 프로그래머 작성(@Controller, @RestController)
	 * 			3) 결과값을 Model(인터페이스)
	 * 			4) ViewResolver ==> JSP를 찾아서(Model => request로 변환에 전송)
	 * 			5) 전송받은 request를 출력
	 */
	@RequestMapping("board/download.do")
	public void board_download(String fn, HttpServletResponse response)	// 화면 이동 안하고 다운로드만 하니까 String 주지 말고 void!
	{
		try
		{
			// 헤더 ==> 데이터 전송 전에 보내는 내용 : 다운로드 창을 보여준다(파일명, 파일크기)
			// 헤더 => response
			// request : 사용자가 요청값 전송 => 사용자 정보(IP)
			// response : 응답(Cookie, Header, HTML)
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn, "UTF-8"));
			File file=new File("c:\\upload\\"+fn);
			response.setContentLength((int)file.length());
			// 파일크기 => long
			
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			
			int i=0;
			byte[] buffer=new byte[1024];
			while((i=bis.read(buffer, 0, 1024))!=-1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		}catch(Exception ex){}
	}
}











