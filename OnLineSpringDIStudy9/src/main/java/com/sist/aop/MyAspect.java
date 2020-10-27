package com.sist.aop;
import org.aspectj.lang.annotation.After;
/*
 * 	public void select()
 * 	{
 * 		try
 * 		{
 * 			%%%%%% ==> Before
 * 			insert();
 * 		}catch(Exception ex)
 * 		{
 * 			%%%%%% ==> After-Throwing
 * 		}
 * 		finally
 * 		{
 * 			%%%%%% ==> After
 * 		}
 * 		return; 	==> After-Returning
 * 	} 
 */
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 공통모듈
@Aspect	// 공통 모듈 이라는 것만 갖고있음
@Component	// 그래서 메모리 할당도 해줘야 함
public class MyAspect {
	@Autowired
	private MyDAO dao;
	@Before("execution(* com.sist.aop.MyDAO.db_*(..))")
	// 리턴형(꽌계없이 처리) db_*() => 매개변수가 없는 상태
	// db_*(int) db_*(String, String) db_*(..)  ==> 매개변수 존재할 때도 존재하지 않을 때도 쓸 때 (..) 사용
	/*
	 * 	1. Before
	 * 	2. After
	 * 	3. After-Throwing
	 * 	4. After-Returning
	 * 	5. Around
	 * ================= 호출 위치(JoinPoint)
	 * 적용되는 메소드 설정 ==> PointCut
	 * JoinPoint+PointCut=Advice 여러개 ==> Aspect
	 * 
	 * ==> Proxy 패턴
	 * 		=> 대신 호출(대체자)
	 * 
	 * Class A
	 * {
	 * 	public void display()
	 * 	{
	 * 		System.out.println("display()");
	 * 	}
	 * }
	 * 
	 * class Proxy
	 * {
	 * 	public void display(A a)
	 * 	{
	 * 		System.out.println("Before");
	 * 		a.display();
	 * 		System.out.println("After");
	 * 	}
	 * }
	 * 
	 * A a=new A();
	 * a.display(); ==> X
	 * Proxy p=new Proxy();
	 * p.display(a); ==> O
	 */
	public void before()
	{
		dao.getConnection();
	}
	@After("execution(* com.sist.aop.MyDAO.db_*(..))")
	public void after()
	{
		dao.disConnection();
	}
}
