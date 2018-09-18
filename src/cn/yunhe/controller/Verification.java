package cn.yunhe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yunhe.util.VerifyCodeUtilByYock;
@WebServlet("/verification_controller")
public class Verification extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6430557401524333862L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//���ò�����
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		//����4λ�����
		String code=VerifyCodeUtilByYock.generateVerifyCode(4);
		//����������session
		request.getSession().setAttribute("code", code);
		
		VerifyCodeUtilByYock.outputImageStream(200, 80, response.getOutputStream(), code);
		
	}
	
	
	
}
