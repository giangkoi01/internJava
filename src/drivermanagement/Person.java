package drivermanagement;

import java.util.Scanner;

public class Person {
	private static int idAuto = 10000;
	private int id;
	private String name;
	private String address;
	private int phone;
	
	
	public static int getIdAuto() {
		return idAuto;
	}
	public static void setIdAuto(int idAuto) {
		Person.idAuto = idAuto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = idAuto++;
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
		System.out.println("mời bạn nhập tên: ");
		this.setName(sc.nextLine());
		System.out.println("nhập địa chỉ: ");
		this.setAddress(sc.nextLine());
		System.out.println("nhập số điện thoại: ");
		this.setPhone(sc.nextInt());
	}
	
	@Override
	public String toString() {
		return "Person{" +
                "iD=" + id +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
	}
}
