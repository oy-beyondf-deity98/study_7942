package deity.frame.first.admin.menu;

import java.util.List;

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

import deity.frame.first.common.JSONView;
import deity.frame.first.common.Navi;
import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Menu;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {
	ModelAndView modelAndView;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@RequestMapping("/menu_list")
	public ModelAndView list(@ModelAttribute SearchVo search) {
	
		search.pagingInit();
		List<Menu> menuList = menuDAO.list(search);
		modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/menu/menu_list");//url과 같으면 안너어도 자동으로 같은것을 넣는듯하다.
		modelAndView.addObject("list", menuList);
		modelAndView.addObject("search", search.getSearch());
	
		String navi = new Navi(search).getPageNavi();
		modelAndView.addObject("navi", navi);
		return modelAndView;
	}
	
	@RequestMapping(value = "/menu_insert", method = RequestMethod.GET)
	public ModelAndView insert_pg(@ModelAttribute Menu menu, BindingResult result, HttpSession session) {
	
		modelAndView = new ModelAndView("/admin/menu/menu_insert");
	
		return modelAndView;
	}
	
	@RequestMapping(value = "/menu_insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute @Valid Menu menu, BindingResult result, HttpSession session) {
	
		if (result.hasErrors()) {
	
			System.out.println("오류발생");
		} else {
			
			String user_id = session.getAttribute("user_id").toString();
			menu.setCreate_user(user_id);
			menu.setUpdate_user(user_id);
			menuDAO.insert(menu);

			modelAndView = new ModelAndView("redirect:/admin/menu/menu_list");
	
			
		}
		return modelAndView;
	}
	
	@RequestMapping("get_menu")
	public ModelAndView getMenu(@RequestParam String menu_id) {
		Menu menu = new Menu();
		menu = menuDAO.get(menu_id);
	
		modelAndView = new ModelAndView();
		modelAndView.addObject(menu);
	
		return modelAndView;
	
	}
	
	@RequestMapping(value = "/menu_update", method = RequestMethod.GET)
	public ModelAndView update_pg(@RequestParam String menu_seq) {
		
		Menu menu = new Menu();
		menu = menuDAO.get(menu_seq);
		modelAndView = new ModelAndView("/admin/menu/menu_update");
		modelAndView.addObject(menu);
		return modelAndView;
	}
	
	@RequestMapping(value = "/menu_update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Valid Menu menu, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("오류발생");
		}
	
		String user_id = session.getAttribute("user_id").toString();
		menu.setUpdate_user(user_id);
	
		menuDAO.update(menu);
		modelAndView = new ModelAndView("redirect:/admin/menu/menu_list");
	
		return modelAndView;
	}
	
	@RequestMapping("/menu_delete")
	public ModelAndView delete(@ModelAttribute Menu menu) {
		int cnt = menuDAO.delete(menu.getMenu_str());
		modelAndView = new ModelAndView();
		modelAndView.addObject("cnt", cnt);
		return modelAndView;
	
	}
	
	@RequestMapping("/menu_tree")
	public ModelAndView menuTree(){
		List<?> treeList = menuDAO.getTreeMenu();
		JSONArray jsonArray = JSONArray.fromObject(treeList);
		modelAndView = new ModelAndView(new JSONView());
		modelAndView.addObject("ajax",jsonArray);
		
		return modelAndView;
	}
	
}
