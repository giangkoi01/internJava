package studentgpamanagement.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import studentgpamanagement.Manage;
import studentgpamanagement.model.Subject;
import studentgpamanagement.util.DataUtil;
import studentgpamanagement.util.file.FileUtil;

public class SubjectService {
	public static FileUtil fileUtil = new FileUtil();
	
	public void createSubject() {
		System.out.println("mời bạn nhập số lượng môn");
		int subjectNumber = -1;
		do {
			try {
				subjectNumber = new Scanner(System.in).nextInt();
				if (subjectNumber > 0) {
					break;
				}
				System.out.println("số lượng sinh viên phải là số nguyên");
			} catch (InputMismatchException e) {
				System.out.println("số lượng sinh viên phải là 1 số ");
			}
		} while (true);

		if (Manage.subjects != null) {
			Subject[] subjectClone = Manage.subjects.clone();
			Manage.subjects = new Subject[subjectClone.length + subjectNumber];

			for (int i = 0; i < subjectClone.length; i++) {
				Manage.subjects[i] = subjectClone[i];
			}

			for (int i = subjectClone.length; i < subjectClone.length + subjectNumber; i++) {
				Subject subject = new Subject();
				subject.input();
				addSubjectToArray(subject);
			}
		} else {
			Manage.subjects = new Subject[subjectNumber];
			for (int i = 0; i < subjectNumber; i++) {
				Subject subject = new Subject();
				subject.input();
				addSubjectToArray(subject);
			}
		}
		fileUtil.writeDataFromFile(Manage.subjects, "subject.dat");
	}

	private void addSubjectToArray(Subject subject) {
		for (int i = 0; i < Manage.subjects.length; i++) {
			if (DataUtil.isNullOrEmpty(Manage.subjects[i])) {
				Manage.subjects[i] = subject;
				break;
			}
		}
	}

	public void outputSubject() {
		if (DataUtil.isNullOrEmpty(Manage.subjects)) {
			System.out.println("nhap mon hoc truoc khi in");
			return;
		}
		System.out.println("danh sách môn học :");
		for (Subject subject : Manage.subjects) {
			if (DataUtil.isNullOrEmpty(subject)) {
				break;
			}
			System.out.println(subject);
		}
	}

	public static Subject searchSubject(int id) {
		for (Subject subject : Manage.subjects) {
			if (subject.getId() == id) {
				return subject;
			}
		}
		return null;
	}
}
