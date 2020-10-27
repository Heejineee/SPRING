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
@Component	// ID 지정하지 않아서 자동으로 => mySqlSessionFactoryBean
// 라이브러리 => XML(공통 사용부분)
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	@Autowired		//  CONSTRUCTOR(생성자), FIELD(멤버변수), METHOD(메소드), PARAMETER(매개변수) 위에 올라갈 수 있다
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
