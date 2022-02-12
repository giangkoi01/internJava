package studentgpamanagement.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;
	private static String DC = "Đại cương";
	private static String CSN = "Cơ sở ngành";
	private static String CN = "Chuyên ngành";
	
	private static int idSuto = 100;
	private int id;
	private String name;
	private int number;
	private String typeSubject;

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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTypeSubject() {
		return typeSubject;
	}

	public void setTypeSubject(String typeSubject) {
		this.typeSubject = typeSubject;
	}

	public Subject() {
		super();
		this.id = idSuto++;
	}

	public Subject(int id, String name, int number, String typeSubject) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.typeSubject = typeSubject;
	}

	public void input() {
		System.out.println("nhập tên : ");
		this.setName(new Scanner(System.in).nextLine());
		System.out.println("nhập đơn vị học trình: ");
		do {
			try {
				this.number = new Scanner(System.in).nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("số điện thoại phải là 1 số");
			}
		} while (true);
		
		do {
			try {
				System.out.println("chọn loại môn: ");
				System.out.println("1.Đại cương,");
				System.out.println("2.Cơ sở ngành,");
				System.out.println("3.Chuyên ngành");
				int choose = new Scanner(System.in).nextInt();
				if(choose > 0 && choose < 4) {
					switch (choose) {
					case 1:
						this.typeSubject = Subject.DC;
						break;
					case 2:
						this.typeSubject = Subject.CSN;
						break;
					case 3:
						this.typeSubject = Subject.CN;
						break;
					}
					break;
				}
				System.out.println("loại môn không hợp lệ, nhập lại");
			} catch (InputMismatchException e) {
				System.out.println("vui lòng nhập số nguyên, nhập lại");
			}
		} while (true);
		
	}

	@Override
	public String toString() {
		return "Subject{" + "id=" + id + ", name='" + name + '\'' + ", number=" + number + ", typeSubject='"
				+ typeSubject + '\'' + '}';
	}
}
