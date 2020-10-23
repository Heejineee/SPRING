package com.sist.di2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component	// 메모리 할당
public class Sawon {
	@Autowired		// Saram에서 할당된 메모리 주소 자동으로 여기에 넣어줌
	private Saram saram;		// (Saram)app.getBean("saram") 들어가있음
	private String dept="개발부";
	private String job="대리";
	public Saram getSaram() {
		return saram;
	}
	public void setSaram(Saram saram) {
		this.saram = saram;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
