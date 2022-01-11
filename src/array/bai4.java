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
        int min = 9999;
        for(int i = 0; i < n; i++){
            if(ngto(a[i])){
                if(Math.abs(x - a[i]) < min){
                    min = Math.abs(x - a[i]);
                    v = a[i];
                }
            }
        }
        return v;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.print("Nhap x: ");
        int x = in.nextInt();
        System.out.println(min(a, n, x));
    }
}
