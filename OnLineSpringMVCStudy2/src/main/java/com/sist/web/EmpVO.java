package com.sist.web;
/*
 *	 데이터 넘기는 방법
 *		 1. 단일변수
 *		 2. VO단위
 *		 3. [] => checkbox
 *		 4. List 단위
 */
public class EmpVO {
	private int empno;
	private String ename;
	private String job;
	private String dept;
	private String loc;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
