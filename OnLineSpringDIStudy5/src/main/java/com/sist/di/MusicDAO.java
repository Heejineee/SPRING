package com.sist.di;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
/*
 * 	1. XML �̿�
 * 	2. Annotation
 * 	3. XML + Annotation
 * 	4. ���� �ڹ�
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
		 * ������ �ϴ� �� ������ return getSqlSession().selectList("musicAllData"); ���ٷ� ó����
		 *  SqlSession session=ssf.openSession();, session.close(); ==> getSqlSession()
		 */
		return getSqlSession().selectList("musicAllData");
		
	}
}
