package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
	@Bean("sawon")	// ID
	public Sawon sawonInfo()
	{
		Sawon s=new Sawon();	// 객체 생성
		// DI
		s.setName("이순신");
		s.setDept("개발부");
		s.setJob("과장");
		/*
		 * app1.xml의 
		* <bean id="sa" class="com.sist.di.Sawon"
					p:name="홍길동"
					p:dept="영업부"
					p:job="대리"
			/>
		 * 	와 같음
		 */
		return s;
	}
	
}
