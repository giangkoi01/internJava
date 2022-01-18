package stringhandling;

import java.util.Scanner;

public class Bai2 {
	public StringBuilder hoathuong(String str) {
		String[] str1 = str.split("");
		StringBuilder str2 = new StringBuilder();
		for (int i = 0; i < str1.length; i++) {
			if (i % 2 != 0) {
				str1[i] = str1[i].toLowerCase();
				str2.append(str1[i]);
			} else {
				str1[i] = str1[i].toUpperCase();
				str2.append(str1[i]);
			}

		}
		return str2;
	}

	public static void main(String[] args) {
		Bai2 bai2 = new Bai2();
		String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("mời bạn nhập chuỗi ký tự:");
		str = sc.nextLine();
		System.out.println(bai2.hoathuong(str));

	}
}
