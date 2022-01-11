package array;

import java.util.Scanner;

public class bai4 {
	public static boolean ngto(int a){
        if(a <= 1) return  false;
        for(int i = 2; i <= Math.sqrt(a); i++){
            if(a % i == 0) return false;
        }
        return true;
    }
	
    public static int min(int a[], int n, int x){
        int v = 0;
        int min = 999999;
        for(int i = 0; i < n; i++){
            if(ngto(a[i])){
                if(Math.abs(x - a[i]) < min){
                    min = Math.abs(x - a[i]);
                    v = i;
                }
            }
        }
        return v;
    }
    
    public static void main(String[] args) {
    	int x, n;
    	int[] a;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu: ");
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
        	System.out.print("a[" + i + "] = ");
			a[i] = sc.nextInt();
        }
        System.out.print("Nhap x: ");
        x = sc.nextInt();
        System.out.println(min(a, n, x));
    }
}
