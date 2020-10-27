package com.sist.di3;

import org.springframework.stereotype.Component;

@Component("mem")
public class Member {
	private String name="∏∂¿Ω¿Ã";
	private String tel="1234-1234";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
