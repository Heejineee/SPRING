package com.sist.di2;
import java.util.*;

import lombok.Getter;
import lombok.Setter; 
// VO(사용자 정의 데이터형) => 스프링에서 관리하는 클래스가 아니다!
/*
 * 	스프링이 관리하는 대상 ==> Bean(1~5를 Bean 이라고 한다!)
 * 		1) DAO
 * 			=> @Repository
 * 		2) Manager(웹 크롤링, 트위터 연결, openApi 사용시)
 * 			=> @Component
 * 		3) Model
 * 			=> @Controller
 * 		4) Service(DAO+DAO) ==> BI
 * 			=> @Service
 * 		5) AOP(공통모듈)
 * 			=> @Aspect
 */
// @Setter
// @Getter
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private Date regdate;
	private int sal;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
