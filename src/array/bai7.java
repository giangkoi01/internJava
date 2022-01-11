package array;

import java.util.Scanner;

public class bai7 {
	public static void main(String[] args) {
		int n;
		int[] a;
		Scanner sc = new Scanner(System.in);
		System.out.print("nhap so phan tu trong mang: ");
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("phan tu thu " + (i + 1) + " la: ");
			a[i] = new Scanner(System.in).nextInt();
		}
		int[] b = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			b[i] = 1;
			for (int j = i; j < n - 1; j++) {
				if (a[j] <= a[j + 1]) {
					b[i]++;
				}
				if (a[j] > a[j + 1]) {
					break;
				}
			}
			if (b[i] > max) {
				max = b[i];
			}
		}
		System.out.println("do dai duong chay la: " + max);
		for (int i = 0; i < n; i++) {
			if (max == b[i]) {
				System.out.println("tai vi tri: " + (i));
			}
		}
	}
}
