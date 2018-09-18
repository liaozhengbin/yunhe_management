package cn.yunhe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.PermissionBiz;
import cn.yunhe.biz.impl.PermissionBizImpl;
import cn.yunhe.entity.PermissionInfo;

@WebServlet("/permission")
public class PermissionController extends HttpServlet{
	private PermissionBiz permissionBiz=new PermissionBizImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1446485481636478773L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("select".equals(method)){
			select(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("add".equals(method)){
			add(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}
		else if("update2".equals(method)){
			update2(request, response);
		}
		
		
		
	}
	
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PermissionInfo> permissionList=permissionBiz.selectPermission();
		request.setAttribute("permissionList", permissionList);
		
		request.getRequestDispatcher("WEB-INF/jsp/permissionmanager.jsp").forward(request, response);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String permission_id=request.getParameter("permission_id");
		
		permissionBiz.deletePermission2(Integer.parseInt(permission_id));
		
		response.sendRedirect("permission?method=select");
		
	}
	
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_name=request.getParameter("class_name");
		
		permissionBiz.addPermission(class_name);
		
		response.sendRedirect("permission?method=select");
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String permission_id=request.getParameter("permission_id");
		String class_name=request.getParameter("class_name");
		
		permissionBiz.updatePermission(Integer.parseInt(permission_id), class_name);
		
		response.sendRedirect("permission?method=select");
		
	}
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String permission_id=request.getParameter("permission_id");
		request.setAttribute("permission_id", permission_id);
		PermissionInfo permissionInfo=permissionBiz.selectPermission_index(Integer.parseInt(permission_id));
		request.setAttribute("permissionInfo", permissionInfo);
		
		request.getRequestDispatcher("WEB-INF/jsp/updatepermission.jsp").forward(request, response);
		
	}
	

}
