package cn.yunhe.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import cn.yunhe.biz.StudentBiz;

import cn.yunhe.biz.impl.StudentBizImpl;
import cn.yunhe.entity.Student;

@WebServlet("/Student_controller")
public class StudentController extends HttpServlet{
	private StudentBiz studentBiz=new StudentBizImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5629351974279726244L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("select".equals(method)){
			select(request, response);
		}else if("add2".equals(method)){
			add2(request, response);
		}else if("update2".equals(method)){
			update2(request, response);
		}
		
		
		
		
		
	}
	
	
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stu_head=null;
		String class_id=null;
		String stu_no=null;
		String stu_name=null;
		String stu_sex=null;
		String stu_profession=null;
		String stu_icno=null;
		String stu_phone=null;
		String stu_birth=null;
		String stu_qq=null;
		String stu_edu=null;
		String stu_school=null;
		
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfUpload=new ServletFileUpload(factory);
		
		try {
			List<FileItem> itemList=sfUpload.parseRequest(request);
			for (FileItem fileItem : itemList) {
				
				
				if(fileItem.isFormField()){
					String name=fileItem.getFieldName();
					if("class_id".equals(name)){
						String value=fileItem.getString("UTF-8");
						class_id=value;
					}
					if("stu_no".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_no=value;
					}
					if("stu_name".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_name=value;
					}
					if("stu_sex".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_sex=value;
					}
					if("stu_profession".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_profession=value;
					}
					if("stu_icno".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_icno=value;
					}
					if("stu_phone".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_phone=value;
					}
					if("stu_birth".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_birth=value;
					}
					if("stu_qq".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_qq=value;
					}
					if("stu_edu".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_edu=value;
					}
					if("stu_school".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_school=value;
					}

				}else{
					String name=fileItem.getFieldName();
					if("stu_head".equals(name)){

						String fileName=fileItem.getName();
						
						if(fileName!=null&&!fileName.isEmpty()){
							if(fileName.endsWith(".jpg")||
									fileName.endsWith(".jpeg")||
									fileName.endsWith(".png")||
									fileName.endsWith(".bmp")||
									fileName.endsWith(".gif")){
							String	fileName2=System.currentTimeMillis()+""+fileName.substring(fileName.lastIndexOf("."));
							String path=getServletContext().getRealPath("/head");
								System.out.println(path);
								File file=new File(path, fileName2);
								fileItem.write(file);
								stu_head=fileName2;
							}else{
								response.getWriter().println("<script>alert('图片格式不合法');history.go(-1)</script>");
							}
							
						}

					}

				}

			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StudentBiz studentBiz=new StudentBizImpl();
		studentBiz.addStudent(stu_no, stu_name, stu_profession, stu_sex, stu_head, stu_phone, stu_icno, stu_birth, stu_qq, Integer.parseInt(class_id), stu_edu, stu_school);
		response.getWriter().println("<script>alert('添加成功！');location.href='Student_controller?method=select';</script>");
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuId=request.getParameter("stuId");
		StudentBiz scoreBiz=new StudentBizImpl();
		scoreBiz.deleteStudent(Integer.parseInt(stuId));
		response.sendRedirect("Student_controller?method=select");
		
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuId=null;
		
		String stu_head=null;
		
		String classId=null;
		
		String stu_no=null;
		
		String stu_name=null;
		
		String stu_sex=null;
		
		String stu_profession=null;
		
		String stu_icno=null;
		
		String stu_phone=null;
		
		String stu_birth=null;
		
		String stu_qq=null;
		
		String stu_edu=null;
		
		String stu_school=null;
		
		
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfUpload=new ServletFileUpload(factory);
		int classID=0;
		
		try {
			List<FileItem> itemList=sfUpload.parseRequest(request);
			for (FileItem fileItem : itemList) {
				
				
				if(fileItem.isFormField()){
					String name=fileItem.getFieldName();
					if("stuId".equals(name)){
						String value=fileItem.getString("UTF-8");
						stuId=value;
					}
					if("classId1".equals(name)){
						String value=fileItem.getString("UTF-8");
						classId=value;
					}

					if("云和数据java一班".equals(classId)){
						classID=1;
					}else if("云和数据前端一班".equals(classId)){
						classID=2;
					}else if("云和数据UI一班".equals(classId)){
						classID=3;
					}else if("云和数据java二班".equals(classId)){
						classID=4;
					}
					
					
					if("stu_no1".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_no=value;
					}
					if("stu_name".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_name=value;
					}
					if("stu_sex".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_sex=value;
					}
					if("stu_profession".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_profession=value;
					}
					if("stu_icno".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_icno=value;
					}
					if("stu_phone".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_phone=value;
					}
					if("stu_birth".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_birth=value;
					}
					if("stu_qq".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_qq=value;
					}
					if("stu_edu".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_edu=value;
					}
					if("stu_school".equals(name)){
						String value=fileItem.getString("UTF-8");
						stu_school=value;
					}

				}else{
					String name=fileItem.getFieldName();
					if("stu_head1".equals(name)){

						String fileName=fileItem.getName();
						
						if(fileName!=null&&!fileName.isEmpty()){
							if(fileName.endsWith(".jpg")||
									fileName.endsWith(".jpeg")||
									fileName.endsWith(".png")||
									fileName.endsWith(".bmp")||
									fileName.endsWith(".gif")){
							String	fileName2=System.currentTimeMillis()+""+fileName.substring(fileName.lastIndexOf("."));
							String path=getServletContext().getRealPath("/head");
								System.out.println(path);
								File file=new File(path, fileName2);
								fileItem.write(file);
								stu_head=fileName2;
							}else{
								response.getWriter().println("<script>alert('图片格式不合法');history.go(-1)</script>");
							}
							
						}else{
							stu_head="-1.jsp";
						}

					}

				}

			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StudentBiz studentBiz=new StudentBizImpl();
		
		studentBiz.updateStudent(Integer.parseInt(stuId), stu_no, stu_name, stu_profession, stu_sex, stu_head, stu_phone, stu_icno, stu_birth, stu_qq,classID, stu_edu, stu_school);
		
		//1>提示“修改成功”
		//2>跳回stulist.jsp，重新请求
				
		response.getWriter().write("<script>alert('success!');location.href='Student_controller?method=select';</script>");
		
	}
	
	
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newCurrentPage=request.getParameter("currentPage");
		String class_id=request.getParameter("class_id");
		request.setAttribute("class_id", class_id);
		
		
		String stu_name=request.getParameter("stu_name");
		stu_name=stu_name==null?"":stu_name;
		request.setAttribute("stu_name", stu_name);
		String stu_profession=request.getParameter("stu_profession");
		stu_profession=stu_profession==null?"":stu_profession;
		request.setAttribute("stu_profession", stu_profession);
		String stu_sex=request.getParameter("stu_sex");
		stu_sex=stu_sex==null?"":stu_sex;
		request.setAttribute("stu_sex", stu_sex);
		String strMan="";
		String strWomen="";
		if(stu_sex.equals("男")){
			strMan="selected='selected'";
			request.setAttribute("strMan", strMan);
		}
		if(stu_sex.equals("女")){
			strWomen="selected='selected'";
			request.setAttribute("strWomen", strWomen);
		}
		
		
		//默认第1页
		int currentPage=newCurrentPage==null?1:Integer.parseInt(newCurrentPage);
		
		request.setAttribute("currentPage", currentPage);
		//每页15条
		int line=15;
		
		
		List<Student> studentList=studentBiz.seleteStudentMessage(stu_name,stu_profession,stu_sex,class_id,currentPage,line);
		request.setAttribute("studentList", studentList);
		//总记录数
		int num=studentBiz.seleteStudentRecord(stu_name, stu_profession, stu_sex ,class_id);
		request.setAttribute("num", num);
		//总页数
		int lines=studentBiz.calculateStudentPage(stu_name, stu_profession, stu_sex,class_id,line);
		request.setAttribute("lines", lines);
		
		
		request.getRequestDispatcher("WEB-INF/jsp/stuinfomanager.jsp").forward(request, response);
		
		
	}
	
	private void add2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("WEB-INF/jsp/addstu.jsp").forward(request, response);
	}
	
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置request请求的编码格式
		
		String stuId=request.getParameter("stuId");
		request.setAttribute("stuId", stuId);
		Student student=studentBiz.selectStudentOne(Integer.parseInt(stuId));
		request.setAttribute("student", student);
		
		
		String className="";
		if(1==student.getClass_id()){
			className="云和数据java一班";
		}else if(2==student.getClass_id()){
			className="云和数据前端一班";
		}else if(3==student.getClass_id()){
			className="云和数据UI一班";
		}else if(4==student.getClass_id()){
			className="云和数据java二班";
		}
		request.setAttribute("className", className);
		
		String man="";
		String woman="";
		if(student.getStu_sex().equals("男")){
			man="checked='checked'";
			request.setAttribute("man", man);
		}else{
			woman="checked='checked'";
			request.setAttribute("woman", woman);
		}
		
		String xuel1="";
		String xuel2="";
		String xuel3="";
		String xuel4="";
	
		if("高中".equals(student.getStu_edu())){
			xuel1="selected='selected'";
			request.setAttribute("xuel1", xuel1);
		}
		if("大专".equals(student.getStu_edu())){
			xuel2="selected='selected'";
			request.setAttribute("xuel2", xuel2);
		}
		if("本科".equals(student.getStu_edu())){
			xuel3="selected='selected'";
			request.setAttribute("xuel3", xuel3);
		}
		if("硕士".equals(student.getStu_edu())){
			xuel4="selected='selected'";
			request.setAttribute("xuel4", xuel4);
		}
		
		
		request.getRequestDispatcher("WEB-INF/jsp/updatestu.jsp").forward(request, response);
	}
	

}
