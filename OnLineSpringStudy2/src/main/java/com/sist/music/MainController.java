package com.sist.music;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 	����� ���� Ŭ������ ��Ƽ� �����ֱ�(Ŭ���� ��ü ���� ~ ��ü �Ҹ�) ����
 * 		==> ���赵 ���� ����, �ٸ� Ŭ������ ���� ��ġ�� ����
 * 		==> ���ռ�(������) ���� ���α׷�
 * 		==> �޸� �Ҵ�(���������� �Ѵ�) => �޸𸮸� �������� �ʴ´� ==> �̱���
 * 	XML : Ŭ������ ��Ű�� ������ �޸� �Ҵ� ��û
 * 	Annotation : Ŭ���� ã��, �޼ҵ� ã��
 * 
 * 	Container : Ŭ������ ��Ƽ� ����
 * 		==> ApplicationContext => application-context.xml
 * 				------------------------- XML  �ļ� 
 * 	�� DI : ����(setter, ������ �Ű������� ���� ä���)
 * 	�� AOP : �ݺ��� ���� => �ڵ�ȣ��(�ݹ��Լ�)
 * 	ORM : Mapper(�����ͺ��̽� ����)
 * 	MVC : Web
 * 
 * 	Spring 5	 => ���� �ڹٸ����� �ڵ�(XML�� ����), kotlin (Annotation)
 * 
 * 	DL : Ŭ������ ã�� �� ���
 * 	DI : �޸� �Ҵ�ÿ� �ʿ��� ������ �޴´�
 * 
 */

@Controller // �갡 �־�� �޸� �Ҵ� 
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request)
	{
		request.setAttribute("msg", "Hello Spring");
		return "main/main";
	}
}
