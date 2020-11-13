package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
public interface BoardMapper {
	// 목록 출력
	@Select("SELECT no, subject, name, regdate, hit, num "
				+"FROM (SELECT no, subject, name, regdate, hit, rownum as num "
				+"FROM (SELECT no, subject, name, regdate, hit "
				+"FROM spring_board4 ORDER BY 1 DESC)) "
				+"WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map);
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_board4")
	public int boardTotalPage();
	// 데이터 추가
	@SelectKey(keyProperty="no", resultType=int.class, before=true, 
							statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_board4")	// 자동증가번호 사용시 이렇게
	@Insert("INSERT INTO spring_board4(no, name, subject, content, pwd, filename, filesize, filecount) "
					+"VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	public void boardInsert(BoardVO vo);	
	// 상세보기
	@Update("UPDATE spring_board4 SET "
					+"hit=hit+1 "
					+"WHERE no=#{no}")
	public void boardHitIncrement(int no);
	@Select("SELECT no, name, subject, content, regdate, hit, filename, filesize, filecount  "
					+"FROM spring_board4 "
					+"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	// 수정
	@Select("SELECT pwd FROM spring_board4 "
					+"WHERE no=#{no}")
	public String boardGetPassword(int no);
	@Update("UPDATE spring_board4 SET "
					+"name=#{name}, subject=#{subject}, content=#{content} "
					+"WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	// 삭제
	@Delete("DELETE FROM spring_board4 "
					+"WHERE no=#{no}")
	public void boardDelete(int no);
	// 삭제 -1
	@Select("SELECT filename, filecount "
					+"FROM spring_board4 "
					+"WHERE no=#{no}")
	public BoardVO boardFileInfoData(int no);
}






