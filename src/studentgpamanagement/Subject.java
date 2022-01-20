package studentgpamanagement;

import java.util.Scanner;

public class Subject {
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
		Scanner sc = new Scanner(System.in);
		System.out.println("nhập tên : ");
		this.setName(sc.nextLine());
		try {
			System.out.println("nhập đơn vị học trình: ");
			this.setNumber(sc.nextInt());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] arr = {"Đại cương,", "Cơ sở ngành,", "Chuyên ngành"};
		boolean check = true;
		do {
			check = true;
			int n;
			System.out.println("chọn loại môn: ");
			System.out.println("1.Đại cương,");
			System.out.println("2.Cơ sở ngành,");
			System.out.println("3.Chuyên ngành");
			n = sc.nextInt();
			switch (n) {
			case 1:
				this.setTypeSubject(arr[0]);
				break;
			case 2:
				this.setTypeSubject(arr[1]);
				break;
			case 3:
				this.setTypeSubject(arr[2]);
				break;
			default:
				System.out.println("loai môn không hợp lệ, nhập lại !");
				check = false;
				break;
			}
		} while (!check);
	}
	
	@Override
	public String toString() {
		return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", typeSubject='" + typeSubject + '\'' +
                '}';
	}
}
