package busassignmentmanagement.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import busassignmentmanagement.Main;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	public static int autoId = 10000;
	private int id;
	private String name;
	private String adress;
	private int phoneNumber;
	public static int getAutoId() {
		return autoId;
	}
	public static void setAutoId(int autoId) {
		Person.autoId = autoId;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Person(int id, String name, String adress, int phoneNumber) {
		super();
		this.id = autoId;
		this.name = name;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
	}
	public Person() {
		super();
	}
	
	public void input() {
		this.id = autoId++;
		System.out.println("mời bạn nhập tên:");
		this.name = new Scanner(System.in).nextLine();
		System.out.println("nhập địa chỉ:");
		this.adress = new Scanner(System.in).nextLine();
		System.out.println("nhập số điện thoại");
		int phoneNumber = -1;
		do {
			try {
				phoneNumber = new Scanner(System.in).nextInt();
				if(phoneNumber >= 0) {
					break;
				}
				System.out.println("số điện thoại phải lớn hơn 0");
			} catch (InputMismatchException e) {
				System.out.println("số điện thoại phải là 1 số");
			}
		} while (true);
		this.phoneNumber = phoneNumber;
	}
	
}
