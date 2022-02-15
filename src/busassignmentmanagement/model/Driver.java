package busassignmentmanagement.model;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver extends Person implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String A = "loại A";
	public static final String B = "loại B";
	public static final String C = "loại C";
	public static final String D = "loại D";
	public static final String E = "loại E";
	public static final String F = "loại F";
	
	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Driver(int id, String name, String adress, int phoneNumber, String level) {
		super(id, name, adress, phoneNumber);
		this.level = level;
	}
	
	
	public Driver() {
	}

	public void input() {
		super.input();
		do {
			try {
				System.out.println("mời bạn chọn trình độ");
				System.out.println("1.loại A");
				System.out.println("2.loại B");
				System.out.println("3.loại C");
				System.out.println("4.loại D");
				System.out.println("5.loại E");
				System.out.println("6.loại F");
				int choose = new Scanner(System.in).nextInt();
				if(choose > 0 && choose < 7) {
					switch (choose) {
					case 1:
						this.level = Driver.A;
						break;
					case 2:
						this.level = Driver.B;
						break;
					case 3:
						this.level = Driver.C;
						break;
					case 4:
						this.level = Driver.D;
						break;
					case 5:
						this.level = Driver.E;
						break;
					case 6:
						this.level = Driver.F;
						break;
					}
					break;
				}
				System.out.println("trình độ vừa nhập k hợp lệ, nhập lại");
			} catch (InputMismatchException e) {
				System.out.println("trình độ phải là 1 số");
			}
		} while (true);
	}

	@Override
	public String toString() {
		return "Driver{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAdress() +'\'' +
                ", phone='" + super.getPhoneNumber() + '\'' +
                ", level='" + level + '\'' +
                '}';
	}
	
}
