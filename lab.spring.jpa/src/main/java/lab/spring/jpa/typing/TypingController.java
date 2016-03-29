package lab.spring.jpa.typing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lab.file.FileUtil;

/**
 * json형태여야지 json으로 돌려주나보다. 편리하긴 하네.
 * @author deity
 *
 */
@Controller
public class TypingController {
	@Autowired MemoRepository repository;
	
	
	List<String> list = new ArrayList<String>();
	
	@RequestMapping("chat/typing") //chat/typing
	@ResponseBody
	public String chattype() throws IOException{
		JSONObject json = new JSONObject();
		
		json = typingData();
		
		
		return json.toJSONString();
	}
	
	private JSONObject typingData() throws IOException{
		
		//파일위치는 변할수 있다.
		//파일중에서 txt인것만 추릴수 있었으면 좋겠다.
		String path = "/Users/kimgyupyo/Documents/myapp/workspace/study_7942/lab.spring.jpa/src/main/webapp/upload";
		FileUtil file = new FileUtil();
		
		file.setFileList(path).filterExt("txt");
		
		Random random = new Random();
		int i = random.nextInt(file.getFilesAll().size());
		
		list = file.getFileContent(i);
		
		JSONArray array = new JSONArray();
		
		for (String data : list) {
			
			//특수문자 제거
			String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z.,;:*~`!\\/\\/\\{\\}\\[\\]\\?\\|\\(\\)\\s]";
			data = data.replaceAll(match, "");
			
			//공백 또는 탭문자이 2개이상일경우에는 2개이상일때는 한개로 사용한다.
			String match2 = "\\s{2,}";
			data = data.replaceAll(match2, " ");
			
			StringTokenizer tokens = new StringTokenizer(data,"[\\.\\,]",true);
			
			if(tokens.countTokens() > 0){
				while(tokens.hasMoreTokens()){
					String token = tokens.nextToken();

					if(token.length() >3){
						array.add(token.trim());
					}	
				}	
			}else{
				if(data.length() > 3){
					array.add(data.trim());	
				}	
			}
			
		}
		
		JSONObject json = new JSONObject();
		
		json.put("data", array);
		
		return json;
		
	}
	
	@RequestMapping("/input/memo")
	@ResponseBody
	public String memoInput(@RequestParam String input_memo) throws IOException{
		System.out.println(input_memo);
		Memo memo = new Memo();
		memo.setMemo(input_memo);
		repository.save(memo);
		
		return "";
	}
	
	@RequestMapping("chat")
	String chat(){
		return "chat";
	}	
	
	@RequestMapping("typing")
	String typing(){
		
		return "typing";
	}
	
	@RequestMapping("/memo")
	String memoPage(){
		return "memo";
	}
}
