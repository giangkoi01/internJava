package studentgpamanagement.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import studentgpamanagement.Manage;
import studentgpamanagement.model.Student;
import studentgpamanagement.model.Subject;
import studentgpamanagement.model.Transcript;
import studentgpamanagement.util.DataUtil;
import studentgpamanagement.util.file.FileUtil;

public class MarkSubject {
	public static FileUtil fileUtil = new FileUtil();
	
	public void createMark() {
		if(Manage.students == null || Manage.subjects == null) {
			System.out.println("nhâp sinh viên và môn học trước khi nhập điểm");
			return;
		}
		int StudentNumber, subjectNumber, StudentId, subjectId;
		int markStudent = -1;
		Student student;
		Subject subject;
		boolean flag = false;
		do {
			System.out.println("nhập số sinh viên cần nhập điểm");
			StudentNumber = new Scanner(System.in).nextInt();
			if (StudentNumber > Manage.students.length) {
				System.out.println("nhập lại số sinh viên cần nhập điểm");
				flag = true;
			} else {
				flag = false;
			}
		} while (flag);
		Manage.transcripts = new Transcript[StudentNumber];

		for (int i = 0; i < StudentNumber; i++) {
			do {
				System.out.println("nhập id sinh viên:");
				StudentId = new Scanner(System.in).nextInt();
				student = StudentService.searchStudent(StudentId);
				if (student == null) {
					System.out.println("nhập lại id");
					flag = true;
				} else {
					flag = false;
				}
			} while (flag);
			do {
				System.out.println("nhập số môn học:");
				subjectNumber = new Scanner(System.in).nextInt();
				if (subjectNumber > Manage.subjects.length) {
					System.out.println("nhập lại số lượng môn học");
					flag = true;
				} else {
					flag = false;
				}
			} while (flag);

			Subject[] subjects = new Subject[subjectNumber];
			int[] marks = new int[subjectNumber];
			for (int j = 0; j < subjectNumber; j++) {
				do {
					System.out.println("nhập id môn học:");
					subjectId = new Scanner(System.in).nextInt();
					subject = SubjectService.searchSubject(subjectId);
					if (subject == null) {
						System.out.println("nhập lại id môn học: ");
						flag = true;
					} else {
						flag = false;
					}
				} while (flag);
				System.out.println("nhập điểm:");
				do {
					try {
						markStudent = new Scanner(System.in).nextInt();
						if (markStudent >= 0 && markStudent <= 10) {
							break;
						} 
						System.out.println("điểm phải lớn hơn 0 và nhỏ hơn 10");
						
					} catch (InputMismatchException e) {
						System.out.println("điểm phải là 1 số");
					}
				} while (true);
				subjects[j] = subject;
				marks[j] = markStudent;
			}
			Transcript transcript = new Transcript(student, subjects, marks);
			Manage.transcripts[i] = transcript;
		}
		fileUtil.writeDataFromFile(Manage.transcripts, "transcript.dat");
	}

	public void outputMark() {
		if(DataUtil.isNullOrEmpty(Manage.transcripts)) {
			System.out.println("nhap diem sinh vien truoc khi in");
			return;
		}
		System.out.println("danh sách điểm sinh viên:");
		for (Transcript transcript : Manage.transcripts) {
			if(DataUtil.isNullOrEmpty(transcript)) {
				break;
			}
			System.out.println(transcript);
		}
	}

	public void sortByNameStudent() {
		Transcript tam = new Transcript();
		for (int i = 0; i < Manage.transcripts.length - 1; i++) {
			for (int j = i + 1; j < Manage.transcripts.length; j++) {
				if (Manage.transcripts[i].getStudent().getName().compareTo(Manage.transcripts[j].getStudent().getName()) > 0) {
					tam = Manage.transcripts[i];
					Manage.transcripts[i] = Manage.transcripts[j];
					Manage.transcripts[j] = tam;
				}
			}
		}
		for (int i = 0; i < Manage.transcripts.length; i++) {
			System.out.println(Manage.transcripts[i]);
		}
	}

	public void sortByNameSubject() {
		Subject tam = new Subject();
		for (int i = 0; i < Manage.transcripts.length; i++) {
			for (int j = 0; j < Manage.transcripts[i].getSubjects().length - 1; j++) {
				for (int j2 = j + 1; j2 < Manage.transcripts[i].getSubjects().length; j2++) {
					if (Manage.transcripts[i].getSubjects()[j].getName()
							.compareTo(Manage.transcripts[i].getSubjects()[j2].getName()) > 0) {
						tam = Manage.transcripts[i].getSubjects()[j];
						Manage.transcripts[i].getSubjects()[j] = Manage.transcripts[i].getSubjects()[j2];
						Manage.transcripts[i].getSubjects()[j2] = tam;
					}
				}
			}
		}
		for (int i = 0; i < Manage.transcripts.length; i++) {
			System.out.println(Manage.transcripts[i]);
		}
	}
}
