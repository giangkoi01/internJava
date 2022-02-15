package busassignmentmanagement.util.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import busassignmentmanagement.util.StringUtil;

public class FileUtil implements DataReadable,DataWritable{

	@Override
	public <T> void writeDataToFile(List<T> data, String fileName) {
		if (StringUtil.isNullOrEmpty(fileName) || data.isEmpty()) {
            return;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Object readDataFromFile(String fileName) {
		if (StringUtil.isNullOrEmpty(fileName)) {
            return null;
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
	}


}
