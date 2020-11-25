package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
    private BoardMapper mapper;
	// 목록 읽기
	public List<BoardVO> boardListData(Map map)
	{
		return mapper.boardListData(map);
	}
	// 총페이지 읽기
	public int boardTotalPage()
	{
		return mapper.boardTotalPage();
	}
	// 상세보기 
	public BoardVO boardDetailData(int no)
	{
		mapper.boardHitIncrement(no);
		return mapper.boardDeteilData(no);
	}
	// 추가 
	public void boardInsert(BoardVO vo)
	{
		mapper.boardInsert(vo);
	}
}
