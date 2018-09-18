<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->

<title>管理区域</title>
  <style type="text/css">
      .box {
          width: 60%;
          margin: 50px auto;
          padding: 20px;
          padding-left: 50px;
          border: 1px #ccc dashed;
      }
      .background-head{
			background-image: url(images/-1.jpg);
			background-attachment: fixed;
			background-repeat: no-repeat;
			background-size: 100%;
			height:210px;
			width:250px
		}
  </style>
</head>


<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">权限管理</a>&nbsp;>>&nbsp;
				<a href="#">用户列表管理</a>&nbsp;>>&nbsp;
				<a href="#">添加用户</a>
			</span>
		</div>
	</div>
</nav>

<div class="box">
    <form id="uploadForm" action="user?method=add" class="form-horizontal" role="form" method="post">
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">用户名(邮箱):</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="user_name" 
                id="user_name" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="user_pwd" 
                id="user_pwd" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">昵称:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="user_nickname" 
                id="user_nickname" />
            </div>
        </div>
        <div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">所属角色:</label>
            <div class="col-sm-10">
		        <select class="form-control" name="role_id" id="role_id">
		        <c:forEach items="${requestScope.roleList}" var="role" >
		        	   <option value="${role.role_id}">${role.role_name}</option>
				</c:forEach>
				</select>
			</div>
		</div>
        <div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">所属班级:</label>
            <div class="col-sm-10">
		        <select class="form-control" name="class_id" id="class_id">
		        	   <option value="-1">全部</option>
		        	   <c:forEach items="${requestScope.classList}" var="clazz" >
		        	   <option value="${clazz.class_id}">${clazz.class_name}</option>
					   </c:forEach>
				</select>
			</div>
		</div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;加</button>
                <button type="button" class="btn btn-warning"
                        onclick=" return cancel();">返&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;回</button>
            </div>
        </div>
    </form>
</div>


 <script type="text/javascript">
	
 	function cancel(){
		window.history.go(-1);
	}
	
</script>

</body>
</html>
