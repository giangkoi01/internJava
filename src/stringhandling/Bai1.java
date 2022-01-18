package stringhandling;

public class Bai1 {
	public boolean checknghich(String str) {
		int length = str.length();
		for(int i = 0; i < length/2; i++) {
			if(str.charAt(i) != str.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}
	
	public void check() {
		for(int i = 100000; i < 999999; i++) {
			String str = String.valueOf(i);
			if(checknghich(str) == true) {
				System.out.println(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Bai1 bai1 = new Bai1();
		bai1.check();
	}
}
