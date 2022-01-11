package array;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap so phan tu :");
        n = sc.nextInt();
        int[] b = new int[n];
        int[] a = new int[n];
        inputArray(a,b,n);
        totalNumber(a,b,n);
    }

    private static void totalNumber(int[] a,int[] b, int n) {
        int temp = 0;
        int count;
        int max = 0;
        for (int i = 0; i < n; i++) {
            count = 1;
            if (b[i]==0){
                b[i]=1;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] == a[i]) {
                        count++;
                        b[j]=1;
                    }
                }
                System.out.println("phan tu " + a[i] + " xuat hien " + count + "lan");
                if (max < count){
                    max = count;
                }
                if (max == count){
                    temp = a[i];
                }
            }
        }
        System.out.println("phan tu xuat hien nhieu nhat : " + temp);
    }

    private static void inputArray(int[] a,int[] b, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("phan tu thu " + i + " : ");
            a[i] = new Scanner(System.in).nextInt();
            b[i]=0;
        }
    }
}