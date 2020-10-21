package com.sist.di;
// 생성자 DI ==> 객체 생성시에 생성자 매개변수에 값을 채워라
/*
 * 	XML, ANNOTATION => 스프링에 요청
 * 
 * 	초기의 스프링은 필요시마다 스프링에 요청하여 값을 얻어오는 방식
 * 	현재의 스프링은 제어하는 제어권이 스프링에 있다 ==> 제어가 역전되었다(IoC) 
 */
public class Member {
	private String name;
	private String addr;
	private String tel;
	public Member(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	public void print()
	{
		System.out.println("이름 : "+name);
		System.out.println("주소 : "+addr);
		System.out.println("번호 : "+tel);
	}
}
