package springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//任何一个类加@Controller代表作为控制器
@Controller
public class LoginController {
	/*
	 * @RequestMapping注解：
	 * value属性：设置当前方法的映射路径    .action可以省略
	 * method属性：设定当前方法能够接收的请求方式
	 * 
	 * 可以修饰方法
	 * 可以修饰类 代表请求路径的根路径
	 */
	//返回ModelAndView类型
	//映射完成后，根据方法的路径找到运行的方法
	@RequestMapping(value="login.action",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(String uid,String pwd,HttpSession session) throws Exception{
		System.out.println(uid);
		System.out.println(pwd);
		session.setAttribute("flag", "logged");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
}
