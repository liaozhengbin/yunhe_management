<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->
<!-- 提示框 -->
<script type="text/javascript" src="js/record.js"></script>
<!-- 提示框 -->

<title>管理区域</title>
<style type="text/css">
.box {
	width: 44%;
	margin: 50px auto;
	padding: 20px;
	padding-left: 50px;
	border: 1px #ccc dashed;
}
</style>

</head>

<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">考勤管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
	
</nav>



	<div class="box" style="width: 80%">
		<form id="myForm" action="record_controller?method=update" class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label for="user_id" class="col-sm-2 control-label">日期:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="date" id="user_id"
						value="${requestScope.record.date}" disabled="disabled" />
						<input type="hidden" name="date1" value="${requestScope.record.date}" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name" id="username"
						value="${requestScope.record.stu_name}" disabled="disabled" />
						<input type="hidden" name="name1" value="${requestScope.record.stu_name}" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">上班打卡时间:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="start_time" id="start_time"
						value="${requestScope.record.start_time}" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">下班打卡时间:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="end_time" id="end_time"
						value="${requestScope.record.end_time}" />
				</div>
			</div>
			<div class="form-group">
				<label for="question" class="col-sm-2 control-label">审核状态：</label>
				<div class="col-sm-10">
					<select name="status" class="textinput" id="status" style="width: 180px; height: 30px">
					
						<option value="1" ${requestScope.status1}>正常</option>
						<option value="-1" ${requestScope.status2}>异常</option>
						<option value="0" ${requestScope.status3}>待处理</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<input type="hidden" name="record_Id" value="${requestScope.record.record_id}" />
					<button type="submit" class="btn btn-primary">修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>
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
