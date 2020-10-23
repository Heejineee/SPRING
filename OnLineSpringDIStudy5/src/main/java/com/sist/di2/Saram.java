package com.sist.di2;

import org.springframework.stereotype.Component;

@Component	// 메모리 할당
public class Saram {
	private String name="홍길동";
	private String sex="남자";
	private int age=30;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	} 
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
