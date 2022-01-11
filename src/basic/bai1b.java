package basic;

import java.util.Scanner;

public class bai1b {
	public static void main(String[] args) {
		float sum = 0;
		int n, i;
		Scanner scanner = new Scanner(System.in);
		System.out.println("moi ban nhap so nguyen :");
		n = scanner.nextInt();
        for (i = 1; i <= n; i++){
            sum += (float) 1 / i;
        }
        System.out.println("tong la: " + sum);
    }
}
