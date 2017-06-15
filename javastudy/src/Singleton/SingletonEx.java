package Singleton;

class Singleton{
	private static Singleton instance = new Singleton(); // �����ʵ� / �ν��Ͻ� ���� 
	private Singleton(){} // private ������
	public static Singleton getInstance(){ // getInstance �޼��� ����
		return instance; // instance ��ü ����
	}
}

public class SingletonEx {
	public static void main(String[] args) {
		Singleton st1 = Singleton.getInstance(); // �̱��� �ν��Ͻ� ȣ��
		Singleton st2 = Singleton.getInstance();
//		Singleton st3 = new Singleton(); // ������ �̿� �ν��Ͻ� ���� �Ұ�
		if(st1 == st2){
			System.out.println("���� ��ü");
		}else{
			System.out.println("�ٸ� ��ü");
		}
	}
}


