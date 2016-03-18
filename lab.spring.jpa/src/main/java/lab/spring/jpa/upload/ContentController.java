package lab.spring.jpa.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

	@RequestMapping("/test/html_editor")
	public String page(){
		
		return "test/html_editor";
	}
}
