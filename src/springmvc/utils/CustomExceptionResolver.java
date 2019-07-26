package springmvc.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {
		String message = "";
		if(ex instanceof CustomException){
			message = ex.getMessage();
		}else{
			message = "�����쳣�����Ժ�����";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", message);
		mav.setViewName("/error");
		return mav;
	}
}
