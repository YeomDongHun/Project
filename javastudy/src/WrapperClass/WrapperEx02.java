package WrapperClass;

public class WrapperEx02 {
	public static void main(String[] args) {
		int i = 10;
		Integer wi = Integer.valueOf(i); // �ڽ�(int �� Integer)
		
		
		String str = "10";
		Integer wi2 = Integer.valueOf(str); // String �� Integer
		
		double d = 3.14;
		Double wd = Double.valueOf(d); // �ڽ�(double �� Double)
		
		boolean bl = true;
		Boolean wb = Boolean.valueOf(bl); // �ڽ�(boolean �� Boolean)
	}
}
//wrapperŬ�������� ���� �ִ� valueOf()�޼��带 �̿��ϴ� ���
