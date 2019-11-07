package interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import dao.DatabaseLoaiMay;
import entity.LoaiMay;

public class MenuHandleInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		      throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
		DatabaseLoaiMay db = (DatabaseLoaiMay) context.getBean("databaseloaimay");
		List<LoaiMay> listLoaiMay = db.getListLoaiMay();
		request.setAttribute("ListLoaiMay", listLoaiMay);
		    return true;
		  }
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
		
	}
}
