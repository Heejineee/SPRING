package com.sist.di2;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository	// 아이디 지정하지 않으면 클래스 이름이 자동으로 아이디로 됨(대신 첫글자는 소문자!) 
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	public List<EmpVO> empAllData()
	{
		return mapper.empAllData();
	}
}
