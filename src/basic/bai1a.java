package basic;

import java.util.Scanner;

public class bai1a {
	public static void main(String[] args) {
	int tong = 0;
	Scanner scanner = new Scanner(System.in);
	System.out.println("moi ban nhap so nguyen :");
	int n = scanner.nextInt();
	if(n % 2 == 0) {
		for(int i = 0; i<=n; i+=2) {
			tong += i;
		}
	}else {
		for(int i = 1; i<=n; i+=2) {
			tong += i;
		}
	}
		System.out.println("tong la : "+ tong);
}
}
