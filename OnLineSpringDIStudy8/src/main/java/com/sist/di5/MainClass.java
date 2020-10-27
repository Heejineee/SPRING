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
		 * GenericXmlApplicationContext 이 ApplicationContext 보다 확장됨(소멸도 해줌!)
		 */
		// 사용범위(Scope) => 싱글톤/프로토타입 나타낼 때 사용 ==> 디폴트는 싱글톤 // 프로토타입은 주소값 따로 저장됨		
		Sawon sa1=(Sawon)app.getBean("sa");
		Sawon sa2=(Sawon)app.getBean("sa");
		System.out.println("sa1 : "+sa1);
		System.out.println("sa2 : "+sa2);
		sa1.print();
		app.close();
	}

}
