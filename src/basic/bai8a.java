package basic;

public class bai8a {
	public static void main(String[] args) {
		for (int i = 100000; i < 999999; i++) {
			if (checksodoixung(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean checksodoixung(int i) {
		int reversed = 0, original;
		original = i;

		while (i != 0) {
			int sodu = i % 10;
			reversed = reversed * 10 + sodu;
			i /= 10;
		}
		if (reversed == original) {
			return true;
		}
		else {
			return false;
		}
	}
}
