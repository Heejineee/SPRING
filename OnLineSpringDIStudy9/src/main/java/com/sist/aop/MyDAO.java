package com.sist.aop;

import org.springframework.stereotype.Repository;

// AOP�� ����� ���� ���� ���� ==> Transaction, ����
@Repository
public class MyDAO {
	public void getConnection()
	{
		System.out.println("����Ŭ ����");
	}
	public void disConnection()
	{
		System.out.println("����Ŭ ���� ����");
	}
	public void  db_select(String name)
	{
		//getConnection();
		System.out.println("SELECT ���� ����");
		//disConnection();
	}
	public void db_insert()
	{
		//getConnection();
		System.out.println("INSERT ���� ����");
		//disConnection();
	}
	public void db_update()
	{
		//getConnection();
		System.out.println("UPDATE ���� ����");
		//disConnection();
	}
	public void print()
	{
		System.out.println("�Ϸ�");
	}
}
