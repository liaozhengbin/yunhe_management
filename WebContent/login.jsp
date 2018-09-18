<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">

<head>
<meta charset="utf-8">
<title>云和数据教学管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="css/supersized.css">
<link rel="stylesheet" href="css/login.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	<script src="js/html5.js"></script>
<![endif]-->
<script src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/tooltips.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

</head>

<body>

<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_logo">
				<h1>云和数据教学管理系统</h1>
			</div>
			
			<!-- 其他管理员登录 -->
			<div id="otherLogin">
				<div class="box" 
				style="background:url(images/qq.jpg);width:200px;height:200px;
				background-repeat:no-repeat;background-size:200px 200px;margin-left: 30%;margin-right: 30%;">
				</div>
				<div class="form-group">
							<label class="t"></label>
							<span id="qqLoginBtn" class="box" style="background:url(images/qq.jpg);width:200px;height:50px;
								background-repeat:no-repeat;background-size:200px 50px;margin-left: 34%;margin-right: 34%;">
							</span>
				</div>
				
				<div class="bottom">Copyright &copy; 2014 - 2015 <a href="javascript:replaceLoginType(1)">系统登陆</a></div>
			</div>
			
		
			<!-- 超级管理员登录 -->
			<div class="login_form" id="normalLogin" style="display: none">
				<form action="test_login?method=login" id="login_form" method="post">
					<div class="form-group">
						<label for="j_username" class="t">邮　箱：</label> 
						<input id="email" value="" name="email" type="text" class="form-control x319 in" 
						autocomplete="off">
					</div>
					<div class="form-group">
						<label for="j_password" class="t">密　码：</label> 
						<input id="password" value="" name="password" type="password" 
						class="password form-control x319 in" />
					</div>
					<div class="form-group">
						<label for="j_captcha" class="t">验证码：</label>
						 <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in" />
						<a href="javascript:verification()">
						<img  src="verification_controller"  id="imgCode"/>
						</a>
						
					</div>
					<div class="form-group">
						<label class="t"></label>
						<label for="j_remember" class="m">
						<input name="remember" id="j_remember" type="checkbox" value="true">&nbsp;记住登陆状态</label>
					</div>
					<div class="form-group space">
						<label class="t"></label>　　
						<button type="button"  id="submit_btn" class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp </button>
						<input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
					</div>
				</form>
				
				<div class="bottom">Copyright &copy; 2014 - 2015 <a href="javascript:replaceLoginType(2)">使用QQ登陆</a></div>
			</div>
			
			
		</div>
		
	</div>
</div>

<!-- Javascript -->

<script src="js/supersized.3.2.7.min.js"></script>
<script src="js/supersized-init.js"></script>
<script src="js/scripts.js"></script>

<script type="text/javascript">
	function replaceLoginType(type) {
		if(type==1){//使用管理员登录
			$("#normalLogin").show();
			$("#otherLogin").hide();
		}else{//使用QQ登录
			$("#normalLogin").hide();
			$("#otherLogin").show();
		}
	}
	
	
	function verification(){
		document.getElementById('imgCode').src="verification_controller?yanzheng="+new Date().getTime();
	}
	
	
</script>

</body>
</html>