package basic;

public class bai10 {
	public static boolean checksonguyento(int n) {
		if (n <= 2) {
			return true;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean checktatcasonguyento(int n) {
		String str = n + "";
		if (str.contains("0") || str.contains("1") || str.contains("4") || str.contains("6") || str.contains("8")
				|| str.contains("9")) {
			return false;
		}
		return true;
	}

	public static int checkdao(int n) {
		int dao = 0;
		while (n > 0) {
			dao = 10 * dao + n % 10;
			n /= 10;
		}
		return dao;
	}

	public static void main(String[] args) {
		for (int i = 1000000; i < 9999999; i++) {
			if (checksonguyento(i) && checktatcasonguyento(i) && checksonguyento(checkdao(i))) {
				System.out.println(i);
			}
		}
	}
}
