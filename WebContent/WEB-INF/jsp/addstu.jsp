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
    <form id="uploadForm" action="Student_controller?method=add" class="form-horizontal" role="form" enctype="multipart/form-data"  method="post">
    	<div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">头像:</label>
            <div class="col-sm-10">
                <input type="file" class="form-control" name="stu_head"
                       id="stu_head" placeholder="请选择头像" />
            </div>
        </div>
        
        <div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">所属班级:</label>
            <div class="col-sm-10">
		        <select class="form-control" name="class_id">
		        	   <option value="1" selected="selected">云和数据java一班</option>
		        	   <option value="2">云和数据前端一班</option>
		        	   <option value="3">云和数据UI一班</option>
		        	   <option value="4">云和数据java二班</option>
				</select>
			</div>
		</div>
        
        <div class="form-group">
            <label for="user_id" class="col-sm-2 control-label">学号:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_no" 
                id="stu_no" />
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">姓名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_name"
                       id="stu_name" />
            </div>
        </div>
         <div class="form-group">
            <label for="sex" class="col-sm-2 control-label">性别:</label>
            <div class="col-sm-10">
                <input type="radio" name="stu_sex" id="stu_sex" value="男" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="radio" name="stu_sex" id="stu_sex" value="女 " />女
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">专业:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_profession"
                       id="stu_profession" />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">身份证:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_icno"
                       id="stu_icno" />
            </div>
        </div>
         <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">电话:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_phone" id="stu_phone" />
            </div>
        </div>
        <div class="form-group">
            <label for="address" class="col-sm-2 control-label">生日:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_birth" id="datepicker" />
            </div>
        </div>
         <div class="form-group">
            <label for="address" class="col-sm-2 control-label">QQ:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_qq" id="stu_qq" />
            </div>
        </div>
        <div class="form-group">
            <label for="bookLogo" class="col-sm-2 control-label">学历:</label>
            <div class="col-sm-10">
		        <select class="form-control" name="stu_edu">
					   <option value="高中">高中</option>
					   <option value="大专">大专</option>
					   <option value="本科" selected="selected">本科</option>
					   <option value="硕士">硕士</option>
				</select>
			</div>
		</div>
		<div class="form-group">
            <label for="address" class="col-sm-2 control-label">学校:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="stu_school" id="stu_school" />
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
