package deity.frame.a;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends GlobalPopupExceptionHandler{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/error_pop")
	public String errorPopup(@RequestParam(value="id") String id, Model model) throws Exception {
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
	
	/**
	 * 에러페이지 띄우는건 실패!
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/error_page")
	public String errorPage(Model model) throws Exception {
		
	    return "/test/error_page";
	}
	
	
	
}
