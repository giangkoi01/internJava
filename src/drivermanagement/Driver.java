package drivermanagement;

import java.util.Scanner;

public class Driver extends Person {
	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Driver() {
		super();
	}

	public Driver(int id, String name, String address, int phone, String level) {
		super(id, name, address, phone);
		this.level = level;
	}

	public void input() {
		super.input();
		int choose = 0;
		String arr[] = { "A", "B", "C", "D", "E", "F" };
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.println("chọn trình đọ lái xe : ");
			System.out.println("1.A  2.B  3.C  4.D  5.E  6.F");
			try {
				choose = sc.nextInt();
			} catch (Exception e) {
				System.out.println("không được nhập chữ,nhập lại");
				check = false;
			}
			switch (choose) {
				case 1:
					this.setLevel(arr[0]);
					check = true;
					break;
				case 2:
					this.setLevel(arr[1]);
					check = true;
					break;
				case 3:
					this.setLevel(arr[2]);
					check = true;
					break;
				case 4:
					this.setLevel(arr[3]);
					check = true;
					break;
				case 5:
					this.setLevel(arr[4]);
					check = true;
					break;
				case 6:
					this.setLevel(arr[5]);
					check = true;
					break;
				default:
					System.out.println("không có trình đọ vừa nhập, nhập lại");
					check = false;
					break;
			}
		} while (!check);
	}
}
