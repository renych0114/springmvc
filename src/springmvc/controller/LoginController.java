package springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	/*
	 * @RequestMappingע�⣺������������·����ӳ��
	 * �������������࣬Ҳ�������η���
	 * ���������ʱ�򣬴�������ĸ�·��
	 * @RequestMappingע��Ҳ֧���������Ե�ʹ�ã�����method
	 * 
	 
	 * 
	 */
	//��¼
	@RequestMapping(value="login",method={RequestMethod.POST})
	public ModelAndView login(HttpSession session){
		//session�д�����ݣ������Ƿ��¼��
		session.setAttribute("loginFlag", "success");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}	
}







