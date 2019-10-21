package springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import springmvc.dto.UserInfoDTO;
import springmvc.model.bean.UserInfo;

@Controller
public class UserController {
	//返回值是ModelAndView类型
	@RequestMapping("selectUser")
	public ModelAndView selectUser(){
		
		List<UserInfo> list=new ArrayList<>();
		UserInfo u1=new UserInfo();
		u1.setUid(1);
		u1.setUname("test01");
		u1.setBirthday(new java.sql.Date(new Date().getTime()));
		list.add(u1);
		UserInfo u2=new UserInfo();
		u2.setUid(2);
		u2.setUname("test02");
		u2.setBirthday(new java.sql.Date(new Date().getTime()));
		list.add(u2);
		
		//1. 值 mav.addObject("ulist", list);
		//2. 跳转地址 mav.setViewName("main");
		ModelAndView mav=new ModelAndView();
		//addObject方法默认将数据放在request作用域中，相当于request.setAttribute();
		mav.addObject("ulist", list);
		//setViewName方法用来指定页面跳转的路径，默认是请求转发的方式跳转
		mav.setViewName("main");
		
		return mav;
	}
	//返回类型时String类型
	@RequestMapping("edit")
	public String editUser(Model model,int userid){
		System.out.println(userid);
		UserInfo u1=new UserInfo();
		u1.setUid(1);
		u1.setUname("test01");
		u1.setBirthday(new java.sql.Date(new Date().getTime()));
		/*
		 * String返回值
		 * 1.默认 指定要跳转的页面 默认也是请求转发的方式
		 * 2.forward:路径   请求转发进行响应，不匹配视图解析器
		 * 3.redirect：路径  重新定向进行响应，不匹配视图解析器
		 * 控制器方法默认支持的参数:
		 * Model:代表请求作用域
		 * HttpServletRequest:代表请求作用域
		 * HttpSession:代表会话作用域
		 * HttpServletResponse:代表响应对象
		 */
		//1. 值：model.addAttribute("editUser", u1);或者request.setAttribute("editUser", u1);
		//或者session.setAttribute()
		//2. 跳转地址：return "edituser"
		model.addAttribute("editUser", u1);
		//request.setAttribute("editUser", u1);
		System.out.println("跳回edit");
		return "edituser";
	}
	//返回值为String的另一种转发地址方式：return "redirect:selectUser.action";
	@RequestMapping("update")
	public String updateUser(UserInfoDTO u, MultipartFile photo) throws IllegalStateException, IOException{
		System.out.println(u.getUid());
		System.out.println(u.getUname());
		System.out.println(u.getBirthday());
		System.out.println(u.getCity().getCityid());
		//获取上传的文件名称
		String oldName=photo.getOriginalFilename();
		//重命名
		String newName=System.currentTimeMillis()+oldName.substring(oldName.indexOf("."));
		//构建file对象
		File file=new File("e:\\photo\\",newName);
		photo.transferTo(file);
		return "redirect:selectUser.action";
	}
	
	//返回值为void
	@RequestMapping("exportUser")
	public void export(HttpServletResponse response){
		//值：无
		//跳转地址：无
		System.out.println("================");
	}
	@RequestMapping("deleteUser")
	public String delete(int[] chk){
		for(int c:chk){
			System.out.println(c);
		}
//		for(int i=0;i<chk.length;++i){
//			System.out.println(chk[i]);
//		}
//		System.out.println(Arrays.toString(chk));
		return "redirect:selectUser.action";
	}
	
	
}
