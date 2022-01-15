package Managefacultysalaries;

import java.util.Scanner;

public class ManageImpl implements Manage{
	public static Subject[] subjects;
	public static Teacher[] teachers;
	public static Teaching[] teachings;
	public static Scanner scanner = new Scanner(System.in);

	public void run() {
		while (true) {
			System.out.println("moi ban chon chuc nang:");
			System.out.println("1.Them giang vien");
			System.out.println("2.In danh sach giang vien");
			System.out.println("3.Them mon hoc");
			System.out.println("4.In danh sach mon hoc");
			System.out.println("5.Nhap giang vien giang day");
			System.out.println("6.In giang vien giang day");
			System.out.println("7.Sap xep theo ten giang vien");
			boolean flag = true;
			do {
				flag = true;
				int chosse = 0;
				System.out.println("Chon chuc nang");
				chosse = scanner.nextInt();
				switch (chosse) {
				case 1:
					createTeacher();
					break;
				case 2:
					outputTeacher();
					break;
				case 3:
					CreateSubject();
					break;
				case 4:
					outputSubject();
					break;
				case 5:
					createTeaching();
					break;
				case 6:
					outputTeaching();
					break;
				case 7:
					sortByName();
					break;
				default:
					System.out.println("Khong co chuc nang vua nhap, moi nhap lai!");
					flag = false;
					break;
				}
			} while (!flag);
		}
	}
	
	@Override
	public void createTeacher() {
		System.out.println("Nhap so luong giang viên");
		int a = scanner.nextInt();
		teachers = new Teacher[a];
		for (int i = 0; i < a; i++) {
			Teacher teacher = new Teacher();
			teacher.input();
			teachers[i] = teacher;
		}
	}

	@Override
	public void outputTeacher() {
		System.out.println("Danh sach giang vien:");
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
	}

	@Override
	public void CreateSubject() {
		System.out.println("Nhap so luong mon hoc");
		int a = scanner.nextInt();
		subjects = new Subject[a];
		for (int i = 0; i < a; i++) {
			Subject subject = new Subject();
			subject.input();
			subjects[i] = subject;
		}
	}

	@Override
	public void outputSubject() {
		System.out.println("Danh sach mon hoc:");
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
		
	}

	@Override
	public Teacher SearchTeacher(int id) {
		for (Teacher teacher : teachers) {
			if (teacher.getId() == id)
				return teacher;
		}
		return null;
	}

	@Override
	public Subject SearchSubject(int id) {
		for (Subject subject : subjects) {
			if (subject.getId() == id)
				return subject;
		}
		return null;
	}

	@Override
	public void createTeaching() {
		System.out.println("Nhap so giao vien giang day:");
		boolean flag = false;
		int slgv;
		do {
			slgv = scanner.nextInt();
			if (slgv > teachers.length) {
				System.out.println("nhap lai so giang vien:");
				flag = true;
			} else
				flag = false;
		} while (flag);
		teachings = new Teaching[slgv];
		int sum = 0;
		for (int i = 0; i < slgv; i++) {
			System.out.println("Nhap id giang vien:");
			int idgv;
			Teacher teacher;
			boolean check = false;
			do {
				idgv = scanner.nextInt();
				teacher = SearchTeacher(idgv);
				if (teacher == null) {
					System.out.println("nhap lai id giang vien:");
					check = true;
				} else
					check = false;
			} while (check);
			System.out.println("Nhap so luong mon giang day:");
			int slm;
			do {
				slm = scanner.nextInt();
				if (slm > subjects.length) {
					System.out.println("nhap lại so mon giang day:");
					flag = true;
				} else
					flag = false;
			} while (flag);
			Subject[] subjects = new Subject[slm];
			int[] ListQuantity = new int[slm];
			check = true;
			do {
				sum = 0;
				for (int j = 0; j < slm; j++) {
					System.out.println("Nhap id mon hoc");
					int idm;
					Subject subject;
					do {
						idm = scanner.nextInt();
						subject = SearchSubject(idm);
						if (subject == null) {
							System.out.println("nhap lai id mon hoc:");
							flag = true;
						} else
							flag = false;
					} while (flag);
					int sll;
					System.out.println("nhap so lop day:");
					sll = scanner.nextInt();
					sum = sum + sll * subject.getTotal();
					if (sum > 200) {
						System.out.println("Nhap qua so tiet quy dinh.");
						check = true;
					} else
						check = false;
					ListQuantity[j] = sll;
					subjects[j] = subject;
				}
			} while (check);

			Teaching teaching = new Teaching(teacher, subjects, ListQuantity);
			teachings[i] = teaching;
		}
		
	}

	@Override
	public void outputTeaching() {
		for (Teaching teaching : teachings) {
			System.out.println(teaching);
		}
		
	}

	@Override
	public void sortByName() {
		Teaching tam = new Teaching();
		for (int i = 0; i < teachings.length - 1; i++) {
			for (int j = i + 1; j < teachings.length; j++) {
				if (teachings[i].getTeachers().getName().compareTo(teachings[j].getTeachers().getName()) > 0) {
					tam = teachings[i];
					teachings[i] = teachings[j];
					teachings[j] = tam;
				}
			}
		}
		for (int i = 0; i < teachings.length; i++) {
			System.out.println(teachings[i]);
		}
	}	
}
