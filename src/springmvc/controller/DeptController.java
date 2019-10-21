package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dept")
public class DeptController {
	
	@RequestMapping("addDept.action")
	public ModelAndView addDept(){
		System.out.println("请求进入DeptController");
		return null;
	}
	@RequestMapping("selectDept.action")
	public ModelAndView selectDept(){
		System.out.println("请求进入DeptController");
		return null;
	}
	
}
