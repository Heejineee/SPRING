package com.sist.di2;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component	// 메모리 할당
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		EmpDAO dao=(EmpDAO)app.getBean("empDAO"); // EmpDAO에 @Repository값
		List<EmpVO> list=dao.empAllData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getSal());
		}
	}

}
