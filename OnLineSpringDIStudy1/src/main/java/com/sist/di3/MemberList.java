package com.sist.di3;
/*
 * 	- ���ռ�(������) ���� ���α׷�
 * 	- ���ռ�(������) ���� ���α׷� ==> ������
 * 	* ����� => �ٸ� Ŭ������ ����
 * 		������ => ���õ� �޼ҵ带 �� ��� ���
 * 	�� ����
 * 		- �Ϲ� ������
 * 		- Ŭ���� �ּҰ� : ref �ٿ��� �� (ref=bean�±��� id���� �ο�)
 */
public class MemberList {
	private Member mem;

	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}
	public void print()
	{
		System.out.println("ȸ����ȣ : "+mem.getNo());
		System.out.println("�̸� : "+mem.getName());
		System.out.println("���� : "+mem.getSex());
		System.out.println("�ּ� : "+mem.getAddr());
		System.out.println("��ȭ : "+mem.getTel());
	}
}
