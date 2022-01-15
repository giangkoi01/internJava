package Managefacultysalaries;

import java.util.Scanner;

public class Subject {
	private static int number = 100;
	private int id;
	private  String name;
	private int total;
	private int theory;
	private int price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTheory() {
		return theory;
	}
	public void setTheory(int theory) {
		this.theory = theory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Subject() {
		super();
		this.id = number++;
	}
	public Subject(int id, String name, int total, int theory, int price) {
		super();
		this.id = id;
		this.name = name;
		this.total = total;
		this.theory = theory;
		this.price = price;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		this.setId(number);
		System.out.println("nhap ten mon hoc: ");
		this.setName(sc.nextLine());
		System.out.println("nhap tong so tiet");
		this.setTotal(sc.nextInt());
		System.out.println("nhap so tiet ly thuyet: ");
		boolean check = false;
		int n;
		do {
			n = sc.nextInt();
			if(n > getTotal()) {
				System.out.println("so tiet khong hop ly");
				check = true;
			}else {
				check = false;
			}
		} while (check);
		this.setTheory(n);
		System.out.println("nhap hoc phi: ");
		this.setPrice(sc.nextInt());
	}
	
	@Override
	public String toString() {
		return "Subject{" +
                "id=" + id +
                ", subject='" + name + '\'' +
                ", total=" + total +'\'' +
                ", theory='" + theory + '\'' +
                ", price='" + price + '\'' +
                '}';
	}
	
}
