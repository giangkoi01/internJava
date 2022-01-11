package array;

import java.util.Scanner;

public class bai2 {
	public static void main(String[] args) {
		int[] a;
		int n, i, j, temp;
		Scanner sc = new Scanner(System.in);
		System.out.println("moi ban nhap so phan tu trong mang:");
		n = sc.nextInt();
		a = new int[n];
		for (i = 0; i < n; i++) {
			System.out.print("A[" + i + "] = ");
			a[i] = sc.nextInt();
		}
		for(i = 0; i < n ; i++) {
			for (j = i+1; j < n; j++) {
				if(a[i] > a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for (i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
		
	}
}
