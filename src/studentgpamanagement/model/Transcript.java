package studentgpamanagement.model;

import java.io.Serializable;
import java.util.Arrays;

public class Transcript implements Serializable{
	private static final long serialVersionUID = 1L;
	private Student student;
	private Subject[] subjects;
	private int[] poins;
	
	public Transcript(Student student, Subject[] subjects, int[] poins) {
		super();
		this.student = student;
		this.subjects = subjects;
		this.poins = poins;
	}

	public Transcript() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}

	public int[] getPoins() {
		return poins;
	}

	public void setPoins(int[] poins) {
		this.poins = poins;
	}

	@Override
	public String toString() {
		return "Transcript{" +"Student=" + student +
                ", Subject=" + Arrays.toString(subjects) +
                ", points=" + Arrays.toString(poins) +
                "}";
	}
}
