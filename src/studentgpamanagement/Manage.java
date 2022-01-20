package studentgpamanagement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Manage {
	public static Student[] students;
	public static Subject[] subjects;
	public static Transcript[] transcripts;
	public static Scanner scanner = new Scanner(System.in);
	
	public void run() {
		while (true) {
			System.out.println("mời bạn chọn chức năng:");
			System.out.println("1.nhập sinh viên");
			System.out.println("2.in sinh viên");
			System.out.println("3.nhập môn học");
			System.out.println("4.in danh sách môn học");
			System.out.println("5.nhập điểm sinh viên");
			System.out.println("6.In điểm sinh viên");
			System.out.println("7.sắp xếp theo tên sinh viêm");
			System.out.println("8.sắp xếp theo tên môn học");
			boolean flag = true;
			do {
				flag = true;
				int chosse = 0;
				System.out.println("Chon chuc nang");
				chosse = scanner.nextInt();
				switch (chosse) {
				case 1:
					createStudent();
					writeStudentFile();
					break;
				case 2:
					outputStudent();
					break;
				case 3:
					createSubject();
					break;
				case 4:
					outputSubject();
					break;
				case 5:
					createMark();
					break;
				case 6:
					outputMark();
					break;
				case 7:
					sortByNameStudent();
					break;
				case 8:
					sortByNameSubject();
					break;
				default:
					System.out.println("Khong co chuc nang vua nhap, moi nhap lai!");
					flag = false;
					break;
				}
			} while (!flag);
		}
	}
	
	public void createStudent() {
		System.out.println("mời bạn nhập số lượng sinh viên:");
		int n = scanner.nextInt();
		students = new Student[n];
		for (int i = 0; i < n; i++) {
			Student student = new Student();
			student.input();
			students[i] = student;
		}
	}
	
	public void writeStudentFile() {
		try {
			try (ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream("./student.txt"))){
				if (students == null) {
					return;
				}
				for (Student student : students) {
					oops.writeObject(student);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outputStudent() {
		System.out.println("danh sách sinh viên:");
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
	public void createSubject() {
		System.out.println("mời bạn nhập số lượng môn");
		int n = scanner.nextInt();
		subjects = new Subject[n];
		for (int i = 0; i < n; i++) {
			Subject subject = new Subject();
			subject.input();
			subjects[i] = subject;
		}
	}
	
	public void outputSubject() {
		System.out.println("danh sách môn học :");
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
	}
	
	public Student searchStudent(int id) {
		for (Student student : students) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
	}
	
	public Subject searchSubject(int id) {
		for (Subject subject : subjects) {
			if(subject.getId() == id) {
				return subject;
			}
		}
		return null;
	}
	
	public void createMark() {
		int slsv, slmh, dsv, idsv, idmh;
		Student student;
		Subject subject;
		boolean flag = false;
		do {
			System.out.println("nhập số sinh viên cần nhập điểm");
			slsv = scanner.nextInt();
			if(slsv > students.length) {
				System.out.println("nhập lại số sinh viên cần nhập điểm");
				flag = true;
			}else {
				flag = false;
			}
		} while (flag);
		transcripts = new Transcript[slsv];
		
		for (int i = 0; i < slsv; i++) {
			do {
				System.out.println("nhập id sinh viên:");
				idsv = scanner.nextInt();
				student = searchStudent(idsv);
				if(student == null) {
					System.out.println("nhập lại id");
					flag = true;
				}else {
					flag = false;
				}
			} while (flag);
			do {
				System.out.println("nhập số môn học:");
				slmh = scanner.nextInt();
				if(slmh > subjects.length) {
					System.out.println("nhập lại số lượng môn học");
					flag = true;
				}else {
					flag = false;
				}
			} while (flag);
			
			Subject[] subjects = new Subject[slmh];
			int[] marks = new int[slmh];
			for (int j = 0; j < slmh; j++) {
				do {
					System.out.println("nhập id môn học:");
					idmh = scanner.nextInt();
					subject = searchSubject(idmh);
					if(subject == null) {
						System.out.println("nhập lại id môn học: ");
						flag = true;
					}else {
						flag = false;
					}
				} while (flag);
				System.out.println("nhập điểm:");
				dsv = scanner.nextInt();
				do {
					if(dsv < 0 || dsv > 10) {
						System.out.println("nhập lại điểm :");
						flag = true;
					}else {
						flag = false;
						subjects[j] = subject;
						marks[j] = dsv;
					}
				} while (flag);
			}
			Transcript transcript = new Transcript(student, subjects, marks);
			transcripts[i] = transcript;
		}
	}
	
	public void outputMark() {
		System.out.println("danh sách điểm sinh viên:");
		for (Transcript transcript : transcripts) {
			System.out.println(transcript);
		}
	}
	
	public void sortByNameStudent() {
		Transcript tam = new Transcript();
		for(int i = 0; i < transcripts.length-1; i++) {
			for (int j = i+1; j < transcripts.length; j++) {
				if(transcripts[i].getStudent().getName().compareTo(transcripts[j].getStudent().getName())>0) {
					tam = transcripts[i];
					transcripts[i] = transcripts[j];
					transcripts[j] = tam;
				}
			}
		}
		for (int i = 0; i < transcripts.length; i++) {
			System.out.println(transcripts[i]);
		}
	}
	
	public void sortByNameSubject() {
		Subject tam = new Subject();
		for (int i = 0; i < transcripts.length; i++) {
			for (int j = 0; j < transcripts[i].getSubjects().length-1; j++) {
				for (int j2 = j + 1; j2 < transcripts[i].getSubjects().length; j2++) {
					if(transcripts[i].getSubjects()[j].getName().compareTo(transcripts[i].getSubjects()[j2].getName())>0) {
						tam = transcripts[i].getSubjects()[j];
						transcripts[i].getSubjects()[j] = transcripts[i].getSubjects()[j2];
						transcripts[i].getSubjects()[j2] = tam;
					}
				}
			}
		}
		for (int i = 0; i < transcripts.length; i++) {
			System.out.println(transcripts[i]);
		}
	}
}
