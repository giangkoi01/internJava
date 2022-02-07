package Managefacultysalaries.service;

import java.util.Scanner;

import Managefacultysalaries.ManageImpl;
import Managefacultysalaries.entity.Teacher;
import Managefacultysalaries.util.DataUtil;

public class TeacherService {
	public void createTeacher() {
		System.out.println("Nhap so luong giang viên");
		int teacherNumber = new Scanner(System.in).nextInt();
		
		if(ManageImpl.teachers != null) {
			Teacher[] teacherClone= ManageImpl.teachers.clone();
			ManageImpl.teachers = new Teacher[teacherClone.length + teacherNumber];
			
			for(int i = 0 ; i < teacherClone.length; i++){
                ManageImpl.teachers[i] = teacherClone[i];
            }
			
			for (int i = teacherClone.length; i < teacherClone.length + teacherNumber; i++) {
				Teacher teacher = new Teacher();
				teacher.input();
				addTeacherToArray(teacher);
			}
		} else {
			ManageImpl.teachers = new Teacher[teacherNumber];
			for (int i = 0; i < teacherNumber; i++) {
				Teacher teacher = new Teacher();
				teacher.input();
				addTeacherToArray(teacher);
			}
		}
	}

	public void addTeacherToArray(Teacher teacher) {
		for (int i = 0; i < ManageImpl.teachers.length; i++) {
			if (DataUtil.isNullOrEmpty(ManageImpl.teachers[i])) {
				ManageImpl.teachers[i] = teacher;
				break;
			}
		}
	}

	public void outputTeacher() {
		System.out.println("Danh sach giang vien:");
		for (Teacher teacher : ManageImpl.teachers) {
			if (DataUtil.isNullOrEmpty(teacher)) {
				break;
			}
			System.out.println(teacher);
		}
	}

	public Teacher SearchTeacher(int id) {
		for (Teacher teacher : ManageImpl.teachers) {
			if (teacher.getId() == id)
				return teacher;
		}
		return null;
	}
}
