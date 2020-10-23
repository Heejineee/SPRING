package com.sist.di3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MainClass {
	//@Autowired	// �길 �ְ������ �ؿ� private MyDAO dao �� private Oracle dao/private MySql dao �� �ϸ� ��
	//1@Qualifier("oracle")	// Autowired�� �ָ� �ΰ��� ��ϵǾ� �־ �̷��� ���� �����ָ� ������
	// @Autowired+@Qualifier=@Resource
	@Resource(name="mySql")
	private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.dao.getConnection();
		mc.dao.disConnection();
		
		String s="Hello";
		StringBuffer sb=new StringBuffer();
		
		if(s instanceof String)
		{
			System.out.println("����");
		}
		/*
		 * 	@Autowired : �������� ������ ����� Ŭ���� ��ü�� ����
		 * 								����� Ŭ������ �ּҰ��� �������� �ڵ����� ����(����)
		 */
	}

}
