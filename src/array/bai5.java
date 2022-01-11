package array;

import java.util.Scanner;

public class bai5 {
	public static void main(String[] args) {
        System.out.println("nhap so luong mang a: ");
        int n = new Scanner(System.in).nextInt();
        System.out.println("nhap so luong mang b: ");
        int m = new Scanner(System.in).nextInt();
        System.out.println("nhap p: ");
        int p = new Scanner(System.in).nextInt();
        int[]a = new int[n];
        int[]b = new int[m];
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
