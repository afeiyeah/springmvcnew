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
	//����ֵ��ModelAndView����
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
		
		//1. ֵ mav.addObject("ulist", list);
		//2. ��ת��ַ mav.setViewName("main");
		ModelAndView mav=new ModelAndView();
		//addObject����Ĭ�Ͻ����ݷ���request�������У��൱��request.setAttribute();
		mav.addObject("ulist", list);
		//setViewName��������ָ��ҳ����ת��·����Ĭ��������ת���ķ�ʽ��ת
		mav.setViewName("main");
		
		return mav;
	}
	//��������ʱString����
	@RequestMapping("edit")
	public String editUser(Model model,int userid){
		System.out.println(userid);
		UserInfo u1=new UserInfo();
		u1.setUid(1);
		u1.setUname("test01");
		u1.setBirthday(new java.sql.Date(new Date().getTime()));
		/*
		 * String����ֵ
		 * 1.Ĭ�� ָ��Ҫ��ת��ҳ�� Ĭ��Ҳ������ת���ķ�ʽ
		 * 2.forward:·��   ����ת��������Ӧ����ƥ����ͼ������
		 * 3.redirect��·��  ���¶��������Ӧ����ƥ����ͼ������
		 * ����������Ĭ��֧�ֵĲ���:
		 * Model:��������������
		 * HttpServletRequest:��������������
		 * HttpSession:����Ự������
		 * HttpServletResponse:������Ӧ����
		 */
		//1. ֵ��model.addAttribute("editUser", u1);����request.setAttribute("editUser", u1);
		//����session.setAttribute()
		//2. ��ת��ַ��return "edituser"
		model.addAttribute("editUser", u1);
		//request.setAttribute("editUser", u1);
		System.out.println("����edit");
		return "edituser";
	}
	//����ֵΪString����һ��ת����ַ��ʽ��return "redirect:selectUser.action";
	@RequestMapping("update")
	public String updateUser(UserInfoDTO u, MultipartFile photo) throws IllegalStateException, IOException{
		System.out.println(u.getUid());
		System.out.println(u.getUname());
		System.out.println(u.getBirthday());
		System.out.println(u.getCity().getCityid());
		//��ȡ�ϴ����ļ�����
		String oldName=photo.getOriginalFilename();
		//������
		String newName=System.currentTimeMillis()+oldName.substring(oldName.indexOf("."));
		//����file����
		File file=new File("e:\\photo\\",newName);
		photo.transferTo(file);
		return "redirect:selectUser.action";
	}
	
	//����ֵΪvoid
	@RequestMapping("exportUser")
	public void export(HttpServletResponse response){
		//ֵ����
		//��ת��ַ����
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
