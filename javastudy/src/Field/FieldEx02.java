package Field;

class FieldValue02 {
	// 필드
	int a;
	String str;
	// 생성자
	public FieldValue02(){
		str = "전역변수"; // str 초기화
	}
	// 메소드
	public void print(){
		int b; // 지역변수 선언
		System.out.println(a); // 출력 : 0
//		System.out.println(b); // 컴파일 에러 ==> 선언한 지역변수는 초기값을 갖지 못하기 때문에 컴파일 에러가 발생.
		String str = "지역변수"; // 지역변수 선언
		System.out.println(str); // 출력 : 지역변수
		System.out.println(this.str); // 출력 : 전역변수 ==> this는 객체 자신을 나타냄.
	}
}

public class FieldEx02 {	
	public static void main(String[] args) {
		FieldValue02 fv = new FieldValue02(); // 인스턴스 생성
		fv.print(); // 메소드 호출
	}
}


