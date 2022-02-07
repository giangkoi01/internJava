package Managefacultysalaries.entity;

import java.util.Scanner;

public class Teacher extends Person{
	public static final String GS_TS = "Giáo Sư - Tiến Sỹ";
	public static final String PGS_TS = "Phó Giáo Sư - Tiến Sỹ";
	public static final String GVC = "Giảng viên chính";
	public static final String TS = "Thạc Sỹ";
	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Teacher() {
		super();
	}

	public Teacher(int id, String name, String address, String phone, String level) {
		super(id, name, address, phone);
		this.level = level;
	}
	
	public void input() {
		super.input();
		boolean check = true;
		do {
			check = true;
			int n;
			System.out.println("chon trinh do: ");
			System.out.println("1.GS-TS");
			System.out.println("2.PGS-TS");
			System.out.println("3.Giang vien chinh");
			System.out.println("4.Thac si");
			n = new Scanner(System.in).nextInt();
			switch (n) {
			case 1:
				this.setLevel(Teacher.GS_TS);
				break;
			case 2:
				this.setLevel(Teacher.PGS_TS);
				break;
			case 3:
				this.setLevel(Teacher.GVC);
				break;
			case 4:
				this.setLevel(Teacher.TS);
				break;
			default:
				System.out.println("trinh do khong hop le, nhap lai !");
				check = false;
				break;
			}
		} while (!check);
	}
	
	@Override
    public String toString(){
        return "Teacher{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() +'\'' +
                ", phone='" + super.getPhone() + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
	
}
