package com.sist.di2;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
/*
 * Spring 5버전(자바만 이용)
 * 	BasicDataSource		=>	SqlSessionFactoryBean		=>	MusicDAO
 * 		오라클 정보									Connection							PreparedStatement, ResultSet
 */
/*
 * <bean id="dao" class="com.sist.di.MusicDAO"
		p:sqlSessionFactory-ref="ssf"
	/>
 */
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository	// ID 설정하지 않아서 자동으로 => MusicDAO
public class MusicDAO extends SqlSessionDaoSupport{
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<MusicVO> musicListData()
	{
		return getSqlSession().selectList("musicListData");
	}
}
