package stringhandling;

import java.util.Scanner;

public class Bai4 {
	public void Search(String str){
        String[] str1=str.split("\\s");
        String str2=str1[0];
        int a=1;
        for(int i=1; i<str1.length; i++){
            if(str2.length()<str1[i].length()){
                str2=str1[i];
                a=i+1;
            }
        }
        System.out.println("chuỗi dài nhất:"+ str2 +"\nvị trí:"+ a);
    }

    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
        String str;
        System.out.println("Nhap xâu kí tự:");
        Scanner sc=new Scanner(System.in);
        str = sc.nextLine();
        bai4.Search(str);
    }
}
