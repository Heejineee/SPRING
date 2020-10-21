package com.sist.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		// 등록된 클래스를 관리 => 클래스 필요시마다 app를 통해 객체주소를 얻어온다
		Sawon s1=app.getBean("sa", Sawon.class);	// (Sawon)app.getBean("sa") 이렇게 쓰기도 함 
		System.out.println("이름 : "+s1.getName());
		System.out.println("주소 : "+s1.getAddr());
		System.out.println("번호 : "+s1.getTel());
		
		app.close();
	}

}
