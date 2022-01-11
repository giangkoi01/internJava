package array;

import java.util.Scanner;

public class bai6 {

    public  static void main(String []argv){
    	Scanner sc = new Scanner(System.in);
        int n, x;
        int [] a;
        System.out.print("nhap so phan tu mang:");
        n = sc.nextInt();
        System.out.print("nhap x:");
        x = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++)
        {
        	System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }
        int []b=new int [n+1];
        for(int i = 0; i < n; i++)
        {
            b[i] = a[i];
        }
        b[n] = x;
        int tam;
        for(int i = 0; i < n; i++)
        {
            for(int j=i+1; j<n+1; j++){
                if(b[i]>b[j]){
                    tam=b[i];
                    b[i]=b[j];
                    b[j]=tam;
                }
            }
        }
        System.out.print("mang sau chen:");
        for(int i = 0; i <= n; i++)
        {
            System.out.print(b[i] + " ");
        }
    }
}