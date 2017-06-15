package InstanceMember;

class Data { 
	int a; //인스턴스 필드
	
	static void change(int x) {  // 기본형 매개변수
		x = 1000;
		System.out.println("change() : x = " + x);//1000
	}
}

public class ParameterTest {
	
	public static void main(String[] args) {
		Data d = new Data();
		d.a = 10; //Data 타입의 d객체의 변수 x를 10으로 초기화
		System.out.println("main() : x = " + d.a); //10

		Data.change(d.a);//static(정적)메소드에서는 인스턴스필드값을 사용할 수 없다
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.a);
	}

	
}
