package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass3 {
	public MainClass3() {
		// TODO Auto-generated constructor stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		Member m1=(Member)app.getBean("mem");
		m1.print();
		Member m2=(Member)app.getBean("mem2");	// Member m2=app.getBean("mem2", Member.class);
		m2.print();
		Member m3=(Member)app.getBean("mem3");
		m3.print();
		
	}
}
