package basic;

import java.util.Scanner;

public class bai3 {
	public static void main(String[] args) {
		int a, b, s;
		Scanner sc = new Scanner(System.in);
		System.out.print("Moi ban nhap a: ");
		a = sc.nextInt();
		System.out.print("Moi ban nhap b: ");
		b = sc.nextInt();
		s = a * b;
		while ( a != b)
	    {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }
		System.out.println("uoc chung lon nhat la :" + a);
		System.out.println("boi chung nho nhat la :" + s/a);
	}
}
