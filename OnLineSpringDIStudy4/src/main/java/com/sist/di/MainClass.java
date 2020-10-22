package com.sist.di;
// app1.xml, app2.xml �����ϴ� ��(������ 4)
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	Container : �������� Ŭ������ ��Ƽ� ���� ����
 * 		- ApplicationContext (������ 4)
 * 			=> XML�� �Ľ�
 * 		- AnnotationConfigApplicationContext (������ 5)
 * 			=> Annotation
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] xml={"app1.xml", "app2.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		// new ClassPathXmlApplicationContext({"app1.xml", "app2.xml"}); �� �ص� ��! �迭�� ���� �� ���Ƽ� ������ �Ѱž�~
		Sawon sa=(Sawon)app.getBean("sa");	// getBean�� ����Ǿ� �ִ� ��ü �ּҸ� ������ ��쿡 ���
		System.out.println("�̸� : "+sa.getName());
		System.out.println("�μ� : "+sa.getDept());
		System.out.println("���� : "+sa.getJob());
		Member mem=(Member)app.getBean("mem");	// Member mem=app.getBean("mem", Member.class); �ᵵ �� 
		System.out.println("�̸� : "+mem.getName());
		System.out.println("�ּ� : "+mem.getAddr());
		System.out.println("��ȣ : "+mem.getTel());
	}

}
