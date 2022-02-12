package studentgpamanagement;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import studentgpamanagement.model.Student;

public class WriteFile {
	public void writeStudentFile(Student[] students) {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("StudentList.txt", true))) {
            outputStream.writeObject(students);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
