package studentgpamanagement.util.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import studentgpamanagement.util.DataUtil;
import studentgpamanagement.util.StringUtil;

public class FileUtil implements DataReadable,DataWriteable{

	@Override
	public void writeDataFromFile(Object[] data, String name) {
		if(StringUtil.isNullOrEmpty(name) || DataUtil.isNullOrEmpty(data)) {
			return;
		}
		
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(name))){
			objectOutputStream.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object readDataFromFile(String fileName) {
		if(StringUtil.isNullOrEmpty(fileName)) {
			return null;
		}
		
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
			return objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
