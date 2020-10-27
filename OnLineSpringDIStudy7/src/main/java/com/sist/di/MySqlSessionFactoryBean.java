package com.sist.di;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/*
 * <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
		p:configLocation="classpath:Config.xml"
	/>
 */
@Component	// ID �������� �ʾƼ� �ڵ����� => mySqlSessionFactoryBean
// ���̺귯�� => XML(���� ���κ�)
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	@Autowired		//  CONSTRUCTOR(������), FIELD(�������), METHOD(�޼ҵ�), PARAMETER(�Ű�����) ���� �ö� �� �ִ�
								// p:dataSource-ref="ds"
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	public MySqlSessionFactoryBean()
	{
		try
		{
			Resource res=new ClassPathResource("Config.xml");		// p:configLocation="classpath:Config.xml"
			setConfigLocation(res);
		}catch(Exception ex){}
	}
	
}
