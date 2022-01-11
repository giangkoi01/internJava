package basic;

public class bai8b {
	public static void main(String[] args) {
		for (int i = 100000; i < 999999; i++) {
			if (checksodoixung(i)) {
				if (checksochia10(i)) {
					System.out.println(i);
				}
			}
		}
	}

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

	public static boolean checksochia10(int i) {
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
}
