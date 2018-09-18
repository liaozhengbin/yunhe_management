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

<!-- 提示框 -->
<script type="text/javascript" src="js/student.js"></script>
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
				<a href="#">学员管理</a>&nbsp;>>&nbsp;
				<a href="#">XXXXXXX</a>
			</span>
		</div>
	</div>
	
</nav>



<div class="box">
	<div class="box" 
	style="background:url(images/-1.jpg);width:210px;height:250px;
	background-repeat:no-repeat;background-size:210px 250px;">
	</div>
    <form id="uploadForm" action="Student_controller?method=update" class="form-horizontal" role="form" method="post" enctype="multipart/form-data">
    	<div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">头像:</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" name="stu_head"
                       id="stu_head" placeholder="请选择头像" value=" ${requestScope.student.stu_img }"/>
                       <!-- 隐藏域 -->
					<input type="hidden" name="stu_head1" value="${requestScope.student.stu_img }" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">所属班级:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="classId" 
                id="stu_no" disabled="disabled" value="${requestScope.className }" />
                <!-- 隐藏域 -->
				<input type="hidden" name="classId1" value="${requestScope.className }" />
            </div>
        </div>
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">学号:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_no" 
                id="stu_no" disabled="disabled" value="${requestScope.student.stu_no }" />
                <!-- 隐藏域 -->
				<input type="hidden" name="stu_no1" value="${requestScope.student.stu_no }" />
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_name"
                       id="stu_name" value="${requestScope.student.stu_name }" />
            </div>
        </div>
         <div class="form-group">
            <label for="sex" class="col-sm-2 control-label">性别:</label>
            <div class="col-sm-10">
                <input type="radio" name="stu_sex" id="stu_sex" value="男" ${requestScope.man } />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="stu_sex" id="stu_sex" value="女" ${requestScope.woman } />女&nbsp;&nbsp;
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">专业:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_profession"
                       id="stu_profession" value="${requestScope.student.stu_profession }" />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">身份证:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_icno"
                       id="stu_icno" value="${requestScope.student.stu_icno }" />
            </div>
        </div>
         <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">电话:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_phone" id="stu_phone"
                       value="${requestScope.student.stu_phone }" />
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">生日:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_birth" id="stu_birth"
                       value="${requestScope.student.stu_birth }" />
            </div>
        </div>
         <div class="form-group">
            <label for="address" class="col-sm-2 control-label">QQ:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_qq" id="stu_qq"
                       value="${requestScope.student.stu_qq }" />
            </div>
        </div>
        <div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">学历:</label>
            <div class="col-sm-10">
		        <select class="form-control" name="stu_edu">
					   <option value="高中" ${requestScope.xuel1 }>高中</option>
					   <option value="大专" ${requestScope.xuel2 }>大专</option>
					   <option value="本科" ${requestScope.xuel3 }>本科</option>
					   <option value="硕士" ${requestScope.xuel4 }>硕士</option>
				</select>
			</div>
		</div>
		<div class="form-group">
            <label for="address" class="col-sm-2 control-label">学校:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_school" id="stu_school"
                	value="${requestScope.student.stu_school }" />
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            		<!-- 隐藏域 -->
					<input type="hidden" name="stuId" value="${requestScope.stuId }" />
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
