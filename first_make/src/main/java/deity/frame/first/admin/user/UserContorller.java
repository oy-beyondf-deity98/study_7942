package deity.frame.first.admin.user;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.first.common.Navi;
import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.User;

@Controller
@RequestMapping("/admin/user")
public class UserContorller {
	ModelAndView modelAndView;
	
	@Autowired
    private UserDAO userDAO;
	
	@RequestMapping("/user_list")
//    public ModelAndView list(@RequestParam(value="search",required=false) String search) {
	public ModelAndView list(@ModelAttribute SearchVo search) {
		
		List<User> userList = userDAO.list(search);
        modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/user/user_list");//url과 같으면 안너어도 자동으로 같은것을 넣는듯하다.
        modelAndView.addObject("list",userList);
        modelAndView.addObject("search",search.getSearch());
        
        String navi = new Navi(search).getPageNavi();
        modelAndView.addObject("navi",navi);
        return modelAndView;
        
    }

	
	@RequestMapping(value="/user_insert",method=RequestMethod.GET)
    public ModelAndView insert_pg(@ModelAttribute User user,BindingResult result,HttpSession session) {
		
		modelAndView = new ModelAndView("/admin/user/user_insert");
		
        return modelAndView;
    }
	
	@RequestMapping(value="/user_insert",method=RequestMethod.POST)
    public ModelAndView insert(@ModelAttribute @Valid  User user,BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			
			System.out.println("오류발생");
		}else{
			String create_user_id = user.getUser_id();
			
			User findUser = new User();
			findUser = userDAO.get(create_user_id);
			if(findUser == null){
				
				String user_id = session.getAttribute("user_id").toString();
				
				user.setCreate_user(user_id);
				user.setUpdate_user(user_id);
		        userDAO.insert(user);
		        //redirect:/error.do
		        //modelAndView = new ModelAndView(new RedirectView("/first/admin/user/user_list"));	
		        modelAndView = new ModelAndView("redirect:/admin/user/user_list");	
			}else{
				//메세지 코드 등록, 다른것을 찾다가 아래 코드를 찾게 된단다.
				result.rejectValue("user_id", "field.unique.constraint", null, "이미 존재 합니다.");
				ObjectError error = new ObjectError("user_id","이미있는 아이디입니다.");
				result.addError(error);
			}
			
		}  
        return modelAndView;
    }
	
	@RequestMapping("get_user")
	public ModelAndView getUser(@RequestParam String user_id){
		User user = new User();
		user = userDAO.get(user_id);
		
		modelAndView = new ModelAndView();
		modelAndView.addObject(user);
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/user_update",method=RequestMethod.GET)
    public ModelAndView update_pg(@RequestParam String user_id) {
		User user = new User();
		user = userDAO.get(user_id);
        modelAndView = new ModelAndView("/admin/user/user_update");
        modelAndView.addObject(user);
        return modelAndView;
    }
	
	@RequestMapping(value="/user_update",method=RequestMethod.POST)
    public ModelAndView update(@ModelAttribute @Valid  User user,BindingResult result,HttpSession session) {
		if(result.hasErrors()){
			System.out.println("오류발생");
		}
		
		String user_id = session.getAttribute("user_id").toString();
		user.setUpdate_user(user_id);
        
		userDAO.update(user);
		
		//컨트롤러에서 컨트롤러로 호출하기위해서 RedirectView를 쓴다.
		//setViewName("musicads_story");는 화면 이동일뿐이다.
		
		modelAndView = new ModelAndView("redirect:/admin/user/user_list");
		
        return modelAndView;
    }
	
	@RequestMapping(value="/user_pwd_change",method=RequestMethod.POST)
	public ModelAndView updatePwd(@ModelAttribute User user,HttpSession session){

		String user_id = session.getAttribute("user_id").toString();
		user.setUpdate_user(user_id);
		userDAO.updateUserPwd(user);
		
		return modelAndView;
	}

	@RequestMapping("/user_delete")
    public ModelAndView delete(@ModelAttribute User user) {
		int cnt = userDAO.delete(user.getUser_id());
        modelAndView = new ModelAndView();
		modelAndView.addObject("cnt",cnt);
        return modelAndView;
        
    }
}