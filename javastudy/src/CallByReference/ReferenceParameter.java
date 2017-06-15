package CallByReference;

public class ReferenceParameter{	
	public void increase(int[] n){ //n = ref1 : ref1이라는 배열이 가리키는 객체를 n이라는 배열도 
	                                       //              가리킨다.....
		for(int i = 0 ; i < n.length ; i++){ //배열의 처음n[0]부터 배열의 크기n[n.length-1]만큼 반복
			n[i]++; //i번째 배열의값을 1만큼증가
			System.out.println("n["+i+"] : "+ n[i]);
		}
	}
	public static void main(String[] args){
		int[] ref1 = {100,800,1000}; //ref1.length = 3
		ReferenceParameter rp = new ReferenceParameter(); //객체생성
		for(int i = 0 ; i < ref1.length ; i++)
			System.out.println("ref1["+i+"] : "+ ref1[i]);
		////////////////////////////////////////////////////////////
		rp.increase(ref1); //증가시킴
		////////////////////////////////////////////////////////////
		for(int i = 0 ; i < ref1.length ; i++)
			System.out.println("ref1["+i+"] : "+ ref1[i]);
	
		///////////////////////////////////////////////////////////매개변수로 주었던 객체 데이터값의 변화
		 /*Call by reference에서는 reference(address)가 복사되어 전달 되었으므로 하나의 Object를 참조하는 변수가 2개가 되어 
		  * 어느 한 곳에서 수정을 하게 되면 같은 Object를 참조하는 다른 쪽에서도 영향을 받게 된다.*/
	}
}
