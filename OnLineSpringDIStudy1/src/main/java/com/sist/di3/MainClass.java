package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		//														 ------------ C:\springDev\springStudy\OnLineSpringDIStudy1\src\main\java 까지 읽음 그래서 뒤에 xml값만 주면 됨
		MemberList ml=(MemberList)app.getBean("ml");	// 제네릭스
		// app.getBean("ml", MemberList.class); 위 아래 같음
		ml.print();
		
	}

}
