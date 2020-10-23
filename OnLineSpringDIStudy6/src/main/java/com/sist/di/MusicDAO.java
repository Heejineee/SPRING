package com.sist.di;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
/*
 * 	1. XML 이용
 * 	2. Annotation
 * 	3. XML + Annotation
 * 	4. 순수 자바
 */
public class MusicDAO extends SqlSessionDaoSupport{
	public List<MusicVO> musicAllData()
	{
		
		/*
		 * SqlSession session=ssf.openSession();
		 * list=session.selectList("");
		 * session.close();
		 * return list;
		 * 
		 * 기존에 하던 이 네줄이 return getSqlSession().selectList("musicAllData"); 한줄로 처리됨
		 *  SqlSession session=ssf.openSession();, session.close(); ==> getSqlSession()
		 */
		return getSqlSession().selectList("musicAllData");
		
	}
}
