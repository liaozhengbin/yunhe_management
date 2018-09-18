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

<div class="box">
    <form id="uploadForm" action="role?method=update2&class_id=${requestScope.roleId }" class="form-horizontal" role="form" method="post">
        <div class="form-group">
        
            <label for="user_id" class="col-sm-2 control-label">角色ID:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="class_id" 
                id="class_id" disabled="disabled" value="${requestScope.roleId }" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">角色名称:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="class_name" 
                id="class_name" value="${requestScope.role_name }" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">拥有权限:</label>
            &nbsp;&nbsp;
            
            <c:forEach items="${requestScope.permissionList }" var="per">
           		 <c:set var="checked">
           		 <c:forEach items="${requestScope.roleInfo }" var="role">
           		 ${ per.permission_id==role.permission_id?"checked='checked'" : "" }
           		 </c:forEach>
           		 </c:set>
	            <input type="checkbox" name="permission" value="${per.permission_id}"  ${checked} />${per.permission_des}&nbsp;&nbsp;
			</c:forEach>
			
			
			
			
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary"">修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>
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
