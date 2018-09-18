<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级信息管理</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->
<script type="text/javascript">
  
  function deleteClick(roleId){
		if(confirm("确认删除吗？")){
			location.href="role?method=delete&roleId="+roleId;
		}
	}
</script>


</head>

<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">用户管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
	
</nav>

<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px; margin-top:10px" >
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">添加</span>
		</div>
		<div>
			<form class="navbar-form navbar-left" role="search"  action="role?method=addselect">
				<button type="button" class="btn btn-default" onclick="javascript:window.location.href='role?method=addselect'">
					添加角色
				</button>
			</form>
		</div>
		
	</div>
</nav>

<div id="content" style="margin-left: 60px;margin-right: 60px">
    <span>共有 <b>10</b> 条记录</span>
    <table border="1" cellspacing="0" cellpadding="0" class="table table-striped table-hover table-bordered">
        <tr id="theTableTitle">
            <th>角色ID</th>
            <th>角色名称</th>
            <th>操作</th>
        </tr>
		<c:forEach items="${requestScope.roleList }" var="role">
		<tr>
	            <td>${role.role_id }</td>
	            <td>${role.role_name }</td>
	            <td>
	            	<a href="javascript:deleteClick(${role.role_id })">[删除]</a>
	                <a href="role?method=update&roleId=${role.role_id}&role_name=${role.role_name }">[修改]</a>
	            </td>
	        </tr>
		</c:forEach>
		
		

    </table>
</div>
</body>
</html>
