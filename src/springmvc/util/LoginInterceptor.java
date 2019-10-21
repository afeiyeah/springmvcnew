package springmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

//������ִ����ִ��
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

//��Ӧ֮ǰִ��
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
//���������֮ǰִ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
//��¼��֤
		//1.���ڵ�¼��ͨ��
		//2.�Ѿ���¼��ͨ��
		//3.δ��¼����ͨ��
		String url=request.getRequestURI();
		if(url.indexOf("login")>-1){
			return true;
		}else{
			System.out.println("���������ǵ�¼����");
			String flag=(String)request.getSession().getAttribute("flag");
			System.out.println(flag);
			//ע�⣺���ﲻ��дflag.equals("logged")������ֿ�ָ���쳣
			if("logged".equals(flag)){
				return true;
			}else{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}
		return false;
	}

}
