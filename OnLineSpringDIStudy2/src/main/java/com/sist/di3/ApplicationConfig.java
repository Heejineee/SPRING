package com.sist.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// XML 대신 사용
@Configuration
public class ApplicationConfig {
	@Bean("mem")	// <bean>태그 대처 ==> 어노테이션 대처하는 프로그램 ==> 어노테이션
	// @Scope("prototype")
	public Member memberInfo()
	{
		Member m=new Member("이순신", "광화문", "010-1111-1111");
		return m;
	}
}
