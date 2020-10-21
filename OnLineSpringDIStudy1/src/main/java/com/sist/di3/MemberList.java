package com.sist.di3;
/*
 * 	- 결합성(의존성) 높은 프로그램
 * 	- 결합성(의존성) 낮은 프로그램 ==> 스프링
 * 	* 영향력 => 다른 클래스에 영향
 * 		응집성 => 관련된 메소드를 잘 묶어서 사용
 * 	값 대입
 * 		- 일반 변수값
 * 		- 클래스 주소값 : ref 붙여야 함 (ref=bean태그의 id명을 부여)
 */
public class MemberList {
	private Member mem;

	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}
	public void print()
	{
		System.out.println("회원번호 : "+mem.getNo());
		System.out.println("이름 : "+mem.getName());
		System.out.println("성별 : "+mem.getSex());
		System.out.println("주소 : "+mem.getAddr());
		System.out.println("전화 : "+mem.getTel());
	}
}
