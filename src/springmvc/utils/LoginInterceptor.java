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
		
		//查看当前请求是否为正在登录，如果是，继续执行，如果不是，检查是否已经登录过，如果登录过，则继续，否则，跳转登录界面
		String url = request.getRequestURI();
		String url1 = request.getRequestURL().toString();
		System.out.println(url);
		System.out.println(url1);
		
		if(url.indexOf("login")>-1){
			//正在登录
			return true;
		}else{
			//不是在登录功能
			String loginFlag = (String) request.getSession().getAttribute("loginFlag");
			if("success".equals(loginFlag)){
				//已经登陆成功
				return true;
			}else{
				//未登录过
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}
		return false;
	}
}












