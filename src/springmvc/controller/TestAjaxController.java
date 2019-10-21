package springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springmvc.model.bean.UserInfo;

@Controller
public class TestAjaxController {
	/*
	 * 非ajax请求，控制器基本都要做页面跳转
	 * ajax请求，控制器一定不做页面跳转，只是往前端返数据
	 * --返回值类型写的就是真实想返回的数值类型
	 * --参数绑定和之前的处理一样
	 * --@ResponseBody注解：将返回的数据转换成json对象
	 */
//	@RequestMapping("testAjax.action")
//	@ResponseBody
//	public String test(String username, int age){
//		System.out.println("======username:  "+username);
//		System.out.println("======age:  "+age);
//		//业务处理
//		return "{\"result\":\"注册成功\"}";
//	}
//	@RequestMapping("testAjax.action")
//	@ResponseBody
//	public UserInfo test(String username, int age){
//		System.out.println("======username:  "+username);
//		System.out.println("======age:  "+age);
//		//业务处理
//		UserInfo u=new UserInfo();
//		u.setUname(username);
//		u.setUid(123);
//		return u;
//	}
	@RequestMapping("testAjax.action")
	@ResponseBody
	public List<UserInfo> test(UserInfo u){
		System.out.println("======uname:  "+u.getUname());
		//业务处理
		List<UserInfo> ulist=new ArrayList<>();
		UserInfo u1=new UserInfo();
		u1.setUname(u.getUname());
		u1.setUid(123);
		String bd="1999-01-01";
		u1.setBirthday(java.sql.Date.valueOf(bd));
		ulist.add(u1);
		return ulist;
	}
}
