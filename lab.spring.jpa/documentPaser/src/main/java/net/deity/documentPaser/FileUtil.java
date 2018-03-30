package net.deity.documentPaser;

/**
 * 특정디렉토리의 파일내요을 읽기 위한 용도
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	private List<String> list = new ArrayList<String>();
	
	public FileUtil(){
		
	}
	
	public FileUtil(String path) throws IOException{
		setFileList(path);
	}
	
	public FileUtil setFileList(String path) throws IOException {
		
		File file = new File(path);
		
		if(file.exists()){
			for(File i : file.listFiles()){
				if(i.isDirectory()){
					setFileList(i.getAbsolutePath());
				}else{
					list.add(i.getAbsolutePath());
				}
			}
		}
		
		return this;
	}
	
	public FileUtil filterExt(String filterExt){
		
		
		List<String> fileList = new ArrayList<String>();
		for (String file : list) {
			int idx = file.lastIndexOf(".");
			String fileExt = file.substring(idx+1);
			
			if(filterExt.equals(fileExt)){
				fileList.add(file);
			}
		}
		
		list = fileList;
		return this;
		
	}
	

	
	public List<String> getFilesAll(){
		return list;
	}
	
	public List<String> getFileContent(int i) throws IOException{
		List<String> fileContent = new ArrayList<String>();
		if(i> list.size()) i= list.size();
		String strFile = list.get(i);
		System.out.println("read file :" + strFile);
		BufferedReader br = new BufferedReader(new FileReader(strFile));
		while(true){
			String line = br.readLine();
            if (line==null) break;
            fileContent.add(line);
		}
		br.close();
		
		return fileContent;
		
	}

	@Override
	public String toString() {
		return "FileUtil [list=" + list + "]";
	}
	
	
}
