package springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/*
	 * @RequestMapping注解：用来进行请求路径的映射
	 * 可以用来修饰类，也可以修饰方法
	 * 当修饰类的时候，代表请求的根路径
	 * @RequestMapping注解也支持其他属性的使用，比如method
	 * 
	 
	 * 
	 */
	//登录
	@RequestMapping(value="login",method={RequestMethod.POST})
	public ModelAndView login(HttpSession session){
		//session中存放数据，代表是否登录过
		session.setAttribute("loginFlag", "success");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}	
}







