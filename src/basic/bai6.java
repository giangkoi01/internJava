package basic;

import java.util.Scanner;

public class bai6 {
	public static boolean checkNguyenTo(int n) {
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

	public static void main(String args[]) {
		int n;
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap so nguyen: ");
		n = scanner.nextInt();
		for (int i = 2; i <= n; i++) {
			while (checkNguyenTo(i) && (n % i == 0)) {
				System.out.print(" " + i);
				n /= i;
			}
		}
	}
}
