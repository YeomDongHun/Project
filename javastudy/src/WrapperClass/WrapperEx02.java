package WrapperClass;

public class WrapperEx02 {
	public static void main(String[] args) {
		int i = 10;
		Integer wi = Integer.valueOf(i); // 박싱(int → Integer)
		
		
		String str = "10";
		Integer wi2 = Integer.valueOf(str); // String → Integer
		
		double d = 3.14;
		Double wd = Double.valueOf(d); // 박싱(double → Double)
		
		boolean bl = true;
		Boolean wb = Boolean.valueOf(bl); // 박싱(boolean → Boolean)
	}
}
//wrapper클래스에서 갖고 있는 valueOf()메서드를 이용하는 방법
