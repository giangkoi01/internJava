package studentgpamanagement.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import studentgpamanagement.Manage;
import studentgpamanagement.model.Student;
import studentgpamanagement.util.DataUtil;
import studentgpamanagement.util.file.FileUtil;

public class StudentService {
	public static FileUtil fileUtil = new FileUtil();
	
	public void createStudent() {
		System.out.println("mời bạn nhập số lượng sinh viên:");
		int studentNumber = -1;
		do {
			try {
				studentNumber = new Scanner(System.in).nextInt();
				if (studentNumber > 0) {
					break;
				}
				System.out.println("số lượng sinh viên phải là số nguyên");
			} catch (InputMismatchException e) {
				System.out.println("số lượng sinh viên phải là 1 số ");
			}
		} while (true);
		
		if (!DataUtil.isNullOrEmpty(Manage.students)) {
			Student[] studentClone = Manage.students.clone();
			Manage.students = new Student[studentClone.length + studentNumber];

			for (int i = 0; i < studentClone.length; i++) {
				Manage.students[i] = studentClone[i];
			}

			for (int i = studentClone.length; i < studentClone.length + studentNumber; i++) {
				Student student = new Student();
				student.input();
				addStudentToArray(student);
			}
		} else {
			Manage.students = new Student[studentNumber];
			for (int i = 0; i < studentNumber; i++) {
				Student student = new Student();
				student.input();
				addStudentToArray(student);
			}
		}
		fileUtil.writeDataFromFile(Manage.students, "student.dat");
	}

	private void addStudentToArray(Student student) {
		for (int i = 0; i < Manage.students.length; i++) {
			if (DataUtil.isNullOrEmpty(Manage.students[i])) {
				Manage.students[i] = student;
				break;
			}
		}
	}

	public void outputStudent() {
		if (DataUtil.isNullOrEmpty(Manage.students)) {
			System.out.println("nhập sinh viên trước khi in");
			return;
		}
		System.out.println("danh sách sinh viên:");
		for (Student student : Manage.students) {
			if (DataUtil.isNullOrEmpty(student)) {
				break;
			}
			System.out.println(student);
		}
	}
	
	public static Student searchStudent(int id) {
		for (Student student : Manage.students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
}
