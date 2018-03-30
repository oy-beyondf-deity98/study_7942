package net.deity.documentPaser.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import net.deity.documentPaser.DocumentReader;
import net.deity.documentPaser.FileInfo;
import net.deity.documentPaser.FileUtil;

/**
 * 단어사전, 로컬에 있는 파일을 분석하여서 보여준다.
 * @author deity
 *
 */
public class WordParser {
	private static String REG_SIGN_Character =  "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]"; //Regular Expression
	private static String REG_continueSpace ="\\s{2,}";
	
	private List<Word> fileList = new ArrayList<Word>();
	
	public List<Word> getFileList() {
		return fileList;
	}
	
	public List<Word> paserDir(String path) throws IOException{
		FileUtil fUtil = new FileUtil(path);
		
		List<Word> list = new ArrayList<Word>();
		for(String filePath :fUtil.getFilesAll()){    
			FileInfo file = new FileInfo(new File(filePath));
			
			if(file.isExtractable()){
				DocumentReader fileReader = new DocumentReader();
				
				String data = fileReader.extractStringTextFromFileInfo(file);	
				
				WordParser paser = new WordParser();
				paser.paser(data);
				list.addAll(paser.getFileList());
			}
		}
		
		return list;
	}

	public void paser(List<String> list){
		for(String data:list){
			paser(data);
		}
	}
	
	public void paser(String data){
		String[] lineList = data.split("\n");//\n으로 스플릿하면 될듯하다.
		
		for(String line:lineList){
			String wordList[] = line.split(" ");
			
			for(String word:wordList){
				
				//TODO 명사만을 가져오게 한는 방법은?
				//나머지는 UI로 쉽게 옴길수 있게 하는게 나을것 같다. 스윙??? html을 사용할까?
				
				String[] regWordList =word.replaceAll(REG_SIGN_Character, " ").split(" ");
				
				for(String lastWord:regWordList){
					Word map = new Word();
					
					String removeWordList[] = {"이다","는","한다","다"}; 
					//유력한 단어를 추릴수도 있다.
					String removeLikeWordList[] = {"에게","은","의","에"};
					//외자도 추려서 골라낼수 있게 해줄수 있다.
					//한글과영문이 붙어있는경우 분리할수도 있다.
					//마지막자를 제거할수 있는것을 선택할수도 있다.
				    String strword = lastWord.trim();
				    for(String removeWord:removeWordList){
				    	strword =strword.replaceAll(removeWord+"$", "");
				    }
				    
				    if(!StringUtils.isEmpty(strword)){
				    	map.setFull(lastWord);
				    	map.setWord(strword);//단어, 주로 영문
				    	fileList.add(map);			
				    }
				    
				    		
				}

			}			
		}
		
	}
}
