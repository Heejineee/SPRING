package com.sist.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// XML ��� ���
@Configuration
public class ApplicationConfig {
	@Bean("mem")	// <bean>�±� ��ó ==> ������̼� ��ó�ϴ� ���α׷� ==> ������̼�
	// @Scope("prototype")
	public Member memberInfo()
	{
		Member m=new Member("�̼���", "��ȭ��", "010-1111-1111");
		return m;
	}
}
