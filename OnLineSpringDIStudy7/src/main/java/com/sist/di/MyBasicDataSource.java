package com.sist.di;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

/*
 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@211.238.142.199:1521:XE"
		p:username="hr"
		p:password="happy"
	/>
 */
// 데이터 베이스 정보 넘겨주는 클래스
// 메모리 할당
/*
 * @Component : 일반 클래스
 * @Repository : 저장소(DataBase와 관련) => DAO
 * @Controller : Model 클래스(웹) ==> return 사이트 주소(JSP 파일명)
 * @RestController : Model 클래스(웹) ==> return 일반 문자열(ajax, json...)
 * @Service : Manager
 */
@Component	// ID 따로 지정 안하면 => myBasicDataSource으로 자동 설정됨
public class MyBasicDataSource extends BasicDataSource {
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@211.238.142.199:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
