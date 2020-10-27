package com.sist.aop;

import org.springframework.stereotype.Repository;

// AOP는 사용자 정의 거의 없음 ==> Transaction, 보안
@Repository
public class MyDAO {
	public void getConnection()
	{
		System.out.println("오라클 연결");
	}
	public void disConnection()
	{
		System.out.println("오라클 연결 종료");
	}
	public void  db_select(String name)
	{
		//getConnection();
		System.out.println("SELECT 문장 실행");
		//disConnection();
	}
	public void db_insert()
	{
		//getConnection();
		System.out.println("INSERT 문장 실행");
		//disConnection();
	}
	public void db_update()
	{
		//getConnection();
		System.out.println("UPDATE 문장 실행");
		//disConnection();
	}
	public void print()
	{
		System.out.println("완료");
	}
}
