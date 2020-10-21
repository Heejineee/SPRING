package com.sist.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	// 클래스(Sawon) 등록
	@Bean("sa") 	// <bean id="sa" class="Sawon" 이랑 같은 역할
	public Sawon sawonInfo()
	{
		Sawon sa=new Sawon();	// <bean id="sa" class="Sawon" p:name="홍길동" p:addr="서울" p:tel="010-1111-1111" /> 과 같은 역할
		sa.setName("홍길동");
		sa.setAddr("서울");
		sa.setTel("010-1111-1111");
		return sa;
	}
	/*
	 * 메소드 호출
	 * 	- 객체 생성시 : init-method (@PostConstruct)
	 * 	- 객체 소멸시 : destroy-method (@PreDestroy)
	 * 
	 * DI
	 * 	- setter DI
	 * 	- method DI(init-method, destroy-method)
	 * 	- constructor DI 생성자 매개변수 값 주입
	 * 	- 자동 주입
	 */
	@PostConstruct	// 생성 <bean id="sa" class="Sawon" init-methode="init" destroy-method="destroy">
	public void init()
	{
		System.out.println("====== 사원정보 ======");
	}
	@PreDestroy		// 호출
	public void destroy()
	{
		System.out.println("===================");
	}
}
