package cn.yunhe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.biz.ScoreBiz;
import cn.yunhe.biz.impl.ScoreBizImpl;
import cn.yunhe.entity.ScoreInfo;


@WebServlet("/score_controller")
public class ScoreController extends HttpServlet{
	private ScoreBiz scoreBiz=new ScoreBizImpl();
	private ScoreInfo score=new ScoreInfo();
	/**
	 * 
	 */
	private static final long serialVersionUID = 5793799460241708401L;
	
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
		String type_id=request.getParameter("i_type_id");
		String time2=request.getParameter("i_time");
		String [] time1 = time2.split("/");
		String time=time1[2]+"-"+time1[0]+"-"+time1[1];
		String stu_id=request.getParameter("i_stu_id");
		String score_contents=request.getParameter("i_score_contents");
		String score_value=request.getParameter("i_score_value");
		
		
		
		score.setScore_type(Integer.parseInt(type_id));
		score.setTime(time);
		score.setStu_name(stu_id);
		score.setScore_contents(score_contents);
		score.setScore_value(Double.parseDouble(score_value));
		scoreBiz.addScore(score);
		
		
		
		response.sendRedirect("score_controller?method=select");
	
		
	}
	
	
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String scoreId=request.getParameter("scoreId");
		ScoreBiz  scoreBiz=new ScoreBizImpl();
		scoreBiz.deleteScore(Integer.parseInt(scoreId));
		response.sendRedirect("score_controller?method=select");
		
		
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String scoreId=request.getParameter("scoreId");
		String type_id=request.getParameter("status");
		String time=request.getParameter("datepicker");
		String stu_id=request.getParameter("stu_id");
		String score_contents=request.getParameter("score_contents");
		String score_value=request.getParameter("score_value");
		
		
		
		scoreBiz.updateScore(Integer.parseInt(scoreId), type_id, time, stu_id, score_contents, Double.parseDouble(score_value));
		
		//1>提示“修改成功”
		//2>跳回stulist.jsp，重新请求
		
		response.getWriter().write("<script>alert('success!');location.href='score_controller?method=select';</script>");
		
	}
	
	
	
	
	private void select(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String class_id=request.getParameter("class_id");
		request.setAttribute("class_id", class_id);
		
		String yeshu2=request.getParameter("yeshu");
		
		String type_id=request.getParameter("type_id");
		type_id=type_id==null?"":type_id;
		request.setAttribute("type_id", type_id);
		String one="";
		String two="";
		String three="";
		String type_name="";
		if("1".equals(type_id)){
			one="selected='selected'";
			request.setAttribute("one", one);
			type_name="纪律考核分";
		}
		if("2".equals(type_id)){
			two="selected='selected'";
			request.setAttribute("two", two);
			type_name="技术考核分";
		}
		if("3".equals(type_id)){
			three="selected='selected'";
			request.setAttribute("three", three);
			type_name="职业能力考核分";
		}
		request.setAttribute("type_name", type_name);
		
		
		String time=request.getParameter("time");
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
		String stuName="";
		if("1".equals(stu_id)){
			stu1="selected='selected'";
			request.setAttribute("stu1", stu1);
			stuName="黎立";
		}
		if("2".equals(stu_id)){
			stu2="selected='selected'";
			request.setAttribute("stu2", stu2);
			stuName="肖冉燎";
		}
		if("3".equals(stu_id)){
			stu3="selected='selected'";
			request.setAttribute("stu3", stu3);
			stuName="何吕盼";
		}
		if("4".equals(stu_id)){
			stu4="selected='selected'";
			request.setAttribute("stu4", stu4);
			stuName="王明旸";
		}
		if("5".equals(stu_id)){
			stu5="selected='selected'";
			request.setAttribute("stu5", stu5);
			stuName="池湘鄂";
		}
		
		request.setAttribute("stuName", stuName);
		
		
		//默认第1页
		int yeshu=yeshu2==null?1:Integer.parseInt(yeshu2);
		request.setAttribute("yeshu", yeshu);
		
		//每页15条
		int hangshu=15;
		
		
		List<ScoreInfo> scoreList=scoreBiz.selectScore(type_id, time, stu_id,class_id, yeshu, hangshu);
		request.setAttribute("scoreList", scoreList);
		
		
		//总行数
		int zonglines=scoreBiz.selectScoreRecord(type_id, time, stu_id,class_id);
		request.setAttribute("zonglines", zonglines);
		//总页数
		int zongys=scoreBiz.selectScorePage(type_id, time, stu_id,class_id, hangshu);
		request.setAttribute("zongys", zongys);
		
		
		
		
		request.getRequestDispatcher("WEB-INF/jsp/scoremanager.jsp").forward(request, response);
	}
	
	
	
	private void update2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置request请求的编码格式
				
			String scoreId=request.getParameter("scoreId");	
			request.setAttribute("scoreId", scoreId);
			
			
			ScoreInfo score=scoreBiz.selectScoreOne(Integer.parseInt(scoreId));
			request.setAttribute("score", score);
				
			String one="";
			String two="";
			String three="";
			if(1==score.getScore_type()){
				one="selected='selected'";
				request.setAttribute("one", one);
			}
			if(2==score.getScore_type()){
				two="selected='selected'";
				request.setAttribute("two", two);
			}
			if(3==score.getScore_type()){
				three="selected='selected'";
				request.setAttribute("three", three);
			}
				
				
			String stu1="";
			String stu2="";
			String stu3="";
			String stu4="";
			String stu5="";
			if(1==score.getStu_id()){
				stu1="selected='selected'";
				request.setAttribute("stu1", stu1);
			}
			if(2==score.getStu_id()){
				stu2="selected='selected'";
				request.setAttribute("stu2", stu2);
			}
			if(3==score.getStu_id()){
				stu3="selected='selected'";
				request.setAttribute("stu3", stu3);
			}
			if(4==score.getStu_id()){
				stu4="selected='selected'";
				request.setAttribute("stu4", stu4);
			}
			if(5==score.getStu_id()){
				stu5="selected='selected'";
				request.setAttribute("stu5", stu5);
			}
				
		
		
		request.getRequestDispatcher("WEB-INF/jsp/updatescor.jsp").forward(request, response);
		
	}
	
	
	

}
