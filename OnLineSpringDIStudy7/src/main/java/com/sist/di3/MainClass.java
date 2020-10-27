package com.sist.di3;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * 	TYPE : Ŭ���� ����
 * 	METHOD : �޼ҵ� ����
 * 	FIELD : �������
 * 	CONSTRUCTOR : ������ ����
 * 	PARAMETER : �Ű����� ����
 */
@Component("mc")	// ���� ������ �޸� �Ҵ� �ؾ� �ؿ� �ֵ鵵 ����� �����ؼ�!
public class MainClass {
	@Resource(name="sa")	// Sawon.java���� ������ name
	private Sawon sa;
	@Resource(name="mem")	// Member.java���� ������ name
	private Member mem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");	// ���⿡�� app�� Container
		MainClass mc=(MainClass)app.getBean("mc");
		mc.sa.print();
		mc.mem.print();
	}

}