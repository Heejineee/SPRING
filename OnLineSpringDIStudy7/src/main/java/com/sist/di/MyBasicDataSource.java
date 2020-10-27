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
// ������ ���̽� ���� �Ѱ��ִ� Ŭ����
// �޸� �Ҵ�
/*
 * @Component : �Ϲ� Ŭ����
 * @Repository : �����(DataBase�� ����) => DAO
 * @Controller : Model Ŭ����(��) ==> return ����Ʈ �ּ�(JSP ���ϸ�)
 * @RestController : Model Ŭ����(��) ==> return �Ϲ� ���ڿ�(ajax, json...)
 * @Service : Manager
 */
@Component	// ID ���� ���� ���ϸ� => myBasicDataSource���� �ڵ� ������
public class MyBasicDataSource extends BasicDataSource {
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@211.238.142.199:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
