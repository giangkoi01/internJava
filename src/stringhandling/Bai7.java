package stringhandling;

import java.util.Scanner;

public class Bai7 {
	public String Delete(String str1, String str2){
        String str = "";
        str1 = str1.replaceAll(str2, str);
        return str1;
    }
	  
	public static void main(String[] args) {
		String str1, str2;
	    Scanner sc=new Scanner(System.in);
	    System.out.println("nhập xâu s1");
	    str1 = sc.nextLine();
	    System.out.println("nhập xâu s2");
	    str2 = sc.nextLine();
	    Bai7 bai7 = new Bai7();
	    System.out.println(bai7.Delete(str1, str2));
	    }
}
