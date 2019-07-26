package springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import springmvc.model.bean.User;
import springmvc.utils.CustomException;

@Controller
public class UserManageController {
	/*
	 * 控制器中方法的返回值：
	 * ModelAndView:支持页面跳转，也支持数据共享 
	 * 默认就是往request作用域存放数据   相当于之前的代码request.setAttribute(,)
		mav.addObject("resultList", list);
		//默认请求转发的形式进行跳转
		mav.setViewName("main");
	 * String
	 * 能页面跳转（指定跳转方式）   也能完成数据共享
	 * redirect   不匹配后缀
	 * forward    不匹配后缀
	 * 
	 * void
	 * 
	 * 控制器中方法默认支持的参数类型：
	 * Model 
	 * HttpServletRequest
	 * HttpSession
	 * HttpServletResponse
	 * 
	 * 获取表单参数(参数绑定)
	 * 1. 简单类型的参数绑定    数值   字符串   布尔型
	 *   控制器方法的形参和提交过来的表单元素对应，数据类型一致，形参的名字和表单参数的名称一致
	 * 2. POJO类型参数绑定（实体类去做参数绑定）
	 *    实体类中有和页面表单元素同名的属性(类型一致)，同时，属性要有访问器方法
	 *    HTTP 400:参数绑定的错误（类型不匹配，日期类型空值导致的等等）
	 *    日期类型空值：
	 *    1. 前端控制空值问题
	 *    2. 控制器用String接收日期数据，再做转换
	 * 3. 特殊情况的POJO类型参数绑定 
	 * 4. 集合类型的参数绑定
	 *   数组   list  
	 *   数组名称和页面中同名的表单控件的名称一致  数据类型一致
	 *   
	 *   Resutful风格的url构成
	 *   
	 *   
	 *   
	 */
	
	@RequestMapping("select")
	public ModelAndView selectUser(int uid,String flag)throws Exception{
		System.out.println(uid+"-----------------"+flag);
		
		List<User> list = new ArrayList<>();
		User u1 = new User();
		u1.setId(5);
		u1.setUsername("test01");
		u1.setPhone("1598866333");
		u1.setEmail("test01@126.com");
		list.add(u1);
		User u2 = new User();
		u2.setId(4);
		u2.setUsername("test02");
		u2.setPhone("1588956233");
		u2.setEmail("test02@126.com");
		list.add(u2);
		
		ModelAndView mav = new ModelAndView();
		//默认就是往request作用域存放数据   相当于之前的代码request.setAttribute(,)
		mav.addObject("resultList", list);
		//默认请求转发的形式进行跳转
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("edit")
	public String editUser(Model model,HttpServletRequest request,HttpSession session){
		User u1 = new User();
		u1.setUsername("test01");
		u1.setPhone("1598866333");
		u1.setEmail("test01@126.com");
		//往request作用域存放数据   相当于之前的代码request.setAttribute(,)
		//model.addAttribute("user", u1);
		//request.setAttribute("user", u1);
		session.setAttribute("user", u1);
		//默认请求转发的方式跳转页面
		return "redirect:editUser.jsp";
	}
	
	@RequestMapping("update")
	public String updateUser(){
		//修改
		return "redirect:select.action";
	}
	
	@RequestMapping("export")
	public void exportUser(HttpServletResponse response){
		
	}
	
	@RequestMapping("addUser")
	public String addUser(User user,MultipartFile pic){
		System.out.println(user.getUsername()+"==="+user.getEmail()+"==="+user.getPhone()+"==="+user.getSex()+"==="+user.getBirthday()+"==="+user.getP().getProid());
		
		//上传
		//重命名
		String oldName = pic.getOriginalFilename();
		String newName = System.currentTimeMillis()+ oldName.substring(oldName.indexOf("."));
		
		File file =new File("D:/picture/",newName);
		try {
			pic.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:main.jsp";
	}
	
	@RequestMapping("delete")
	public String deleteUser(int[] userid){
		System.out.println(Arrays.toString(userid));
		return "redirect:select.action";
	}
	
	
}
