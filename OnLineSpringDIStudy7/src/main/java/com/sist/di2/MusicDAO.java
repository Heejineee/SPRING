package com.sist.di2;
import java.util.*;

import org.apache.ibatis.session.SqlSessionFactory;
/*
 * Spring 5����(�ڹٸ� �̿�)
 * 	BasicDataSource		=>	SqlSessionFactoryBean		=>	MusicDAO
 * 		����Ŭ ����									Connection							PreparedStatement, ResultSet
 */
/*
 * <bean id="dao" class="com.sist.di.MusicDAO"
		p:sqlSessionFactory-ref="ssf"
	/>
 */
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository	// ID �������� �ʾƼ� �ڵ����� => MusicDAO
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
