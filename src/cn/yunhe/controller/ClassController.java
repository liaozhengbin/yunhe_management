package cn.yunhe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.ClassBiz;
import cn.yunhe.biz.impl.ClassBizImpl;
import cn.yunhe.entity.ClassInfo;

@WebServlet("/class_controller")
public class ClassController extends HttpServlet{
	private ClassBiz classBiz=new ClassBizImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3891648656729047716L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("select".equals(method)){
			select(request, response);
		}else if("update2".equals(method)){
			update2(request, response);
		}
		
		

	}
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_name=request.getParameter("class_name");
		
		ClassBiz classBiz=new ClassBizImpl();
		classBiz.addClass(class_name);
		response.sendRedirect("class_controller?method=select");
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_id=request.getParameter("class_id");
		ClassBiz classBiz=new ClassBizImpl();
		classBiz.deleteClass(Integer.parseInt(class_id));
		response.sendRedirect("class_controller?method=select");
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String class_id=request.getParameter("class_id1");
		String class_name=request.getParameter("class_name");
		ClassBiz classBiz=new ClassBizImpl();
		classBiz.updateClass(Integer.parseInt(class_id), class_name);
		response.sendRedirect("class_controller?method=select");
		
	}
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String yeshu2=request.getParameter("yeshu");
		
		//页数
		int yeshu=yeshu2==null?1:Integer.parseInt(yeshu2);
		request.setAttribute("yeshu", yeshu);
		//行数
		int line=15;
		
		List<ClassInfo> classArray=classBiz.seleteClass(yeshu, line);
		request.setAttribute("classArray", classArray);
		//总行数
		int zs=classBiz.selectClassRecord();
		request.setAttribute("zs", zs);
		//总页数
		int zyeshu=classBiz.selectClassPage(line);
		request.setAttribute("zyeshu", zyeshu);
		
		request.getRequestDispatcher("WEB-INF/jsp/classmanager.jsp").forward(request, response);
		
	}
	
	
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String class_id=request.getParameter("class_id");

		ClassInfo classInfo=classBiz.selectClassOne(Integer.parseInt(class_id));
		request.setAttribute("classInfo", classInfo);
		
		request.getRequestDispatcher("WEB-INF/jsp/updateclass.jsp").forward(request, response);
		
	}
	
	

}
