package Managefacultysalaries.entity;

import java.util.Arrays;

public class Teaching {
	private Teacher teachers;
	private Subject[] subjects;
	private int[] quantity;
	public Teacher getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}
	public Subject[] getSubjects() {
		return subjects;
	}
	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}
	public int[] getQuantity() {
		return quantity;
	}
	public void setQuantity(int[] quantity) {
		this.quantity = quantity;
	}
	public Teaching() {
		super();
	}
	public Teaching(Teacher teachers, Subject[] subjects, int[] quantity) {
		super();
		this.teachers = teachers;
		this.subjects = subjects;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Teaching{" +"Teacher=" + teachers +
                ", Subject=" + Arrays.toString(subjects) +
                ", Quantity=" + Arrays.toString(quantity) +
                "}";
	}
}
