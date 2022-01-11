package basic;

import java.util.Scanner;

public class bài2 {
	public static void main(String[] args) {
		int i, dem = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("moi ban nhap so nguyen :");
		int n = scanner.nextInt();
		for (i = 1; i <= n; i++) {
			if (n % i == 0) {
				System.out.println(i + " ");
				dem++;
			}
		}
		System.out.println("so uoc la: " + dem);
	}
}
