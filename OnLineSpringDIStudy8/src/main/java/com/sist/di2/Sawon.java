package com.sist.di2;

import org.springframework.stereotype.Component;
/*
 * 	1. Ŭ���� => �޸� �Ҵ� => �������(Container)
 * 	2. Ŭ���� ã�� : DL
 * 	3. ������ ���ÿ� �ʿ��� �����Ͱ� �ִ� ��� : DI ==> setter, constructor(������)
 * 																								p:~				c:~
 * 	4. Ȱ�� : ���α׷���
 * 	5. �Ҹ� : �޸� ����
 */
@Component("sa")
public class Sawon {
	private String name="ȫ�浿";
	private String dept="������";
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
