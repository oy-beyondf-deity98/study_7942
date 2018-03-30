package lab.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class TestText {
	private static String REG_SIGN_Character =  "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; //Regular Expression
	private static String REG_continueSpace ="\\s{2,}";
	/**
	 * @See FileUtil
	 * 파일을 읽이 위한 존재
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		
		String path = "/Users/deity/Documents/five.txt";
		File file = new File(path);
		
		List<Map<String,String>> fileList = new ArrayList<Map<String,String>>();
		
		if(file.exists()){
			System.out.println("파일이 존재합니다 :"+file.isFile());
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			String s;
			
			while ((s = br.readLine()) != null) {
				if(!StringUtils.isEmpty(s.trim())){
					Map<String,String> map = new HashMap<String,String>();
					String wordList[] = s.split(" ");
					
					for(String word:wordList){
						//TODO 명사만을 가져오게 한는 방법은?
						//나머지는 UI로 쉽게 옴길수 있게 하는게 나을것 같다. 스윙??? html을 사용할까?
						
						String strword =word.replaceAll(REG_SIGN_Character, "");
						String removeWordList[] = {"이다","는","한다","다"}; 
					    strword = strword.trim();
					    
					    for(String removeWord:removeWordList){
					    	strword =strword.replaceAll(removeWord+"$", "");
					    }
					    
					    if(!StringUtils.isEmpty(strword)){
					    	map.put("full", word);
					    	map.put("word", strword);	
					    }
					}
					
					fileList.add(map);	
				}
				
			}
			br.close();
			
			
		}
		
		System.out.println(fileList);
	}
	
	
	//출처: http://jang8584.tistory.com/97 [개발자의 길]
	//특수문자 제거 하기
	public static String StringReplace(String str){       
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str =str.replaceAll(match, " ");
		return str;
	}

	//이메일 유효성
	public static boolean isEmailPattern(String email){
		Pattern pattern=Pattern.compile("\\w+[@]\\w+\\.\\w+");
		Matcher match=pattern.matcher(email);
		return match.find();
	}

	//연속 스페이스 제거
	public static String continueSpaceRemove(String str){
		String match2 = "\\s{2,}";
		str = str.replaceAll(match2, " ");
		return str;
	}



}
