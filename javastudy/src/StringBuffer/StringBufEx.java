package StringBuffer;

class StringBufEx{

	public static void main(String[] args){
		
		StringBuffer sb1 = new StringBuffer("Sun-Ae");
		StringBuffer sb2 = sb1.append(" & Kyung-Ju"); // Sun-Ae & Kyung-Ju 가 sb1의 메모리에 저장 , sb2는 sb1의 메모리를 참조함

		String msg = null;
		if(sb1 == sb2) //sb1와 sb2에 담겨있는 데이터의 비교가 아닌 주소값으로 비교
			msg = "sb1와 sb2는 같다.";
		else
			msg = "sb1와 sb2는 다르다.";
		System.out.println(msg);
		
		msg = sb1.toString();
		System.out.println("sb1 : " + msg);
		msg = sb2.toString();
		System.out.println("sb2 : " + msg);
		
	}
}