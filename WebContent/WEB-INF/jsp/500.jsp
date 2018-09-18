<%@page import="org.apache.log4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		Logger logger=Logger.getLogger(Logger.class);
		
	
		
		StringBuffer sb=new StringBuffer();
		sb.append(exception.toString());
		sb.append("\n");
		//异常类型、异常描述
		sb.append(exception.getClass());
		sb.append(exception.getMessage());
		sb.append("\n");
		
		//打印“运行栈列表信息”
		StackTraceElement[] stackArray =exception.getStackTrace();
		for(StackTraceElement element:stackArray){
			sb.append(element.toString());
			sb.append("\n");
		}
		
		logger.error(sb);
		
		String sn=request.getServerName();
		int port=request.getServerPort();
	%>
	<img src="http://<%=sn %>:<%=port %>/yunhe_management/images/timg.jpg">
	
	
</body>
</html>