package Field;

class FieldValue{
	// 필드
	byte byteF;
	char charF;
	short shortF;
	int intF;
	long longF;
	float floatF;
	double doubleF;
	boolean booleanF;
	int[] intArray;
	String StringF;
	
	// 메소드
	public void value(){
		System.out.println("byte : "+byteF);
		System.out.println("char : "+charF);
		System.out.println("short : "+shortF);
		System.out.println("int : "+intF);
		System.out.println("long : "+longF);
		System.out.println("float : "+floatF);
		System.out.println("double : "+doubleF);
		System.out.println("boolean : "+booleanF);
		System.out.println("int[] : "+intArray);
		System.out.println("String : "+StringF);		
	}
}

public class FieldEx {
	public static void main(String[] args) {
		FieldValue fv = new FieldValue();
		fv.value();
	}
}

//필드에 선언한 변수 즉, 전역변수는 초기값을 갖는다.


