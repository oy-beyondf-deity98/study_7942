package deity.frame.first.main.login;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.first.admin.menu.MenuDAO;
import deity.frame.first.domain.Menu;

@Controller
public class LoginController {
	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private MenuDAO menuDAO;
	
	
	ModelAndView modelAndView;
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView login_no_user(){
		modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/login/login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String user_id, @RequestParam String user_pwd,Model model, HttpSession session){
		modelAndView = new ModelAndView();
		
		Map<String,String> loginInfo = loginDAO.loginInfo(user_id, user_pwd);
		if(loginInfo == null){
			model.addAttribute("message", "등록되어있지 않는 아이디입니다.");
			modelAndView.setViewName("/login/login");
		}else{
			
			modelAndView.setViewName("/main/main");
			session.setAttribute("session", loginInfo);//TODO 화면에서 사용하기 위해서 session으로 넣었다.
			session.setAttribute("user_id",loginInfo.get("USER_ID"));//서버에서 사용하기 위해서..
			//session.setAttribute("user_nm", loginInfo.get("USER_NM"));
			List<Menu> menuList = menuDAO.topMenu(user_id);//TODO 하위메뉴가 두개이상있을때는 표현이 안되네...
			System.out.println(menuList);
			session.setAttribute("topMenu", menuList);
		}
		
		
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login/login";
	}	
}
