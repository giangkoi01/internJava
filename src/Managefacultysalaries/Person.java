package Managefacultysalaries;

import java.util.Scanner;

public class Person {
	private static int number = 100;
	private int id;
	private String name;
	private String address;
	private String phone;
	public static int getNumber() {
		return number;
	}
	public static void setNumber(int number) {
		Person.number = number;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Person() {
		super();
		this.id = number++;
	}
	public Person(int id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		this.setId(number);
		System.out.println("Nhap ho ten : ");
		this.setName(sc.nextLine());
		System.out.println("Nhap dia chi: ");
		this.setAddress(sc.nextLine());
		System.out.println("Nhap so dien thoai: ");
		this.setPhone(sc.nextLine());
	}
	
	@Override
	public String toString() {
		return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                '}';
	}
	
}
