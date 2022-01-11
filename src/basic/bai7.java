package basic;

public class bai7 {
	public static void main(String[] args) {
		int count = 0;
		System.out.println("cac so nguyen to co 6 chu so la:");
		for (int i = 1000 - 1; i < 999990; i += 2) {
			if (isPrimeNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isPrimeNumber(int n) {
		if (n % 2 == 0) {
			return false;
		} else {
			if (n < 2) {
				return false;
			}
			int squareRoot = (int) Math.sqrt(n);
			for (int i = 2; i <= squareRoot; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
