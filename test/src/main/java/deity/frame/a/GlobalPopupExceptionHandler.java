package deity.frame.a;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 3.1에서는 전역이 존재하지 않으므로 상속으로 대체해보자.
 * 근데 왜 3.1로 만드는걸까? 지금 4.0이 넘었는데.
 * 진짜로 스프링부트로 만들어야 할지도 모르겠다.
 * @author deity
 *
 */
public class GlobalPopupExceptionHandler {

	
	@ResponseStatus(value=HttpStatus.CONFLICT, reason="Data already present")  // 409
	@ExceptionHandler(SQLException.class)
	public void conflict() {
	    System.out.println("data error");
	}
	
	
	@ExceptionHandler(FileNotFoundException.class)
	  public ModelAndView myError(Exception exception) {
	    System.out.println("----Caught FileNotFoundException----");
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("message", exception.getMessage());
	    mav.setViewName("error");
	    return mav;
	  }
	
	@ExceptionHandler(Exception.class) 
    public ModelAndView handleRuntimeException(Exception e, HttpServletResponse response) {
        ModelAndView mnv = new ModelAndView("error");
        mnv.addObject("data", e.getMessage());
         
        return mnv;
    }
}
