package InstanceMember;

class Data { 
	int a; //�ν��Ͻ� �ʵ�
	
	static void change(int x) {  // �⺻�� �Ű�����
		x = 1000;
		System.out.println("change() : x = " + x);//1000
	}
}

public class ParameterTest {
	
	public static void main(String[] args) {
		Data d = new Data();
		d.a = 10; //Data Ÿ���� d��ü�� ���� x�� 10���� �ʱ�ȭ
		System.out.println("main() : x = " + d.a); //10

		Data.change(d.a);//static(����)�޼ҵ忡���� �ν��Ͻ��ʵ尪�� ����� �� ����
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.a);
	}

	
}
