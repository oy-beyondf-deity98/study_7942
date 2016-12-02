package deity.frame.first.admin.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.first.admin.menu.MenuDAO;
import deity.frame.first.admin.user.UserDAO;
import deity.frame.first.common.Navi;
import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Auth;
import deity.frame.first.domain.User;

@Controller
@RequestMapping("/admin/auth")
public class AuthController {
	ModelAndView modelAndView;

	@Autowired
	private AuthDAO authDAO;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	private MenuDAO menuDAO;	

	@RequestMapping("/auth_list")
	public ModelAndView list(@ModelAttribute SearchVo search) {

		search.pagingInit();
		List<Auth> authList = authDAO.list(search);
		modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/auth/auth_list");//url과 같으면 안너어도 자동으로 같은것을 넣는듯하다.
		modelAndView.addObject("list", authList);
		modelAndView.addObject("search", search.getSearch());

		String navi = new Navi(search).getPageNavi();
		modelAndView.addObject("navi", navi);
		return modelAndView;
	}

	@RequestMapping(value = "/auth_insert", method = RequestMethod.GET)
	public ModelAndView insert_pg(@ModelAttribute Auth auth, BindingResult result, HttpSession session) {

		modelAndView = new ModelAndView("/admin/auth/auth_insert");

		return modelAndView;
	}

	@RequestMapping(value = "/auth_insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute @Valid Auth auth, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {

			System.out.println("오류발생");
		} else {

			String user_id = session.getAttribute("user_id").toString();
			auth.setCreate_user(user_id);
			auth.setUpdate_user(user_id);
			authDAO.insert(auth);

			modelAndView = new ModelAndView("redirect:/admin/auth/auth_list");
		}
		return modelAndView;
	}

	@RequestMapping("get_auth")
	public ModelAndView getAuth(@RequestParam String auth_id) {
		Auth auth = new Auth();
		auth = authDAO.get(auth_id);

		
		modelAndView = new ModelAndView();
		modelAndView.addObject(auth);

		return modelAndView;

	}

	@RequestMapping(value = "/auth_update", method = RequestMethod.GET)
	public ModelAndView update_pg(@RequestParam String auth_seq) {
		Auth auth = new Auth();
		auth = authDAO.get(auth_seq);
		modelAndView = new ModelAndView("/admin/auth/auth_update");
		modelAndView.addObject(auth);
		return modelAndView;
	}

	@RequestMapping(value = "/auth_update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Valid Auth auth, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("오류발생");
		}

		String user_id = session.getAttribute("user_id").toString();
		auth.setUpdate_user(user_id);

		authDAO.update(auth);

		//컨트롤러에서 컨트롤러로 호출하기위해서 RedirectView를 쓴다.
		//setViewName("musicads_story");는 화면 이동일뿐이다.

		modelAndView = new ModelAndView("redirect:/admin/auth/auth_list");

		return modelAndView;
	}

	@RequestMapping("/auth_delete")
	public ModelAndView delete(@ModelAttribute Auth auth) {
		List<Map<String,String>> grantAuthUser = authDAO.grantAuthUser(auth.getAuth_seq_str());
		List<Map<String,String>> authObjectMenu = authDAO.authObjectMenu(auth.getAuth_seq_str());
		
		modelAndView = new ModelAndView();
		if(grantAuthUser.size() == 0 && authObjectMenu.size() == 0){
			int cnt = authDAO.delete(auth.getAuth_seq_str());
			
			modelAndView.addObject("cnt", cnt);	
		}else{
			modelAndView.addObject("cnt", -1);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add_user", method = RequestMethod.GET)
	public ModelAndView addUser_pg(@RequestParam String auth_seq) {
		List<User> authObjectUser = userDAO.authObjectUser(auth_seq);
		List<Map<String,String>> grantAuthUser = authDAO.grantAuthUser(auth_seq);
		modelAndView = new ModelAndView("/admin/auth/add_user");
		modelAndView.addObject("auth_seq",auth_seq);
		modelAndView.addObject("auth_object_user",authObjectUser);
		modelAndView.addObject("grant_auth_user",grantAuthUser);
		
		return modelAndView;
	}

	@RequestMapping(value = "/add_user", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam String auth_seq, @RequestParam(value="grant_user[]",required=false) String[] grant_user ,HttpSession session) {
		//TODO 왜 'grant_user'가 아니라 'grant_user[]'로 해야하는가?
		String user_id = session.getAttribute("user_id").toString();
		
		

		authDAO.deleteAuthUser(auth_seq);
		
		if(grant_user == null){
		}else{
			
			Map<String,String> map = new HashMap<String,String>();
			map.put("auth_seq", auth_seq);
			map.put("create_user", user_id);
			map.put("update_user", user_id);
			
			for(int i =0;i< grant_user.length;i++){
				map.put("user_id", grant_user[i]);
				authDAO.insertAuthUser(map);
			}	
		}
		

		return modelAndView;
	}	
	
	@RequestMapping(value = "/add_menu", method = RequestMethod.GET)
	public ModelAndView addMenu_pg(@RequestParam String auth_seq) {
		
		List<Map<String,String>> authMenuList = menuDAO.authMenuList(auth_seq);
		List<Map<String,String>> authObjectMenu = authDAO.authObjectMenu(auth_seq);
		modelAndView = new ModelAndView("/admin/auth/add_menu");
		modelAndView.addObject("auth_seq",auth_seq);
		modelAndView.addObject("auth_menu_list",authMenuList);
		modelAndView.addObject("auth_object_menu",authObjectMenu);		
		return modelAndView;
	}

	@RequestMapping(value = "/add_menu", method = RequestMethod.POST)
	public ModelAndView addMenu(@RequestParam String auth_seq, @RequestParam(value="object_menu[]",required=false) String[] object_menu, HttpSession session) {

		String user_id = session.getAttribute("user_id").toString();
		
		authDAO.deleteAuthMenu(auth_seq);
		
		if(object_menu == null){
		}else{
			Map<String,String> map = new HashMap<String,String>();
			map.put("auth_seq", auth_seq);
			map.put("create_user", user_id);
			map.put("update_user", user_id);
			
			for(int i =0;i<object_menu.length;i++){
//				System.out.println("object_menu :"+object_menu[i]);
				map.put("menu_seq", object_menu[i]);
				authDAO.insertAuthMenu(map);
			}	
		}

		return modelAndView;
	}		

}
