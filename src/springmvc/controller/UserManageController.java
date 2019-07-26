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
	 * �������з����ķ���ֵ��
	 * ModelAndView:֧��ҳ����ת��Ҳ֧�����ݹ��� 
	 * Ĭ�Ͼ�����request������������   �൱��֮ǰ�Ĵ���request.setAttribute(,)
		mav.addObject("resultList", list);
		//Ĭ������ת������ʽ������ת
		mav.setViewName("main");
	 * String
	 * ��ҳ����ת��ָ����ת��ʽ��   Ҳ��������ݹ���
	 * redirect   ��ƥ���׺
	 * forward    ��ƥ���׺
	 * 
	 * void
	 * 
	 * �������з���Ĭ��֧�ֵĲ������ͣ�
	 * Model 
	 * HttpServletRequest
	 * HttpSession
	 * HttpServletResponse
	 * 
	 * ��ȡ������(������)
	 * 1. �����͵Ĳ�����    ��ֵ   �ַ���   ������
	 *   �������������βκ��ύ�����ı�Ԫ�ض�Ӧ����������һ�£��βε����ֺͱ�����������һ��
	 * 2. POJO���Ͳ����󶨣�ʵ����ȥ�������󶨣�
	 *    ʵ�������к�ҳ���Ԫ��ͬ��������(����һ��)��ͬʱ������Ҫ�з���������
	 *    HTTP 400:�����󶨵Ĵ������Ͳ�ƥ�䣬�������Ϳ�ֵ���µĵȵȣ�
	 *    �������Ϳ�ֵ��
	 *    1. ǰ�˿��ƿ�ֵ����
	 *    2. ��������String�����������ݣ�����ת��
	 * 3. ���������POJO���Ͳ����� 
	 * 4. �������͵Ĳ�����
	 *   ����   list  
	 *   �������ƺ�ҳ����ͬ���ı��ؼ�������һ��  ��������һ��
	 *   
	 *   Resutful����url����
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
		//Ĭ�Ͼ�����request������������   �൱��֮ǰ�Ĵ���request.setAttribute(,)
		mav.addObject("resultList", list);
		//Ĭ������ת������ʽ������ת
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("edit")
	public String editUser(Model model,HttpServletRequest request,HttpSession session){
		User u1 = new User();
		u1.setUsername("test01");
		u1.setPhone("1598866333");
		u1.setEmail("test01@126.com");
		//��request������������   �൱��֮ǰ�Ĵ���request.setAttribute(,)
		//model.addAttribute("user", u1);
		//request.setAttribute("user", u1);
		session.setAttribute("user", u1);
		//Ĭ������ת���ķ�ʽ��תҳ��
		return "redirect:editUser.jsp";
	}
	
	@RequestMapping("update")
	public String updateUser(){
		//�޸�
		return "redirect:select.action";
	}
	
	@RequestMapping("export")
	public void exportUser(HttpServletResponse response){
		
	}
	
	@RequestMapping("addUser")
	public String addUser(User user,MultipartFile pic){
		System.out.println(user.getUsername()+"==="+user.getEmail()+"==="+user.getPhone()+"==="+user.getSex()+"==="+user.getBirthday()+"==="+user.getP().getProid());
		
		//�ϴ�
		//������
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
