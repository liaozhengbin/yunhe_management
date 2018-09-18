package cn.yunhe.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.PermissionBiz;
import cn.yunhe.biz.RoleBiz;
import cn.yunhe.biz.impl.PermissionBizImpl;
import cn.yunhe.biz.impl.RoleBizImpl;
import cn.yunhe.entity.PermissionInfo;
import cn.yunhe.entity.RoleInfo;



@WebServlet("/role")
public class RoleController extends HttpServlet{
	private RoleBiz roleBiz=new RoleBizImpl();
	private PermissionBiz permissionBiz=new PermissionBizImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 5033156548612941333L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("select".equals(method)){
			select(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("addselect".equals(method)){
			addselect(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("update2".equals(method)){
			update2(request, response);
		}
		
		
	}
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<RoleInfo> roleList=roleBiz.selectRole();
		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("WEB-INF/jsp/rolemanager.jsp").forward(request, response);
		
	}
	
	private void addselect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PermissionInfo> permissionList=permissionBiz.selectPermission();
		request.setAttribute("permissionList", permissionList);
		
		request.getRequestDispatcher("WEB-INF/jsp/addrole.jsp").forward(request, response);
		
	}
	
	
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String role_name=request.getParameter("role_name");
		String[] permission=request.getParameterValues("permission");
		List<Integer> permissionList=new ArrayList<Integer>();
		for(int i=0;i<permission.length;i++){
			String str=permission[i];
			permissionList.add(Integer.parseInt(str));
		}
		roleBiz.addRole(role_name, permissionList);
		response.getWriter().println("<script>alert('添加成功！');location.href='role?method=select';</script>");
		

	}
	
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleId=request.getParameter("roleId");
		roleBiz.deleteRole(Integer.parseInt(roleId));
		response.sendRedirect("role?method=select");
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roleId=request.getParameter("roleId");
		request.setAttribute("roleId", roleId);
		String role_name=request.getParameter("role_name");
		request.setAttribute("role_name", role_name);
		List<RoleInfo> roleInfo=roleBiz.selectRolePms(Integer.parseInt(roleId));
		request.setAttribute("roleInfo", roleInfo);
		List<PermissionInfo> permissionList=permissionBiz.selectPermission();
		request.setAttribute("permissionList", permissionList);
		
		request.getRequestDispatcher("WEB-INF/jsp/updaterole.jsp").forward(request, response);
		
	}
	
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_id=request.getParameter("class_id");
		String class_name=request.getParameter("class_name");
		String[] permission=request.getParameterValues("permission");
		roleBiz.updateRoleName(Integer.parseInt(class_id), class_name);
		permissionBiz.deletePermission(Integer.parseInt(class_id));
		List<Integer> permissionList=new ArrayList<Integer>();
		for(int i=0;i<permission.length;i++){
			String str=permission[i];
			permissionList.add(Integer.parseInt(str));
		}
		roleBiz.addRole_index(Integer.parseInt(class_id), permissionList);
		
		response.getWriter().println("<script>alert('修改成功！');location.href='role?method=select';</script>");
		
	}
	

}
