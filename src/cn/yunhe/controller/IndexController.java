package cn.yunhe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.PermissionBiz;
import cn.yunhe.biz.UserBiz;
import cn.yunhe.biz.impl.PermissionBizImpl;
import cn.yunhe.biz.impl.UserBizImpl;
import cn.yunhe.entity.PermissionInfo;
import cn.yunhe.entity.UserInfo;

@WebServlet("/index")
public class IndexController extends HttpServlet{
	private UserBiz userBiz=new UserBizImpl();
	private PermissionBiz permissionBiz=new PermissionBizImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 766298358118081722L;
	
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		 UserInfo User=(UserInfo)request.getSession().getAttribute("User");
		    
		    if(User==null){//session中没有用户对象
		    	//去cookie去找userId
		    	String userId=null;
			    Cookie[] cookieArray=request.getCookies();
			    if(cookieArray!=null){
			    	 for(Cookie cookie:cookieArray){
			 	    	if("userID".equals(cookie.getName())){//筛选出了“userID”这个cookie对象
			 	    		userId=cookie.getValue();
			 	    	}
			 	    }
			    }
			   
			    
				if(userId==null){//未登录
					response.sendRedirect("login.jsp");
			    	
				}else{
					//cookie中有userID
					
					User=userBiz.seleteUser(Integer.parseInt(userId));
					request.getSession().setAttribute("User", User);
					List<PermissionInfo> PermissionInfoList=permissionBiz.selectPermission2(User.getUser_role());
					request.getSession().setAttribute("PermissionInfoList", PermissionInfoList);
					
					
					request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
				}
				
				
		    }else{//session有用户对象
		    	List<PermissionInfo> PermissionInfoList=permissionBiz.selectPermission2(User.getUser_role());
				request.getSession().setAttribute("PermissionInfoList", PermissionInfoList);
		    	request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
		    }
		
		
		
		
	}
	
}
