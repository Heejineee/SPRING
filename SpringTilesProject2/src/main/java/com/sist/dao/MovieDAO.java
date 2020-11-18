package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MovieMapper;
import com.sist.vo.MovieVO;

import java.util.*;
@Repository
public class MovieDAO {
	@Autowired
	private MovieMapper mapper;
	public List<MovieVO> movieListData(Map map)
	{
		return mapper.movieListData(map);
	}
	public int movieTotalPage()
	{
		return mapper.movieTotalPage();
	}
	public List<MovieVO> movieTOP5()
	{
		return mapper.movieTOP5Hit();
	}
}
