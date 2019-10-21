package springmvc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

//控制器执行完执行
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

//响应之前执行
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
//进入控制器之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
//登录验证
		//1.正在登录，通过
		//2.已经登录，通过
		//3.未登录，不通过
		String url=request.getRequestURI();
		if(url.indexOf("login")>-1){
			return true;
		}else{
			System.out.println("拦截器：非登录过程");
			String flag=(String)request.getSession().getAttribute("flag");
			System.out.println(flag);
			//注意：这里不能写flag.equals("logged")，会出现空指针异常
			if("logged".equals(flag)){
				return true;
			}else{
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}
		}
		return false;
	}

}
