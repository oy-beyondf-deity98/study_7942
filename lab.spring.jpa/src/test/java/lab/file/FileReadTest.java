package lab.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class FileReadTest {

	@Test
	public void test() throws IOException {
		
		
		List<String> list = new ArrayList<String>();
		String path = "/Users/deity/Documents";
		FileUtil file = new FileUtil();
		file.setFileList(path);
		
	    System.out.println(file.toString());
		
		Random random = new Random();
		int i = random.nextInt(file.getFilesAll().size());
		System.out.println(i);
		
		list = file.getFileContent(i);
		
		
		for (String data : list) {
			System.out.println(data);
		}
		
		System.out.println("test");
	}
	
	@Test
	public void test특정확장자만() throws IOException{
		List<String> list = new ArrayList<String>();
		String path = "C:/Users/deity/workspace/lab.spring.jpa/src/main/webapp/WEB-INF/file";
		FileUtil file = new FileUtil();
		file.setFileList(path).filterExt("txt");
	}
	

}
