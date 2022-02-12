package studentgpamanagement.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
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
		System.out.println("nhập tên:");
		this.setName(new Scanner(System.in).nextLine());
		System.out.println("nhập địa chỉ : ");
		this.setAddress(new Scanner(System.in).nextLine());
		System.out.println("nhập số điện thoại :");
        do {
            try {
                    this.phone = new Scanner(System.in).nextInt();;
                    break;
               
            } catch (InputMismatchException ex) {
                System.out.print("Số điện thoại phai là so nguyên,nhập lại! ");
            }
        }while (true);
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
