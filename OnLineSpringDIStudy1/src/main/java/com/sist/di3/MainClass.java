package com.sist.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		//														 ------------ C:\springDev\springStudy\OnLineSpringDIStudy1\src\main\java ���� ���� �׷��� �ڿ� xml���� �ָ� ��
		MemberList ml=(MemberList)app.getBean("ml");	// ���׸���
		// app.getBean("ml", MemberList.class); �� �Ʒ� ����
		ml.print();
		
	}

}
