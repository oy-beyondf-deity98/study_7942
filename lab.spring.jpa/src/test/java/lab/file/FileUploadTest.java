package lab.file;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileUploadTest {
	
	String path="C:/Users/deity/Desktop/test/";
	
	public void test() throws IOException{
		FileOutputStream output = new FileOutputStream("C:/Users/deity/Desktop/out.txt");
		
		
		for(int i=1; i<11; i++) {
            String data = i+" 번째 줄입니다./r/n";
            output.write(data.getBytes());
        }
        output.close();
		
	}
	
	@Before
	public void set() throws IOException{
		
        
		
		File f = new File(path);
        
		if(f.isAbsolute()) f.mkdir();
        File f2 = new File(path+"test");
        if(f2.isAbsolute()) f2.mkdir();
		
        
		FileOutputStream output = new FileOutputStream(path+"out.txt");
		
		for(int i=1; i<11; i++) {
            String data = i+" 번째 줄입니다./r/n";
            output.write(data.getBytes());
        }
        output.close();
        
        
        FileOutputStream output2 = new FileOutputStream(f2.getAbsoluteFile()+"/out2.txt");
        
        output2.close();
	}
	
	@Test
	public void testRead() throws IOException{
		
		List<String> listFile = new ArrayList<String>();
		
		FileUtil fUtil = new FileUtil();//static로 만들어야할듯
		listFile = fUtil.setFileList(path).getFilesAll();
		
		assertEquals(listFile.size(), 2);
		
	}
	
	@After
	public void end() throws IOException{
		List<String> listFile = new ArrayList<String>();
		
		FileUtil fUtil = new FileUtil();//static로 만들어야할듯
		listFile = fUtil.setFileList(path).getFilesAll();
		
		for(String s : listFile){
			File f = new File(s);
			f.deleteOnExit();
		}
		
		File endFolder = new File(path);
		//폴더자체를 지워야하는데...안된다.
		endFolder.deleteOnExit();
		
		
	}


	

}
