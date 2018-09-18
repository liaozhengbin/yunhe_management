<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级信息管理</title>

<script type="text/javascript">
 
  
  function deleteClick(scoreId){
		if(confirm("确认删除吗？")){
			location.href="class_controller?method=delete&class_id="+scoreId;
		}
	}
  
</script>


<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<script type="text/javascript" src="js/classs.js"></script>
<!-- 提示框 -->



</head>

<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">班级管理</a>&nbsp;>>&nbsp;
				<a href="#">班级信息管理</a>
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
			<form id="myForm" class="navbar-form navbar-left" role="search"  action="class_controller?method=add" method="post">
				<input type="text" class="form-control" placeholder="请输入班级名称" name="class_name" />
				<button type="submit" class="btn btn-default" >添加班级</button>
			</form>
		</div>
		
	</div>
</nav>

<div id="content" style="margin-left: 60px;margin-right: 60px">
    <span>共有 <b>${requestScope.zs}</b> 条记录</span>
    <table border="1" cellspacing="0" cellpadding="0" class="table table-striped table-hover table-bordered">
        <tr id="theTableTitle">
            <th>班级ID</th>
            <th>班级名称</th>
            <th>操作</th>
        </tr>
        
        <c:forEach items="${requestScope.classArray}" var="cls" >

        <tr>
            <td>${cls.class_id}</td>
            <td>${cls.class_name}</td>
            <td>
            <input type="hidden" name="class_id" value="${cls.class_id}" />
            	<a href="javascript:deleteClick(${cls.class_id})">[删除]</a>
                <a href="class_controller?method=update2&class_id=${cls.class_id}">[修改]</a>
            </td>
        </tr>
		</c:forEach>


    </table>
</div>
</body>
</html>
