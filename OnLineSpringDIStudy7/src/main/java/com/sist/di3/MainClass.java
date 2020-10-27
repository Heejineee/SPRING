package com.sist.di3;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
/*
 * 	TYPE : 클래스 위에
 * 	METHOD : 메소드 위에
 * 	FIELD : 멤버변수
 * 	CONSTRUCTOR : 생성자 위에
 * 	PARAMETER : 매개변수 옆에
 */
@Component("mc")	// 먼저 메인을 메모리 할당 해야 밑에 애들도 사용이 가능해서!
public class MainClass {
	@Resource(name="sa")	// Sawon.java에서 지정한 name
	private Sawon sa;
	@Resource(name="mem")	// Member.java에서 지정한 name
	private Member mem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");	// 여기에서 app이 Container
		MainClass mc=(MainClass)app.getBean("mc");
		mc.sa.print();
		mc.mem.print();
	}

}
