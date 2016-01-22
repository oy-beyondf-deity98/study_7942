package lab.spring.jpa.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	String body(){
		return "test/test";
	}
	
	/**
	 * 반응형 채팅UI
	 * @return
	 */
	@RequestMapping("test/chat")
	String chat(){
		return "test/chat/chat";
	}
	
	@RequestMapping("test/chat_back")
	String chat2(){
		return "test/chat/chat_back";
	}	
	
	@RequestMapping("test/dragdrop")
	String drag(){
		return "test/dragdrop/test";
	}
	
	@RequestMapping("test/dragdrop/file")
	String dragFile(){
		return "test/dragdrop/file";
	}
	
	@RequestMapping("test/dragdrop/file2")
	String dragFile2(){
		return "test/dragdrop/file2";
	}	
	
	@RequestMapping("test/dragdrop/file3")
	String dragFile3(){
		return "test/dragdrop/file3";
	}
	
	
}
