package studentgpamanagement.model;

import java.io.Serializable;
import java.util.Scanner;

public class Student extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student(int id, String name, String address, int phone, String className) {
		super(id, name, address, phone);
		this.className = className;
	}

	public Student() {
		super();
	}
	
	public void input() {
		super.input();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập lớp: ");
		this.setClassName(sc.nextLine());
	}
	
	@Override
	public String toString() {
		return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +'\'' +
                ", phone='" + phone + '\'' +
                ", class='" + className + '\'' +
                '}';
	}
}
