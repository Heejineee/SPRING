package com.sist.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	// Ŭ����(Sawon) ���
	@Bean("sa") 	// <bean id="sa" class="Sawon" �̶� ���� ����
	public Sawon sawonInfo()
	{
		Sawon sa=new Sawon();	// <bean id="sa" class="Sawon" p:name="ȫ�浿" p:addr="����" p:tel="010-1111-1111" /> �� ���� ����
		sa.setName("ȫ�浿");
		sa.setAddr("����");
		sa.setTel("010-1111-1111");
		return sa;
	}
	/*
	 * �޼ҵ� ȣ��
	 * 	- ��ü ������ : init-method (@PostConstruct)
	 * 	- ��ü �Ҹ�� : destroy-method (@PreDestroy)
	 * 
	 * DI
	 * 	- setter DI
	 * 	- method DI(init-method, destroy-method)
	 * 	- constructor DI ������ �Ű����� �� ����
	 * 	- �ڵ� ����
	 */
	@PostConstruct	// ���� <bean id="sa" class="Sawon" init-methode="init" destroy-method="destroy">
	public void init()
	{
		System.out.println("====== ������� ======");
	}
	@PreDestroy		// ȣ��
	public void destroy()
	{
		System.out.println("===================");
	}
}
