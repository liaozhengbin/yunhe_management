package cn.yunhe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import cn.yunhe.biz.ClassBiz;
import cn.yunhe.biz.RoleBiz;
import cn.yunhe.biz.UserBiz;
import cn.yunhe.biz.impl.ClassBizImpl;
import cn.yunhe.biz.impl.RoleBizImpl;
import cn.yunhe.biz.impl.UserBizImpl;
import cn.yunhe.dao.RoleDao;
import cn.yunhe.dao.impl.RoleDaoImpl;
import cn.yunhe.entity.ClassInfo;
import cn.yunhe.entity.RoleInfo;
import cn.yunhe.entity.UserInfo;


@WebServlet("/user")
public class UserController extends HttpServlet{
	private UserBiz userBiz=new UserBizImpl();
	private RoleBiz roleDao=new RoleBizImpl();
	private ClassBiz classBiz=new ClassBizImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2170828703549061073L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("delete".equals(method)){
			delete(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("select".equals(method)){
			select(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("add2".equals(method)){
			add2(request, response);
		}else if("update2".equals(method)){
			update2(request, response);
		}
		
		
		
	}
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<UserInfo> userList=userBiz.seleteUserList();
		request.setAttribute("userList", userList);
		
		request.getRequestDispatcher("WEB-INF/jsp/usermanager.jsp").forward(request, response);
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		userBiz.deleteUser(Integer.parseInt(userId));
		
		response.sendRedirect("user?method=select");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id=request.getParameter("user_id");
		String user_name=request.getParameter("user_name");
		String user_pwd=request.getParameter("user_pwd");
		String user_nickname=request.getParameter("user_nickname");
		String role_id=request.getParameter("role_id");
		String class_id=request.getParameter("class_id");
		userBiz.updateUser(user_name, user_pwd, user_nickname, Integer.parseInt(role_id), Integer.parseInt(class_id), Integer.parseInt(user_id));;
		
		response.getWriter().println("<script>alert('修改成功！');location.href='user?method=select';</script>");
		
	}
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		UserInfo userList=userBiz.seleteUserList_index(Integer.parseInt(userId));
		request.setAttribute("userList", userList);
		
		List<RoleInfo> roleList=roleDao.selectRole();
		request.setAttribute("roleList", roleList);
		
		List<ClassInfo> classList=classBiz.seleteClass2();
		request.setAttribute("classList", classList);
		
		
		
		String roleName1="";
		String roleName2="";
		String roleName3="";
		if(-1==userList.getUser_role()){
			roleName1="selected='selected'";
			request.setAttribute("roleName1", roleName1);
		}else if(1==userList.getUser_role()){
			roleName2="selected='selected'";
			request.setAttribute("roleName2", roleName2);
		}
		else if(4==userList.getUser_role()){
			roleName3="selected='selected'";
			request.setAttribute("roleName3", roleName3);
		}
		
		String className1="";
		String className2="";
		String className3="";
		String className4="";
		if(-1==userList.getClass_id()){
			className1="selected='selected'";
			request.setAttribute("className1", className1);
		}else if(1==userList.getClass_id()){
			className2="selected='selected'";
			request.setAttribute("className2", className2);
		}else if(2==userList.getClass_id()){
			className3="selected='selected'";
			request.setAttribute("className3", className3);
		}else if(3==userList.getClass_id()){
			className4="selected='selected'";
			request.setAttribute("className4", className4);
		}
		
		
		
		
		
		
		request.getRequestDispatcher("WEB-INF/jsp/updateuser.jsp").forward(request, response);
	}
	
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("user_name");
		String user_pwd=request.getParameter("user_pwd");
		String user_nickname=request.getParameter("user_nickname");
		String role_id=request.getParameter("role_id");
		String class_id=request.getParameter("class_id");
		
		

		userBiz.addUser(user_name, user_pwd, user_nickname, Integer.parseInt(role_id),Integer.parseInt(class_id));
		response.getWriter().println("<script>alert('添加成功！');location.href='user?method=select';</script>");
		
		
	}
	
	private void add2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<RoleInfo> roleList=roleDao.selectRole();
		request.setAttribute("roleList", roleList);
		
		List<ClassInfo> classList=classBiz.seleteClass2();
		request.setAttribute("classList", classList);
		
		
		request.getRequestDispatcher("WEB-INF/jsp/adduser.jsp").forward(request, response);
	}
	
	

}
