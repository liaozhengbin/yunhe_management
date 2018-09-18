package cn.yunhe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.UserBiz;
import cn.yunhe.biz.impl.UserBizImpl;
import cn.yunhe.entity.UserInfo;


@WebServlet(name="Login",urlPatterns="/test_login",
initParams={@WebInitParam(name="username",value="zhangsan")},
loadOnStartup=1)
public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8342062119859221923L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request, response);
		}else if("exit".equals(method)){
			exit(request, response);
		}else if("verification".equals(method)){
			verification(request, response);
		}
		
		
		
		
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user=request.getParameter("email");
		String pwd=request.getParameter("password");
		String remember=request.getParameter("remember");
		String captcha=request.getParameter("j_captcha");//�û��������֤��
		String serverCode=(String) request.getSession().getAttribute("code");//������ɵ�4λ��֤��
	
		UserBiz userBiz=new UserBizImpl();
		UserInfo User=userBiz.seleteUserAndPwd(user, pwd);
		
		if(serverCode.equalsIgnoreCase(captcha)){
			request.getSession().removeAttribute("serverCode");
			if(User==null){
				response.getWriter().println("<script>alert('�û������������');history.go(-1);</script>");
			}else{
				
				if(remember!=null){
					Cookie cookie=new Cookie("userID", User.getUser_id()+"");
					//���Ը�cookie���ñ���ʱ�䣨��λ���룬Ĭ�ϱ���ʱ��Ϊ0��
					cookie.setMaxAge(60*60*24*7);//����һ��
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("User", User);
				response.sendRedirect("index");
			}
			
			
		}else{
			request.getSession().removeAttribute("serverCode");
			response.getWriter().println("<script>alert('��֤�벻��ȷ��');location.href='login.jsp';</script>");
			
		}
		
	}
	
	
	private void exit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		
		
		//��cookie��Ӧ�������
		Cookie cookie1=new Cookie("userID", null);
		cookie1.setMaxAge(0);//����һ��
		response.addCookie(cookie1);
		
		
		response.sendRedirect("login.jsp");
		
		
		
		
	}
	
	private void verification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
	}
	
	
	

}
