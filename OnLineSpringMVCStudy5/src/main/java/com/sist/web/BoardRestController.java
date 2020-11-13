package com.sist.web;

import java.io.File;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
// 필요한 JavaScript
@RestController
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		BoardVO pvo=dao.boardFileInfoData(vo.getNo());
		List<MultipartFile> list=vo.getFiles();
		/*
		 * 	수정
		 * 		1. 데이터 추가 => 업로드가 없는 상태
		 * 		2. 데이터 추가 => 업로드가 있는 상태
		 */
		if(list==null || list.size()<1)
		{
			if(vo.getFilecount()<1)
			{
				vo.setFilename("");
				vo.setFilesize("");
				vo.setFilecount(0);
			}
		}
		else
		{
			vo.setFilename(pvo.getFilename());
			vo.setFilesize(pvo.getFilesize());
			vo.setFilecount(pvo.getFilecount());
		}
		// 파일 업로드가 된 상태
		else
		{
			for(MultipartFile mf:list)
			{
				String filename=mf.getOriginalFilename();
				File files=new File("c:\\upload\\"+filename);
				try
				{
					mf.transferTo(files);	// 업로드
				}catch(Exception ex){}
				fn+=filename+",";
				fs=files.length()+",";
				
			}
			fn=fn.substring(0, fn.lastIndexOf(","));
			fs=fs.substring(0, fs.lastIndexOf(","));
			
			vo.setFilename(fn);
			vo.setFilesize(fs);
			vo.setFilecount(list.size());
			
			if(pvo.getFilecount()>0)
			{
				StringTokenizer st=new StringTokenizer(pvo.getFilename(), ",");
				while(st.hasMoreTokens())
				{
					File file=new File("c:\\upload\\"+st.nextToken());
					file.delete();
				}
			}
		}
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>"
						+"location.href=\"detail.do?no="+vo.getNo()+"\";"
						+"</script>";
		}
		else
		{
			result="<script>"
						+"alert(\"비밀번호가 틀립니다!!\");"
						+"history.back();"
						+"</script>";
		}
		return result;
	}
	
	@RequestMapping("board/delete_ok.do")
	public String board_delete_ok(int no, String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		BoardVO vo=dao.boardFileInfoData(vo.getNo());
		if(bCheck==true)
		{
			// 파일을 삭제하는 부분
			try
			{
				if(vo.getFilecount()>0)
				{
					// File dir=new File("c:\\upload");
					StringTokenizer st=new StringTokenizer(vo.getFilename(), ",");
					while(st.hasMoreTokens())
					{
						File file=new File("c:\\upload\\"+st.nextToken());
						file.delete();
					}
				}
			}catch(Exception ex){}
			result="<script>"
						+"location.href=\"list.do\";"
						+"</script>";
		}
		else
		{
			result="<script>"
						+"alert(\"비밀번호가 틀립니다!!\");"
						+"history.back();"
						+"</script>";
		}
		return result;
	}
}
