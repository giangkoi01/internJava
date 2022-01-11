package basic;

import java.util.Scanner;

public class bai5 {
	public static void main(String[] args) {
		int n, soDu, tong = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("nhap so nguyen: ");
		n = scanner.nextInt();

		while (n > 0) {
			soDu = n % 10;
			n = n / 10;
			tong += soDu;
		}

		System.out.println("tong cac so = " + tong);
	}
}
