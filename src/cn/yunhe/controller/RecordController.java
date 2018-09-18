package cn.yunhe.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.RecordBiz;
import cn.yunhe.biz.impl.RecordBizImpl;
import cn.yunhe.entity.RecordInfo;

@WebServlet("/record_controller")
public class RecordController extends HttpServlet{
	private RecordBiz recordBiz=new RecordBizImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4711032335891313884L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String method=request.getParameter("method");
		
		if("delete".equals(method)){
			delete(request, response);
		}else if ("update".equals(method)){
			update(request, response);
		}else if("updateStatus".equals(method)){
			updateStatus(request, response);
		}else if("select".equals(method)){
			select(request, response);
		}else if("update2".equals(method)){
			update2(request, response);
		}
		
		
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String recordId=request.getParameter("recordId");
		
		recordBiz.deleteRecord(Integer.parseInt(recordId));
		response.sendRedirect("record_controller?method=select");
		
	}
	
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String record_Id=request.getParameter("record_Id");
		String date=request.getParameter("date1");
		String name=request.getParameter("name1");
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		String status=request.getParameter("status");
		
		
		recordBiz.updateRecord(date, name, start_time, end_time, Integer.parseInt(status), Integer.parseInt(record_Id));
		
		response.sendRedirect("record_controller?method=select");
	}
	
	
	private void updateStatus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status=request.getParameter("status");
		String recordIds=request.getParameter("recordIds");
		
		
		String[] strArray=recordIds.split("-");
		List<String> strList=Arrays.asList(strArray);
		
		recordBiz.updateRecordStatus(strList, status);;
		
		
		response.sendRedirect("record_controller?method=select");
		
	}
	
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String class_id=request.getParameter("class_id");
			
			request.setAttribute("class_id", class_id);
		 
			String status=request.getParameter("status");
			status=status==null?"":status;
			request.setAttribute("status", status);
	        String zongyeshu=request.getParameter("yeshu");
	        
	        String time=request.getParameter("date");
	        time=time==null?"":time;
	        request.setAttribute("time", time);
	       
	        String stu_id=request.getParameter("stu_id");
	        stu_id=stu_id==null?"":stu_id;
	        request.setAttribute("stu_id", stu_id);
	        
	        String stu1="";
	    	String stu2="";
	    	String stu3="";
	    	String stu4="";
	    	String stu5="";
	    	
	    	if("1".equals(stu_id)){
	    		stu1="selected='selected'";
	    		request.setAttribute("stu1", stu1);
	    	}
	    	if("2".equals(stu_id)){
	    		stu2="selected='selected'";
	    		request.setAttribute("stu2", stu2);
	    	}
	    	if("3".equals(stu_id)){
	    		stu3="selected='selected'";
	    		request.setAttribute("stu3", stu3);
	    	}
	    	if("4".equals(stu_id)){
	    		stu4="selected='selected'";
	    		request.setAttribute("stu4", stu4);
	    	}
	    	if("5".equals(stu_id)){
	    		stu5="selected='selected'";
	    		request.setAttribute("stu5", stu5);
	    	}
	        
	      	//默认第1页
	        int yeshu=zongyeshu==null?1:Integer.parseInt(zongyeshu);
	        request.setAttribute("yeshu", yeshu);
	        //行数
	        int line=15;
	        

	        List<RecordInfo> recordList=recordBiz.queryRecordInfo(time, stu_id,status,class_id, yeshu, line);
	        request.setAttribute("recordList", recordList);
	        
	      	//总行数
	    	int zonglines=recordBiz.seleteRecord(time, stu_id,status,class_id);
	    	request.setAttribute("zonglines", zonglines);
	    	//总页数
	    	int zongys=recordBiz.calculateRecordPage(time, stu_id, status,class_id,line);
	    	request.setAttribute("zongys", zongys);
	        
	        request.getRequestDispatcher("WEB-INF/jsp/checkingmanager.jsp").forward(request, response);
		
	}
	
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String record_Id=request.getParameter("record_Id");	
		request.setAttribute("record_Id", record_Id);
		RecordInfo record=recordBiz.selectRecordOne(Integer.parseInt(record_Id));
		request.setAttribute("record", record);
		
		String status1="";
		String status2="";
		String status3="";
		if(1==record.getStatus()){
			status1="selected='selected'";
			request.setAttribute("status1", status1);
		}
		if(-1==record.getStatus()){
			status2="selected='selected'";	
			request.setAttribute("status2", status2);
		}
		if(0==record.getStatus()){
			status3="selected='selected'";
			request.setAttribute("status3", status3);
		}
		
		
		
		request.getRequestDispatcher("WEB-INF/jsp/updaterecord.jsp").forward(request, response);
	}
	
	

}
