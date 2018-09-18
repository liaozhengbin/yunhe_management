<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云和数据教学管理系统</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript">
	function setRightContents(url){
		document.getElementById('rightContents').src=url;
	}
	
</script>
</head>

<body>
    	
<div class="nav-top">
	<span>云和数据教学管理系统</span>
    <div class="nav-topright">
    
    
    
        <span>您好：${sessionScope.User.user_name}</span>
        <span><a href="test_login?method=exit" style="color: #FFFFFF">注销</a></span>
    </div>
</div>

<div class="nav-down">

    <div class="leftmenu2">
    	<div class="menu-oc1"></div>
        <ul>
        	<c:forEach items="${sessionScope.PermissionInfoList}" var="pmsList">
        		<c:if test="${pmsList.permission_id==1 }">
	        		<li>
			            <a class="j_a_list j_a_list1"></a>
			               <div class="j_menu_list j_menu_list_first">
			                <span class="sp1"><i></i>学员管理</span>
			                   <a class="j_lista_first" href="javascript:setRightContents('Student_controller?method=select&class_id=${sessionScope.User.class_id}')">学员信息管理</a>
			                   <a href="#">导入excel</a>
			               </div>
			        </li>
				</c:if>
				<c:if test="${pmsList.permission_id==2 }">
			        <li>
			            <a class="j_a_list j_a_list2"></a>
			               <div class="j_menu_list">
			                <span class="sp2"><i></i>积分管理</span>
			                   <a href="javascript:setRightContents('score_controller?method=select&class_id=${sessionScope.User.class_id}')">积分信息管理</a>
			               </div>
			        </li>
		        </c:if>
		        <c:if test="${pmsList.permission_id==3 }">
			        <li>
			            <a class="j_a_list j_a_list3"></a>
			               <div class="j_menu_list">
			                <span class="sp3"><i></i>考勤管理</span>
			                   <a href="javascript:setRightContents('record_controller?method=select&class_id=${sessionScope.User.class_id}')">打卡记录管理</a>
			                   <a href="#">导入excel</a>
			                   <a href="#">导入Access</a>
			              </div>
			        </li>	 
		        </c:if>        
		        <c:if test="${pmsList.permission_id==4 }">          
			        <li>
			            <a class="j_a_list j_a_list4"></a>
			              <div class="j_menu_list">
			                <span class="sp4"><i></i>权限管理</span>
			                   <a href="javascript:setRightContents('user?method=select')">用户列表管理</a>
			                   <a href="javascript:setRightContents('role?method=select')">角色列表管理</a>
			                   <a href="javascript:setRightContents('permission?method=select')">权限列表管理</a>
			              </div>
			        </li>	
		        </c:if>     
		        <c:if test="${pmsList.permission_id==5 }">                   
			        <li>
			            <a class="j_a_list j_a_list5"></a>
			              <div class="j_menu_list">
			                <span class="sp5"><i></i>班级管理</span>
			                   <a href="javascript:setRightContents('class_controller?method=select')">班级信息管理</a>
			              </div>
			        </li>
		        </c:if> 
			</c:forEach>
        </ul>
        
    </div>
	
    <div class="rightcon">
    	<div class="right_con" style="width:100%;height: 1200px">
        	<iframe src="Student_controller?method=select&class_id=${sessionScope.User.class_id}" frameBorder="0" scrolling="no" width="100%" height="100%" id="rightContents">
			</iframe>
        </div>
    </div>
</div>

</body>
</html>