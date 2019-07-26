package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductManageController {
	
	@RequestMapping("addProduct")
	public ModelAndView addProduct(){
		System.out.println("½øÈëaddProduct");
		return null;
	}
	
	
	
	
}
