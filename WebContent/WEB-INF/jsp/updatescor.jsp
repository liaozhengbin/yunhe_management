<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 日期选择器 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="//code.jquery.com/jquery-1.9.1.js" ></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css" />
<!------------>

<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
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

<script  type="text/javascript">
	$(function() {
    	$( "#datepicker" ).datepicker();
  	});

</script>

</head>

<body>
<!-- 访问路径导航 -->
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">
				<a href="#">积分管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
	
</nav>

	<div class="box" style="width: 60%">
		<form action="score_controller?method=update" class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label for="question" class="col-sm-2 control-label">类型：</label>
				<div class="col-sm-10">
					<select name="status" class="textinput" id="type_id" style="width: 180px; height: 30px">
						<option value="1" ${requestScope.one }>纪律考核分</option>
						<option value="2" ${requestScope.two }>技术考核分</option>
						<option value="3" ${requestScope.three }>职业技能考核分</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="user_id" class="col-sm-2 control-label">日期:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="datepicker" name="datepicker" value="${requestScope.score.time }" />
				</div>
			</div>
			<div class="form-group">
				<label for="question" class="col-sm-2 control-label">姓名：</label>
				<div class="col-sm-10">
					<select class="form-control" name="stu_id" id="stu_id">
					      <option value="" selected="selected">--请选择姓名--</option>
			      		  <option value="1" ${requestScope.stu1 }>黎立</option>
			      		  <option value="2" ${requestScope.stu2 }>肖冉燎</option>
			      		  <option value="3" ${requestScope.stu3 }>何吕盼</option>
			      		  <option value="4" ${requestScope.stu4 }>王明旸</option>
			      		  <option value="5" ${requestScope.stu5 }>池湘鄂</option>
			    </select>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">描述:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="score_contents" id="score_contents" value="${requestScope.score.score_contents }" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">分值:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="score_value" id="score_value" value="${requestScope.score.score_value }" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
				<!-- 隐藏域 -->
					<input type="hidden" name="scoreId" value="${requestScope.scoreId }" />
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
