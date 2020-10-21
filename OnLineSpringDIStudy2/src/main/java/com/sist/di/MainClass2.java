package com.sist.di;
class A
{
	public A(String name)
	{
		
	}
}
class B
{
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A("20");
		// A a=new A();	// 얘는ㄴ 오류(생성자에 매개변수 있는데 호출할 때 매개변수 없어서)
		B b=new B();	// 얘는 위에서 생성자 안해서 디폴트로 매개변수 없는 애가 생성됐기 땜에 얘는 오류 안남!
	}

}
