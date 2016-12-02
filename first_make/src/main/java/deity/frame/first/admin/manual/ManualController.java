package deity.frame.first.admin.manual;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.first.common.Navi;
import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Manual;

public class ManualController {

	ModelAndView modelAndView;

	@Autowired
	private ManualDAO manualDAO;

	@RequestMapping("/manual_list")
	public ModelAndView list(@ModelAttribute SearchVo search) {

		search.pagingInit();
		List<Manual> manualList = manualDAO.list(search);
		modelAndView = new ModelAndView();
		modelAndView.setViewName("/메인URL/manual_list");//url과 같으면 안너어도 자동으로 같은것을 넣는듯하다.
		modelAndView.addObject("list", manualList);
		modelAndView.addObject("search", search.getSearch());

		String navi = new Navi(search).getPageNavi();
		modelAndView.addObject("navi", navi);
		return modelAndView;
	}

	@RequestMapping(value = "/manual_insert", method = RequestMethod.GET)
	public ModelAndView insert_pg(@ModelAttribute Manual manual, BindingResult result, HttpSession session) {

		modelAndView = new ModelAndView("/메인URL/manual_insert");

		return modelAndView;
	}

	@RequestMapping(value = "/manual_insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute @Valid Manual manual, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {

			System.out.println("오류발생");
		} else {
			String manual_seq = manual.getManual_seq_str();

			Manual findManual = new Manual();
			findManual = manualDAO.get(manual_seq);
			if (findManual == null) {
				String user_id = session.getAttribute("user_id").toString();
				manual.setCreate_user(user_id);
				manual.setUpdate_user(user_id);
				manualDAO.insert(manual);

				modelAndView = new ModelAndView("redirect:/메인URL/manual_list");

			} else {

				//메세지 코드 등록, 다른것을 찾다가 아래 코드를 찾게 된단다.
				result.rejectValue("manual_id", "field.unique.constraint", null, "이미 존재 합니다.");
				ObjectError error = new ObjectError("manual_id", "이미있는 아이디입니다.");
				result.addError(error);
			}

		}
		return modelAndView;
	}

	@RequestMapping("get_manual")
	public ModelAndView getManual(@RequestParam String manual_id) {
		Manual manual = new Manual();
		manual = manualDAO.get(manual_id);

		modelAndView = new ModelAndView();
		modelAndView.addObject(manual);

		return modelAndView;

	}

	@RequestMapping(value = "/manual_update", method = RequestMethod.GET)
	public ModelAndView update_pg(@RequestParam String manual_id) {
		Manual manual = new Manual();
		manual = manualDAO.get(manual_id);
		modelAndView = new ModelAndView("/메인URL/manual_update");
		modelAndView.addObject(manual);
		return modelAndView;
	}

	@RequestMapping(value = "/manual_update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Valid Manual manual, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("오류발생");
		}

		String user_id = session.getAttribute("user_id").toString();
		manual.setUpdate_user(user_id);

		manualDAO.update(manual);

		//컨트롤러에서 컨트롤러로 호출하기위해서 RedirectView를 쓴다.
		//setViewName("musicads_story");는 화면 이동일뿐이다.

		modelAndView = new ModelAndView("redirect:/메인URL/manual_list");

		return modelAndView;
	}

	@RequestMapping("/manual_delete")
	public ModelAndView delete(@ModelAttribute Manual manual) {
		int cnt = manualDAO.delete(manual.getManual_seq_str());
		modelAndView = new ModelAndView();
		modelAndView.addObject("cnt", cnt);
		return modelAndView;

	}
}
