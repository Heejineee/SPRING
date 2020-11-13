package com.sist.config;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
// 얘는 스프링 5버전
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages={"com.sist.*"})	// application-context.xml의 <context:component-scan base-package="com.sist.*"/> 랑 같은 역할
@EnableWebMvc	// HandlerMapping, HandlerAdapter, HttpRequestHandler 셋팅해줌 (책 p255 참고)
public class AppConfig implements WebMvcConfigurer {
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	/* application-context.xml에서
	 * <bean id="ds"
				class="org.apache.commons.dbcp.BasicDataSource"
				p:driverClassName="oracle.jdbc.driver.OracleDriver"
				p:url="jdbc:oracle:thin:@localhost:1521:XE"
				p:username="hr"
				p:password="happy"
		/>
		랑 아래 코딩 같은 역할
	 */
	@Bean
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 * <bean id="ssf"
				class="org.mybatis.spring.SqlSessionFactoryBean"
				p:dataSource-ref="ds"
		/>
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	/*
	 * <bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
				p:sqlSessionFactory-ref="ssf"
				p:mapperInterface="com.sist.dao.MusicMapper"
		/>
	 */
	@Bean
	public MapperFactoryBean mapperFactoryBean() throws Exception
	{
		MapperFactoryBean m=new MapperFactoryBean();
		m.setSqlSessionFactory(sqlSessionFactory());
		m.setMapperInterface(com.sist.dao.MusicMapper.class);
		return m;
	}
	/*
	 * <bean id="viewResolver"
				class="org.springframework.web.servlet.view.InternalResourceViewResolver"
				p:prefix="/"
				p:suffix=".jsp"
		/>
		 * p: 들어가면 set 메소드라서 항상 set 해줘야함!
	 */
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver r=new InternalResourceViewResolver();
		/*
		 * 	Class clsName=Class.forName("org.springframework.web.servlet.view.InternalResourceViewResolver");
		 * 	Object obj=clsName.newInstance();
		 * 	이렇게도 할 수 있음! 근데 new 쓰는 게 더 편하당~
		 */
		r.setPrefix("/");
		r.setSuffix(".jsp");
		return r;
	}
}









