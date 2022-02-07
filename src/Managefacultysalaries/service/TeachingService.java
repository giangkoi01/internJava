package Managefacultysalaries.service;

import java.util.Scanner;

import Managefacultysalaries.ManageImpl;
import Managefacultysalaries.entity.Subject;
import Managefacultysalaries.entity.Teacher;
import Managefacultysalaries.entity.Teaching;
import Managefacultysalaries.util.DataUtil;


public class TeachingService {
	public static Scanner scanner = new Scanner(System.in);
	public static TeacherService teacherService = new TeacherService();
	public static SubjectService subjectService = new SubjectService();
	
	public void createTeaching() {
		if (ManageImpl.teachers == null || ManageImpl.subjects == null) {
            System.out.println("nhap mon hoc va giang vien truoc khi phan cong");
            return;
        }
		
		boolean flag = false;
		System.out.println("Nhap so giao vien giang day:");
		int slgv;
		do {
			slgv = scanner.nextInt();
			if (slgv > ManageImpl.teachers.length) {
				System.out.println("nhap lai so giang vien:");
				flag = true;
			} else
				flag = false;
		} while (flag);
		
		ManageImpl.teachings = new Teaching[slgv];
		
		int sum = 0;
		for (int i = 0; i < slgv; i++) {
			System.out.println("Nhap id giang vien:");
			int idgv;
			Teacher teacher;
			boolean check = false;
			do {
				idgv = scanner.nextInt();
				teacher = teacherService.SearchTeacher(idgv);
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
				if (slm > ManageImpl.subjects.length) {
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
						subject = subjectService.searchSubject(idm);
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
			ManageImpl.teachings[i] = teaching;
		}

	}

	public void outputTeaching() {
		for (Teaching teaching : ManageImpl.teachings) {
			if (DataUtil.isNullOrEmpty(teaching)) {
				break;
			}
			System.out.println(teaching);
		}

	}

	public void sortByName() {
		Teaching tam = new Teaching();
		for (int i = 0; i < ManageImpl.teachings.length - 1; i++) {
			for (int j = i + 1; j < ManageImpl.teachings.length; j++) {
				if (ManageImpl.teachings[i].getTeachers().getName().compareTo(ManageImpl.teachings[j].getTeachers().getName()) > 0) {
					tam = ManageImpl.teachings[i];
					ManageImpl.teachings[i] = ManageImpl.teachings[j];
					ManageImpl.teachings[j] = tam;
				}
			}
		}
		for (Teaching teaching : ManageImpl.teachings) {
			if (DataUtil.isNullOrEmpty(teaching)) {
				break;
			}
			System.out.println(teaching);
		}
	}
}
