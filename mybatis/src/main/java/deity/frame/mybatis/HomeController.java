package deity.frame.mybatis;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private StudyDao studyDao;
	
	@Autowired
	private BookDAO bookDAO;
	
	//어노테이션으로 쿼리만드는 것(Mapper class 생성)하려다가 설정이 엉키는 것같아 그만둠
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		//빈에 있는 sqlSession을 사용
		//스프링 빈을 따로 설정안해도 된다.
		//Repository부분에 어노테이션만 선언해도 된다.
		studyDao.test();
		
		//SqlSessionDaoSupport를 사용
		//스프링 빈에 빈으로 추가해주어야한다.
		//Repository부분에 어노테이션을 넣지 않는다.
		bookDAO.test();
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
