package springmvc.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		
		//�鿴��ǰ�����Ƿ�Ϊ���ڵ�¼������ǣ�����ִ�У�������ǣ�����Ƿ��Ѿ���¼���������¼�����������������ת��¼����
		String url = request.getRequestURI();
		String url1 = request.getRequestURL().toString();
		System.out.println(url);
		System.out.println(url1);
		
		if(url.indexOf("login")>-1){
			//���ڵ�¼
			return true;
		}else{
			//�����ڵ�¼����
			String loginFlag = (String) request.getSession().getAttribute("loginFlag");
			if("success".equals(loginFlag)){
				//�Ѿ���½�ɹ�
				return true;
			}else{
				//δ��¼��
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}
		return false;
	}
}












