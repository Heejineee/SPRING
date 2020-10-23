package com.sist.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MainClass {
	@Autowired		// 지역변수는 사용 불가능, 객체에 주소 넣을 때에만 사용
	private Sawon sa;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println("이름 : "+mc.sa.getSaram().getName());
		System.out.println("성별 : "+mc.sa.getSaram().getSex());
		System.out.println("나이 : "+mc.sa.getSaram().getAge());
		System.out.println("부서 : "+mc.sa.getDept());
		System.out.println("직위 : "+mc.sa.getJob());
	}

}
