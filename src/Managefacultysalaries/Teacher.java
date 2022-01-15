package Managefacultysalaries;

import java.util.Scanner;

public class Teacher extends Person{
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
		Scanner sc = new Scanner(System.in);
		super.input();
		String[] arr = {"GS-TS", "PGS-TS", "Giang vien tai chinh", "Thac sy"};
		boolean check = true;
		do {
			check = true;
			int n;
			System.out.println("chon trinh do: ");
			System.out.println("1.GS-TS");
			System.out.println("2.PGS-TS");
			System.out.println("3.Giang vien tai chinh");
			System.out.println("4.Thac si");
			n = sc.nextInt();
			switch (n) {
			case 1:
				this.setLevel(arr[0]);
				break;
			case 2:
				this.setLevel(arr[1]);
				break;
			case 3:
				this.setLevel(arr[2]);
				break;
			case 4:
				this.setLevel(arr[3]);
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address +'\'' +
                ", phone='" + phone + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
	
}
