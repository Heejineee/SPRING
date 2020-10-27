package com.sist.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app.xml");
		// ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		/*
		 * GenericXmlApplicationContext �� ApplicationContext ���� Ȯ���(�Ҹ굵 ����!)
		 */
		// ������(Scope) => �̱���/������Ÿ�� ��Ÿ�� �� ��� ==> ����Ʈ�� �̱��� // ������Ÿ���� �ּҰ� ���� �����		
		Sawon sa1=(Sawon)app.getBean("sa");
		Sawon sa2=(Sawon)app.getBean("sa");
		System.out.println("sa1 : "+sa1);
		System.out.println("sa2 : "+sa2);
		sa1.print();
		app.close();
	}

}
