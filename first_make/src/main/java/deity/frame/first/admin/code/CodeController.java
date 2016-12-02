package deity.frame.first.admin.code;

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

import deity.frame.first.common.Navi;
import deity.frame.first.common.SearchVo;
import deity.frame.first.domain.Code;

@Controller
@RequestMapping("/admin/code")
public class CodeController {
	ModelAndView modelAndView;

	@Autowired
	private CodeDAO codeDAO;

	@RequestMapping("/code_list")
	public ModelAndView list(@ModelAttribute SearchVo search) {

		List<Code> codeList = codeDAO.list(search);
		modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/code/code_list");//url과 같으면 안너어도 자동으로 같은것을 넣는듯하다.
		modelAndView.addObject("list", codeList);
		modelAndView.addObject("search", search.getSearch());

		String navi = new Navi(search).getPageNavi();
		modelAndView.addObject("navi", navi);
		return modelAndView;
	}

	@RequestMapping(value = "/code_insert", method = RequestMethod.GET)
	public ModelAndView insert_pg(@ModelAttribute Code code, BindingResult result, HttpSession session) {

		modelAndView = new ModelAndView("/admin/code/code_insert");

		return modelAndView;
	}

	@RequestMapping(value = "/code_insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute @Valid Code code, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {

			System.out.println("오류발생");
		} else {
			String code_id = code.getCode();

			Code findCode = new Code();
			findCode = codeDAO.get(code_id);
			if (findCode == null) {
				String user_id = session.getAttribute("user_id").toString();
				code.setIs_use(true);
				code.setCreate_user(user_id);
				code.setUpdate_user(user_id);
				codeDAO.insert(code);

				modelAndView = new ModelAndView("redirect:/admin/code/code_list");

			} else {

				//메세지 코드 등록, 다른것을 찾다가 아래 코드를 찾게 된단다.
				result.rejectValue("code", "field.unique.constraint", null, "이미 존재하는 코드입니다.");
//				ObjectError error = new ObjectError("code", "이미있는 아이디입니다.");
//				result.addError(error);
			}

		}
		return modelAndView;
	}

	@RequestMapping("get_code")
	public ModelAndView getCode(@RequestParam String code) {
		Code codeVo = new Code();
		codeVo = codeDAO.get(code);

		modelAndView = new ModelAndView();
		modelAndView.addObject(codeVo);

		return modelAndView;

	}

	@RequestMapping(value = "/code_update", method = RequestMethod.GET)
	public ModelAndView update_pg(@RequestParam String code) {
		Code codeVo = new Code();
		codeVo = codeDAO.get(code);
		modelAndView = new ModelAndView("/admin/code/code_update");
		modelAndView.addObject(codeVo);
		return modelAndView;
	}

	@RequestMapping(value = "/code_update", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute @Valid Code code, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			System.out.println("오류발생");
		}else{
			String user_id = session.getAttribute("user_id").toString();
			code.setUpdate_user(user_id);

			codeDAO.update(code);

			modelAndView = new ModelAndView("redirect:/admin/code/code_list");						
		}
		return modelAndView;

	}

	@RequestMapping("/code_delete")
	public ModelAndView delete(@ModelAttribute Code code) {
		Map<String,String> ableDeleteCode = new HashMap<String,String>();
		ableDeleteCode = codeDAO.ableDeleteCode(code.getCode());
		
		modelAndView = new ModelAndView();
		
		System.out.println(ableDeleteCode);
		if (ableDeleteCode == null) {

			int cnt = codeDAO.delete(code.getCode());
			
			modelAndView.addObject("cnt", cnt);
			modelAndView.addObject("ableDelete", "Y");
			
			
		}else{
			modelAndView.addObject("ableDelete", 'N');
		}
		

		return modelAndView;	
	}
	

}
