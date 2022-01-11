package array;

import java.util.Scanner;

public class bai5 {
	public static void main(String[] args) {
		int m, n, p;
		int[] a;
		int[] b;
		Scanner sc = new Scanner(System.in);
        System.out.println("nhap so luong mang a: ");
        n = sc.nextInt();
        System.out.println("nhap so luong mang b: ");
        m = sc.nextInt();
        System.out.println("nhap p: ");
        p = sc.nextInt();
        a = new int[n];
        b = new int[m];
        System.out.println("nhap mang a: ");
        inputArray(a,n);
        System.out.println("nhap mang b: ");
        inputArray(b,m);
        if (p>=0 && p<=n){
            outArray(a,0,p);
            outArray(b,0,m);
            outArray(a,p,n);
        }
    }

    private static void outArray(int[] a, int d, int c) {
        for (int i = d; i<c; i++){
            System.out.print(a[i]+" ");
        }
    }

    private static void inputArray(int[] a, int n) {
        for (int i=0; i<n; i++){
            a[i] = new Scanner(System.in).nextInt();
        }
    }
}
