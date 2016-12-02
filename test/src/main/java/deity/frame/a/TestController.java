package deity.frame.a;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.util.JSONView;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/test")
public class TestController extends GlobalDefaultExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/call_page")
	public String callPage(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("title", "페이지호출");
		
		return "/test/call_page";
	}
	
	/**
	 * get에 form이 필요 있나 싶다.
	 * @param locale
	 * @param model
	 * @param request
	 * @param search
	 * @return
	 */
	@RequestMapping(value="/get_form")
	public String getFormPage(Locale locale, Model model,HttpServletRequest request,
			@RequestParam(value="search_name",required=false) String search) {
		
		model.addAttribute("contextPath", request.getContextPath());
		
		@SuppressWarnings("unchecked")
		Map<String,String> paramMap = request.getParameterMap();
		
		Iterator<String> it = paramMap.keySet().iterator();
		if(it.hasNext()){
			String param = it.next();
			
			model.addAttribute(param, request.getParameter(param));	
		}
		model.addAttribute("title", "get_form");
		
		return "/test/get_form";
	}	
	
	/**
	 * post단에는 vo와 함께 @ModelAttribute를 쓰는게 효과적이다.
	 * 
	 * @param vo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/post_form")
	public ModelAndView postFormPage(@ModelAttribute("vo") MenuVo vo, Model model,HttpServletRequest request) {
		
		model.addAttribute("contextPath", request.getContextPath()); //왜 모델을 쓰는걸까? 그냥 modelAndView에 넣으면 될것 같은데...
		ModelAndView modelAndView = new ModelAndView("/test/post_form");
		modelAndView.addObject("menu",vo);
		modelAndView.addObject("title", "post_form");
		
		return modelAndView;
	}
	
	/**
	 * @Valid를 쓰기위해서는 view단은 spring form을 써야하고,
	 * pom.xml에 디펜던시로 hibernate-validator를 추가해야한다.
	 * 
	 * @param user
	 * @param result
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/post_spring")
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
	
	@RequestMapping(value="/get_ajax")
	public String ajaxGetPage(Model model,HttpServletRequest request) {
		
		model.addAttribute("contextPath", request.getContextPath()); //왜 모델을 쓰는걸까? 그냥 modelAndView에 넣으면 될것 같은데...
		model.addAttribute("title", "get_ajax");
		
		return "/test/get_ajax";
	}
	
	
	
	/**
	 * json으로 어떻게 리졸버를 만드느냐가 관건이네?
	 * object를 ajax로 내려야지 받아볼수 있다.
	 */
	@RequestMapping(value="/ajax_get_object")
	public ModelAndView ajaxGet_Object(Model model,HttpServletRequest request,
			@RequestParam(value="search",required=false) String search) {
		
		ModelAndView modelAndView = new ModelAndView(new JSONView());
		JSONObject jsonObject;//리스트는 JSONList를 쓰면 되는듯?
		MenuVo menuVO = new MenuVo();
		menuVO.setMenuId("1");
		jsonObject = JSONObject.fromObject(JSONObject.fromObject(menuVO));
		modelAndView = new ModelAndView(new JSONView());
		modelAndView.addObject("ajax", jsonObject);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/ajax_get_list")
	public ModelAndView ajaxGet_List(Model model,HttpServletRequest request,
			@RequestParam(value="search",required=false) String search) {
		
		ModelAndView modelAndView = new ModelAndView(new JSONView());
		JSONArray jsonArray = new JSONArray();
		List<User> treeList = new ArrayList<User>();
		jsonArray = JSONArray.fromObject(treeList);
		modelAndView = new ModelAndView(new JSONView());
		modelAndView.addObject("ajax", jsonArray);
		
		return modelAndView;
	}
	
	/**
	 * 자동으로 XML과 JSON으로 변환은 되지만 List는 어떻게 내려야하지?
	 * VO를 일일이 입력하는 것보다는 범위로 스캔하는것은 없나?
	 * @param mapVO
	 * @param md
	 * @return
	 */
	@RequestMapping(value = "/map/info")
	public String goToInfo(@ModelAttribute("mapVO") MapVO mapVO, Model md){
	 
	    return "/map/info";
	}
	
	/**
	 * json은 따로 설정을 안해도 되는데, XML을 위해서는 VO에 XML을 위한 설정을, servlet-context에는 VO를 등록해야한다.
	 * @param user
	 * @param md
	 * @return
	 */
	@RequestMapping(value = "/user/info")
	public String getMashaling(User user, Model md){
		user.setUserId("11");
	    return "/map/info";
	}
	
	/**
	 * XML은 데이터가 나오지 않는다.
	 * @param userinfo
	 * @param md
	 * @return
	 */
	@RequestMapping(value = "/user/list")
	public String getMashalinList(User userinfo, Model md){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUserId("1");
		
		User user2 = new User();
		user2.setUserId("2");
		
		list.add(user);
		list.add(user2);
		md.addAttribute("list", list);
		
	    return "/map/info";
	}
	
	/**
	 * XML도 데이터가 나오기는 하는데 하이라키 구조가 이상하게 나온다.
	 * 원래 XML은 저렇게 나오나 보다.... 쩝
	 * @param mapVO
	 * @param md
	 * @return
	 */
	@RequestMapping(value = "/user/list2")
	public String getMashalinList2(MapVO mapVO, Model md){
		List<User> list = new ArrayList<User>();
		User user = new User();
		user.setUserId("1");
		
		User user2 = new User();
		user2.setUserId("2");
		
		list.add(user);
		list.add(user2);
		mapVO.setUserList(list);
		
	    return "/map/info";
	}
	
	@RequestMapping("/error_check")
	public String myInfo(@RequestParam(value="id") String id, Model model) throws Exception {
		if ("1".equals(id)) {
		    throw new SQLException();
		}else if ("2".equals(id)) {
		    throw new FileNotFoundException("File not found.");
		}else if ("3".equals(id)) {
		    throw new IOException("Found IO Exception");
		}else {
			model.addAttribute("msg", "Welcome to My World.");
		}
	    return "success";
	}
}
