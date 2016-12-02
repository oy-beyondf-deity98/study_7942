package deity.frame.first;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/test/post_spring")
	public ModelAndView springPostPage(@ModelAttribute @Valid  User user,BindingResult result, Model model,HttpServletRequest request) {
		if(result.hasErrors()){
			System.out.println("오류발생");
		}
		
		model.addAttribute("contextPath", request.getContextPath()); //왜 모델을 쓰는걸까? 그냥 modelAndView에 넣으면 될것 같은데...
		ModelAndView modelAndView = new ModelAndView("/test/post_spring");
		modelAndView.addObject("user",user);
		modelAndView.addObject("title", "post_spring");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/test/user/list")
	public String getMashalinList(User userinfo, Model md){
		List<User> list = new ArrayList<User>();
		System.out.println("xxxxx");
		User user = new User();
		user.setUserId("1");
		
		User user2 = new User();
		user2.setUserId("2");
		
		list.add(user);
		list.add(user2);
		md.addAttribute("list", list);
		
	    return "/test/user";
	}
	
	@RequestMapping(value = "/test/drag")
	public String dragAndDrop(){
		
		
	    return "/test/drag";
	}
	
}
