package array;

import java.util.Scanner;

public class bai1 {
	public static void main(String[] args) {
		int[] a;
		int n, i;
		int doixung = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("moi ban nhap so phan tu trong mang:");
		n = sc.nextInt();
		a = new int[n];
		for (i = 0; i < n; i++) {
			System.out.print("A[" + i + "] = ");
			a[i] = sc.nextInt();
		}
		for (i = 0; i <= n / 2; i++) {
			if (a[i] != a[n - 1 - i]) {
				doixung = 0;
				break;
			}
		}
		if (doixung == 0 ) {
			System.out.println("day khong la mang doi xung");
		} else {
			System.out.println("day la mang doi xung");
		}

	}
}
