package com.sist.di4;

import javax.annotation.Resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.di.AppConfig;
import com.sist.di2.*;
import com.sist.di3.*;

@Component
public class MainClass {
	@Resource(name="sa")
	private Sawon sa;
	@Resource(name="mem")
	private Member mem;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 초기화
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(AppConfig.class);
		MainClass mc=(MainClass)app.getBean("mainClass");
		System.out.println("=== 사원 ===");
		System.out.println(mc.sa.getName());
		System.out.println(mc.sa.getDept());
		System.out.println("===  멤버 ===");
		System.out.println(mc.mem.getName());
		System.out.println(mc.mem.getTel());
	}

}
