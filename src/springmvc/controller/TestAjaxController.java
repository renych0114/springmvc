package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.model.bean.User;

@Controller
public class TestAjaxController {
	
	@RequestMapping("testAjax")
	@ResponseBody
	public String test(User u){
		System.out.println("进入testAjax");
		System.out.println(u.getId()+"==="+u.getUsername());
		
		/*User u1 = new User();
		u1.setId(5);
		u1.setUsername("test01");
		u1.setPhone("1598866333");
		u1.setEmail("test01@126.com");*/
		
	/*	List<User> list = new ArrayList<>();
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
		list.add(u2);*/
		
		
		return "{\"result\":\"没有查询到数据\"}";
		
	}
	
}
