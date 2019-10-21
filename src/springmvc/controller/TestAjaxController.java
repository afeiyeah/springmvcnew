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
	 * ��ajax���󣬿�����������Ҫ��ҳ����ת
	 * ajax���󣬿�����һ������ҳ����ת��ֻ����ǰ�˷�����
	 * --����ֵ����д�ľ�����ʵ�뷵�ص���ֵ����
	 * --�����󶨺�֮ǰ�Ĵ���һ��
	 * --@ResponseBodyע�⣺�����ص�����ת����json����
	 */
//	@RequestMapping("testAjax.action")
//	@ResponseBody
//	public String test(String username, int age){
//		System.out.println("======username:  "+username);
//		System.out.println("======age:  "+age);
//		//ҵ����
//		return "{\"result\":\"ע��ɹ�\"}";
//	}
//	@RequestMapping("testAjax.action")
//	@ResponseBody
//	public UserInfo test(String username, int age){
//		System.out.println("======username:  "+username);
//		System.out.println("======age:  "+age);
//		//ҵ����
//		UserInfo u=new UserInfo();
//		u.setUname(username);
//		u.setUid(123);
//		return u;
//	}
	@RequestMapping("testAjax.action")
	@ResponseBody
	public List<UserInfo> test(UserInfo u){
		System.out.println("======uname:  "+u.getUname());
		//ҵ����
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
