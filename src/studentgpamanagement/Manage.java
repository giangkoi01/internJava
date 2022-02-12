package studentgpamanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import studentgpamanagement.model.Student;
import studentgpamanagement.model.Subject;
import studentgpamanagement.model.Transcript;
import studentgpamanagement.service.MarkSubject;
import studentgpamanagement.service.StudentService;
import studentgpamanagement.service.SubjectService;
import studentgpamanagement.util.DataUtil;
import studentgpamanagement.util.file.FileUtil;

public class Manage {
	public static Student[] students;
	public static Subject[] subjects;
	public static Transcript[] transcripts;

	public static FileUtil fileUtil = new FileUtil();
	
	public static SubjectService subjectService = new SubjectService();
	public static StudentService studentService = new StudentService();
	public static MarkSubject markSubject = new MarkSubject();

	private void initializeData() {
		Object studentFromFile = fileUtil.readDataFromFile("student.dat");
		students = DataUtil.isNullOrEmpty(studentFromFile) ? new Student[100] : (Student[]) studentFromFile;

		Object subjectFromFile = fileUtil.readDataFromFile("subject.dat");
		subjects = DataUtil.isNullOrEmpty(subjectFromFile) ? new Subject[100] : (Subject[]) subjectFromFile;

		Object transcriptFromFile = fileUtil.readDataFromFile("transcript.dat");
		transcripts = DataUtil.isNullOrEmpty(transcriptFromFile) ? new Transcript[100] : (Transcript[]) transcriptFromFile;
	}

	public void run() {
		initializeData();
		do {
			System.out.println("mời bạn chọn chức năng:");
			System.out.println("1.nhập sinh viên");
			System.out.println("2.in sinh viên");
			System.out.println("3.nhập môn học");
			System.out.println("4.in danh sách môn học");
			System.out.println("5.nhập điểm sinh viên");
			System.out.println("6.In điểm sinh viên");
			System.out.println("7.sắp xếp theo tên sinh viêm");
			System.out.println("8.sắp xếp theo tên môn học");
			System.out.println("Chon chuc nang");
			try {
				int chosse = new Scanner(System.in).nextInt();
				if (chosse > 0 && chosse < 9) {
					switch (chosse) {
					case 1:
						studentService.createStudent();
						break;
					case 2:
						studentService.outputStudent();
						break;
					case 3:
						subjectService.createSubject();
						break;
					case 4:
						subjectService.outputSubject();
						break;
					case 5:
						markSubject.createMark();
						break;
					case 6:
						markSubject.outputMark();
						break;
					case 7:
						markSubject.sortByNameStudent();
						break;
					case 8:
						markSubject.sortByNameSubject();
						break;
					}
				}
				System.out.println("Khong co chuc nang vua nhap, moi nhap lai!");
			} catch (InputMismatchException e) {
				System.out.println("chuc nang phai la 1 so nguyen");
			}
		} while (true);
	}
}
