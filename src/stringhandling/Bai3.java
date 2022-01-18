package stringhandling;

import java.util.Scanner;

public class Bai3 {
	public StringBuilder chuanhoa(String str){
        String s = str.replaceAll("\\s\\s+", " ").trim();
        String[] str1 = s.split("\\s");
        StringBuilder str2 = new StringBuilder();
        for(int i=0; i<str1.length; i++)
        {
            String firstUpperCase = str1[i].substring(0,1).toUpperCase();
            String remainingLetters = str1[i].substring(1, str1[i].length()).toLowerCase();
                str2.append(firstUpperCase);
                str2.append(remainingLetters);
                str2.append(" ");
        }
        return str2;
    }
    public static void main(String[] args) {
        Bai3 bai3 = new Bai3();
        String str;
		Scanner sc = new Scanner(System.in);
		System.out.println("mời bạn nhập chuỗi ký tự:");
		str = sc.nextLine();
        System.out.println( bai3.chuanhoa(str));

    }
}
