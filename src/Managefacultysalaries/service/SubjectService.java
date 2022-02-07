package Managefacultysalaries.service;

import java.util.Scanner;

import Managefacultysalaries.ManageImpl;
import Managefacultysalaries.entity.Subject;
import Managefacultysalaries.entity.Teacher;
import Managefacultysalaries.util.DataUtil;

public class SubjectService {
	public void CreateSubject() {
		System.out.println("Nhap so luong mon hoc");
		int subjectNumber = new Scanner(System.in).nextInt();
		
		if(ManageImpl.subjects != null) {
			Subject[] subjectClone = ManageImpl.subjects.clone();
			ManageImpl.subjects = new Subject[subjectClone.length + subjectNumber];
			for (int i = 0; i < subjectClone.length; i++) {
				ManageImpl.subjects[i] = subjectClone[i];
			}
			
			for (int i = 0; i < subjectNumber; i++) {
				Subject subject = new Subject();
				subject.input();
				addSubjectToArray(subject);
			}
		} else {
			ManageImpl.subjects = new Subject[subjectNumber];
			for (int i = 0; i < subjectNumber; i++) {
				Subject subject = new Subject();
				subject.input();
				addSubjectToArray(subject);
			}
		}
	}

	public void addSubjectToArray(Subject subject) {
		for (int i = 0; i < ManageImpl.subjects.length; i++) {
			if (DataUtil.isNullOrEmpty(ManageImpl.subjects[i])) {
				ManageImpl.subjects[i] = subject;
				break;
			}
		}
	}

	public void outputSubject() {
		System.out.println("Danh sach mon hoc:");
		for (Subject subject : ManageImpl.subjects) {
			if (DataUtil.isNullOrEmpty(subject)) {
				break;
			}
			System.out.println(subject);
		}
	}

	public Subject searchSubject(int id) {
		for (Subject subject : ManageImpl.subjects) {
			if (subject.getId() == id)
				return subject;
		}
		return null;
	}
}
