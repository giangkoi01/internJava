package studentgpamanagement;

import java.util.Scanner;

public class Person {
	private static int number = 10000;
	public int id;
	public String name;
	public String address;
	public int phone;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Person() {
		super();
		this.id = number++;
	}
	public Person(int id, String name, String address, int phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên:");
		this.setName(sc.nextLine());
		System.out.println("nhập địa chỉ : ");
		this.setAddress(sc.nextLine());
		try {
			System.out.println("nhập số điện thoại :");
			this.setPhone(sc.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
