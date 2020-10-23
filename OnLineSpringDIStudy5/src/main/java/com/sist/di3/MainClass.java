package com.sist.di3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MainClass {
	//@Autowired	// 얘만 주고싶으면 밑에 private MyDAO dao 를 private Oracle dao/private MySql dao 로 하면 됨
	//1@Qualifier("oracle")	// Autowired만 주면 두개가 등록되어 있어서 이렇게 지정 안해주면 오류남
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
			System.out.println("수행");
		}
		/*
		 * 	@Autowired : 스프링에 관리할 대상의 클래스 객체를 저장
		 * 								저장된 클래스의 주소값을 스프링에 자동으로 주입(전송)
		 */
	}

}
