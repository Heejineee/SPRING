package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface BoardMapper {
	@Select("SELECT board_no, id, cate, title, content, regdate, hit, poster, num "
			 +"FROM (SELECT board_no, id, cate, title, content, regdate, hit, poster, rownum as num "
			 +"FROM (SELECT board_no, id, cate, title, content, regdate, hit, poster "
			 +"FROM board ORDER BY 1 DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM board")
	 public int boardTotalPage();
	 // 데이터 추가 
	@SelectKey(keyProperty="board_no",resultType=int.class,before=true,
		    statement="SELECT NVL(MAX(board_no)+1,1) as no FROM board")
	@Insert("INSERT INTO board(board_no, id, cate, title, content) "
			+"VALUES(#{board_no},#{id},#{cate},#{title},#{content})")
	public void boardInsert(BoardVO vo);
	// 상세보기 
	  @Update("UPDATE board SET "
			 +"hit=hit+1 "
			 +"WHERE board_no=#{board_no}")
	  public void boardHitIncrement(int board_no);
	  @Select("SELECT board_no, id, cate, title, content, regdate, hit, poster "
			 +"FROM board "
			 +"WHERE no=#{board_no}")
	  public BoardVO boardDeteilData(int board_no);
}
