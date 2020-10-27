package com.sist.di2;

import org.springframework.stereotype.Component;
/*
 * 	1. 클래스 => 메모리 할당 => 저장공간(Container)
 * 	2. 클래스 찾기 : DL
 * 	3. 생성과 동시에 필요한 데이터가 있는 경우 : DI ==> setter, constructor(생성자)
 * 																								p:~				c:~
 * 	4. 활용 : 프로그래머
 * 	5. 소멸 : 메모리 해제
 */
@Component("sa")
public class Sawon {
	private String name="홍길동";
	private String dept="영업부";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
