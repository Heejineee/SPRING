package com.sist.di;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class MusicModel {
	@Autowired
	private MusicDAO dao;
	@RequestMapping("music/music.do")
	public String music_music(HttpServletRequest request)
	{
		List<MusicVO> list=dao.musicAllData();
		request.setAttribute("list", list);
		return "music/music";
	}
}
