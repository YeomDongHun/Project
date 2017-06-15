package ClassMember;

class A{
	int instanceField = 1; // �ν��Ͻ� �ʵ�
	static int staticField = 1; // ���� �ʵ�
	
	public void instanceMethod(){ // �ν��Ͻ� �޼ҵ�
		this.instanceField = 1; // this ��� ����
		instanceField = 1; // �ν��Ͻ� �ʵ� ��� ����
		staticField = 1; // ���� �ʵ� ��� ����
	}
	
	public static void staticMethod(){ // ���� �޼ҵ�
//		this.instanceField = 5; this ��� �Ұ�(������ ����)
//		instanceField = 1; // �ν��Ͻ� �ʵ� ��� �Ұ�(������ ����)
		staticField = 1; // ���� �ʵ� ��� ����
	}
}

public class StaticMemberEx {
	public static void main(String[] args) { // ���� �޼ҵ�(main)
		A.staticField = 1; // AŬ���� ���� �ʵ� ��� ����
//		A.instanceField = 1; // AŬ���� �ν��Ͻ� �ʵ� ��� �Ұ�(�ʿ�� �ν��Ͻ� ���� �� ȣ��)
		A.staticMethod(); // AŬ���� ���� �޼ҵ� ��� ����
//		A.instanceMethod(); // AŬ���� �ν��Ͻ� �޼ҵ� ��� �Ұ�(�ʿ�� �ν��Ͻ� ���� �� ȣ��)
	}
}
