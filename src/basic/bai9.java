package basic;

public class bai9 {
	public static boolean checksodoixung(int i) {
		int reversed = 0, original;
		original = i;
		while (i != 0) {
			int digit = i % 10;
			reversed = reversed * 10 + digit;
			i /= 10;
		}
		if (reversed == original) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean checkso068(int i) {
		String str = i + "";
		if (str.contains("1") || str.contains("2") || str.contains("3") || str.contains("4") || str.contains("5")
				|| str.contains("7") || str.contains("9")) {
			return false;
		}
		return true;
	}

	public static boolean checkSoChiahet10(int i) {
		int soDu, tong = 0;
		while (i > 0) {
			soDu = i % 10;
			i = i / 10;
			tong += soDu;
		}
		if (tong % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		for (int i = 1000000; i < 999999999; i++) {
			if (checksodoixung(i) && checkso068(i) && checkSoChiahet10(i)) {
				System.out.println(i);
			}
		}
	}
}
