package com.sist.di;
// app1.xml, app2.xml 연결하는 곳(스프링 4)
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 	Container : 여러개의 클래스를 모아서 관리 영역
 * 		- ApplicationContext (스프링 4)
 * 			=> XML을 파싱
 * 		- AnnotationConfigApplicationContext (스프링 5)
 * 			=> Annotation
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] xml={"app1.xml", "app2.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		// new ClassPathXmlApplicationContext({"app1.xml", "app2.xml"}); 로 해도 됨! 배열이 편할 것 같아서 저렇게 한거야~
		Sawon sa=(Sawon)app.getBean("sa");	// getBean은 저장되어 있는 객체 주소를 얻어오는 경우에 사용
		System.out.println("이름 : "+sa.getName());
		System.out.println("부서 : "+sa.getDept());
		System.out.println("직위 : "+sa.getJob());
		Member mem=(Member)app.getBean("mem");	// Member mem=app.getBean("mem", Member.class); 써도 됨 
		System.out.println("이름 : "+mem.getName());
		System.out.println("주소 : "+mem.getAddr());
		System.out.println("번호 : "+mem.getTel());
	}

}
