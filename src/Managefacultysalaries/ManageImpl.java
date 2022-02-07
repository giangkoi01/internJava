package Managefacultysalaries;

import java.util.Scanner;

import Managefacultysalaries.entity.Subject;
import Managefacultysalaries.entity.Teacher;
import Managefacultysalaries.entity.Teaching;
import Managefacultysalaries.service.SubjectService;
import Managefacultysalaries.service.TeacherService;
import Managefacultysalaries.service.TeachingService;
import Managefacultysalaries.util.DataUtil;

public class ManageImpl {
	public static Subject[] subjects;
	public static Teacher[] teachers;
	public static Teaching[] teachings;

	public static TeacherService teacherService = new TeacherService();
	public static SubjectService subjectService = new SubjectService();
	public static TeachingService teachingService = new TeachingService();

	public int chooseMenu() {
		System.out.println("moi ban chon chuc nang:");
		System.out.println("1.Them giang vien");
		System.out.println("2.In danh sach giang vien");
		System.out.println("3.Them mon hoc");
		System.out.println("4.In danh sach mon hoc");
		System.out.println("5.Nhap giang vien giang day");
		System.out.println("6.In giang vien giang day");
		System.out.println("7.Sap xep theo ten giang vien");
		do {
			int choose = new Scanner(System.in).nextInt();
			if (choose > 0 && choose < 8) {
				return choose;
			}
			System.out.println("chuc nang khong ton tai,nhap lai");
		} while (true);
	}

	public void run() {
		do {
			int chooseMenu = chooseMenu();
			switch (chooseMenu) {
			case 1:
				teacherService.createTeacher();
				break;
			case 2:
				teacherService.outputTeacher();
				break;
			case 3:
				subjectService.CreateSubject();
				break;
			case 4:
				subjectService.outputSubject();
				break;
			case 5:
				teachingService.createTeaching();
				break;
			case 6:
				teachingService.outputTeaching();
				break;
			case 7:
				teachingService.sortByName();
				break;
			default:
				System.out.println("Khong co chuc nang vua nhap, moi nhap lai!");
				break;
			}

		} while (true);
	}
}
