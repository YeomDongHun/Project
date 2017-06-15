package CallByReference;

public class ReferenceParameter{	
	public void increase(int[] n){ //n = ref1 : ref1�̶�� �迭�� ����Ű�� ��ü�� n�̶�� �迭�� 
	                                       //              ����Ų��.....
		for(int i = 0 ; i < n.length ; i++){ //�迭�� ó��n[0]���� �迭�� ũ��n[n.length-1]��ŭ �ݺ�
			n[i]++; //i��° �迭�ǰ��� 1��ŭ����
			System.out.println("n["+i+"] : "+ n[i]);
		}
	}
	public static void main(String[] args){
		int[] ref1 = {100,800,1000}; //ref1.length = 3
		ReferenceParameter rp = new ReferenceParameter(); //��ü����
		for(int i = 0 ; i < ref1.length ; i++)
			System.out.println("ref1["+i+"] : "+ ref1[i]);
		////////////////////////////////////////////////////////////
		rp.increase(ref1); //������Ŵ
		////////////////////////////////////////////////////////////
		for(int i = 0 ; i < ref1.length ; i++)
			System.out.println("ref1["+i+"] : "+ ref1[i]);
	
		///////////////////////////////////////////////////////////�Ű������� �־��� ��ü �����Ͱ��� ��ȭ
		 /*Call by reference������ reference(address)�� ����Ǿ� ���� �Ǿ����Ƿ� �ϳ��� Object�� �����ϴ� ������ 2���� �Ǿ� 
		  * ��� �� ������ ������ �ϰ� �Ǹ� ���� Object�� �����ϴ� �ٸ� �ʿ����� ������ �ް� �ȴ�.*/
	}
}
