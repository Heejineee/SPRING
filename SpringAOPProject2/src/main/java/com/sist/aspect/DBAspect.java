package com.sist.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 	@Aspect => 공통모듈 => DAO에서 공통 사용되는 내용 모아줌
 * 	@Component => 메모리 할당
 */
/*
 * 	public List<EmpVO> empListData()
 *		{
 *			try
 *			{
 *				getConnection() ==> BEFORE
 *				~~~~~~~ SQL문장
 *				~~~~~~~
 *			}catch(Exception e)
 *			{
 *				e.printStackTrace()
 *			}
 *			finally
 *			{
 *				disConnection() ==> After
 *			}
 *		}
 *
 *		자동호출
 *			1. 언제 ==> PointCut
 *			2. 어디서 ==> JoinPoint
 *			================== 합쳐서 Advice
 *			Advice => 여러개 => Aspect
 */
import com.sist.dao.*;
@Aspect
@Component
public class DBAspect {
	@Autowired
	private DBConnection dbConn;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")	// com.sist.dao.EmpDAO에 emp로 시작하는 모든 메소드 // 맨 앞 *은 리턴형 상관없이 다 받는단거! // (..) 매개변수 다 받는단거!
	public void before()
	{
		dbConn.getConnection();
	}
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after()
	{
		dbConn.disConnection();
	}
	/*
	 * 	Around
	 * 		1. 자동 호출 setAutoCommit(false)
	 * 			== 핵심 코딩 SQL 문장 수행
	 * 		2. 자동 호출 commit()
	 */
	@Around("execution(* com.sist.web.EmpController.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		System.out.println("사용자 호출 전 : "+jp.getSignature().getName());
		obj=jp.proceed();
		System.out.println("사용자 호출 후 : "+jp.getSignature().getName());
		return obj;
	}
	@AfterReturning(value="execution(* com.sist.web.EmpController.*(..))", returning="val")
	public void afterReturning(JoinPoint jp, Object val)
	{
		System.out.println("리턴 값 : "+val);
	}
	@AfterThrowing(value="execution(* com.sist.web.EmpController.*(..))", throwing="ex")
	public void afterThrowing(Throwable ex)
	{
		System.out.println(ex.getMessage());
	}
}








