package com.sist.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
 * 	�޸� �Ҵ�
 * 		- @Component : �Ϲ� Ŭ����(Sawon, MainClass...)
 * 		- @Repository : DAO
 * 		- @Controller : Model
 * 		- @Service : Manager, DAO+DAO
 * 		- @RestController : ���� ���� ���� �Ϲ� ���ڿ� ����(Ajax, React...)
 * 
 * 	����(Inject) (�޸𸮿� ����� ��ü �ּҸ� ������ �� �� ���), �Ϲ� ������ ����� �� ����
 * 		- @Autowired : ���������� ����� Ŭ���� �߿� �´� �ּҸ� ã�Ƽ� �ڵ� ����
 * 		- @Resource : Ư�� ��ü�� ����
 * 		- @Qualifier : Ư�� ��ü�� ����
 * 		- @Inject : Ư�� ��ü�� ����
 * 
 */
@Configuration
@ComponentScan(basePackages={"com.sist.di"})
public class AppConfig {
	
}
