package Field;

class FieldValue02 {
	// �ʵ�
	int a;
	String str;
	// ������
	public FieldValue02(){
		str = "��������"; // str �ʱ�ȭ
	}
	// �޼ҵ�
	public void print(){
		int b; // �������� ����
		System.out.println(a); // ��� : 0
//		System.out.println(b); // ������ ���� ==> ������ ���������� �ʱⰪ�� ���� ���ϱ� ������ ������ ������ �߻�.
		String str = "��������"; // �������� ����
		System.out.println(str); // ��� : ��������
		System.out.println(this.str); // ��� : �������� ==> this�� ��ü �ڽ��� ��Ÿ��.
	}
}

public class FieldEx02 {	
	public static void main(String[] args) {
		FieldValue02 fv = new FieldValue02(); // �ν��Ͻ� ����
		fv.print(); // �޼ҵ� ȣ��
	}
}


