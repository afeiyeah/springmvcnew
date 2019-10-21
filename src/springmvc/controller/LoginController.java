package springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//�κ�һ�����@Controller������Ϊ������
@Controller
public class LoginController {
	/*
	 * @RequestMappingע�⣺
	 * value���ԣ����õ�ǰ������ӳ��·��    .action����ʡ��
	 * method���ԣ��趨��ǰ�����ܹ����յ�����ʽ
	 * 
	 * �������η���
	 * ���������� ��������·���ĸ�·��
	 */
	//����ModelAndView����
	//ӳ����ɺ󣬸��ݷ�����·���ҵ����еķ���
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
