package deity.frame.first.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import deity.frame.first.admin.menu.MenuDAO;

public class SessionInterceptor implements HandlerInterceptor{
	private static final Logger logger  =  LoggerFactory.getLogger(SessionInterceptor.class);
	
//	@Autowired
//	HttpSession session;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		//HandlerMethod method = (HandlerMethod)handler;
		//String name = method.getMethod().getName();
		//logger.info(name);
		//TODO 아래와 같이 하니까 CSS등 resource가 모두 통과 안된다. 왜그럴까?
//		String name = method.getMethod().getName();
//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("session") == null){//HashMap으로 들어있다.
//			
//			if("root".equals(name)){
//				return true;
//			}else if("login".equals(name)){
//				return true;
//			}else{
//				return false;
//			}	
//		}
			
			return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println(modelAndView.getStatus());
		if (handler instanceof HandlerMethod) {
			
			HttpSession session = request.getSession();
			if(session.getAttribute("session") == null){
				HandlerMethod method = (HandlerMethod)handler;
				String name = method.getMethod().getName();
				
				if("root".equals(name)){
					
				}else if("login".equals(name)){
					
				}else{
					modelAndView.setViewName("/login/login");
				}
				
			}else{
				
				String viewName = modelAndView.getViewName();
				System.out.println(viewName);
				if(viewName == null){
					
				}else{
					String menuLocation = menuDAO.getMenuLocation(viewName);	
					if(menuLocation==null){
						
					}else{
						request.setAttribute("location", "메뉴 > "+menuLocation);	
					}
				
				}
				
				
			}
		}
		request.setAttribute("title", "Platform Building System");
		request.setAttribute("contextPath", request.getContextPath());
		
		
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
		
	}

	
	

}
