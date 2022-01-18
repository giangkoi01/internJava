package stringhandling;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai5 {
    public void chuyendoi(String s){
        StringTokenizer tg= new StringTokenizer(s);
        StringBuffer kq= new StringBuffer();
        String s1[]= new String[10];
        int i=1;
        while(tg.hasMoreTokens()){
            s1[i]= tg.nextToken();
            i++;
        }
        kq.append(s1[3]).append(" "); kq.append(s1[1]).append(" "); kq.append(s1[2]).append(" ");
        System.out.println(kq);
    }
    
    public static void main(String[] args) {
        String str = new String();
        Scanner sc= new Scanner(System.in);
        System.out.println("nhập xâu họ tên theo cấu trúc: họ...đệm...tên:");
        str = sc.nextLine();
        Bai5 bai5 = new Bai5();
        bai5.chuyendoi(str);

    }


}