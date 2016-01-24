package com.vertexid.hdt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "home";
	}
	
	@RequestMapping(value = "/main")
	public String main(Locale locale, Model model,HttpSession session) {
		logger.info("Main page.");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
		return "main";
	}	

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		return "1";
	}
	

	@RequestMapping(value = "/login/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)session.getAttribute("userLoginInfo");
		
		logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());
		
		session.invalidate();
		//TODO 리다이렉트로 바꿀것.
		//외부에서는 hdt가 붙고.. 내부에서는 안붙는것은 문제가 있다. 어떻게 할지 알아보자.
		return "redirect:/hdt";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/login/login", method = RequestMethod.GET)
	public void login(HttpSession session) {
		logger.info("Welcome login! {}", session.getId());
	}
	
	
	
	@RequestMapping(value = "/login/login_success", method = RequestMethod.GET)
	public void login_success(HttpSession session) {
		CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
		session.setAttribute("userLoginInfo", userDetails);
	}
	
	@RequestMapping(value = "page1", method = RequestMethod.GET)
	public void page1() {		
	}
	
	@RequestMapping(value = "/login/login_duplicate", method = RequestMethod.GET)
	public void login_duplicate() {
		logger.info("Welcome login_duplicate!");
	}
	
}
