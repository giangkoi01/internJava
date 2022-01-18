package stringhandling;

import java.util.Scanner;

public class Bai6 {
	 public void SortAlphabet(String str){
	        String [] str1=str.split("\\s");
	        String tam;
	        for(int i=0; i<str1.length-1; i++){
	            for (int j=i+1; j<str1.length; j++){
	                if(str1[i].compareTo(str1[j])>0){
	                    tam=str1[i];
	                    str1[i]=str1[j];
	                    str1[j]=tam;
	                }
	            }
	        }
	        for(int i=0; i<str1.length; i++){
	            System.out.println(str1[i]);
	        }
	    }

	    public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        System.out.println("Nhập chuỗi:");
	        String str;
	        boolean flag=true;
	        do {
	            str=sc.nextLine();
	            String [] str1=str.split("\\s");
	            if(str1.length>20){
	                System.out.println("Nhập lại chuỗi:");
	                flag=true;
	            }
	            else{
	                int dem=0;
	                for(int i=0; i<str1.length; i++){
	                    if(str1[i].length()>10)
	                    {
	                        dem=dem+1;
	                    }
	                }
	                if(dem>0){
	                    System.out.println("Nhập lại chuỗi:");
	                    flag=true;
	                }
	                else
	                    flag=false;
	            }
	        }while (flag);
	        Bai6 bai6 = new Bai6();
	        bai6.SortAlphabet(str);
	    }
	}