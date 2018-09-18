// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}
		
		function changeCode(){
			//带参数是为了让src中的路径每次都变化，这样才能让刷新验证码（如果每次的路径都一样，就不会再去重新请求Servlet）
			document.getElementById('captcha_img').src="verifyServlet?d="+new Date().getTime();
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				var myReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/; //邮件正则
				var emailStr=$('#email').val();
				var pwdStr=$('#password').val();
				var captchaStr=$('#j_captcha').val();
				
				
				if(emailStr == ''){
					show_err_msg('请输入邮箱！');	
					$('#email').focus();
				}else if(!myReg.test(emailStr)){
					show_err_msg('您的邮箱格式错咯！');
					$('#email').focus();
				}else if(pwdStr == ''){
					show_err_msg('请输入密码！');
					$('#password').focus();
				}
				/*
				else if(captchaStr == ''){
					show_err_msg('请输入验证码！');
					$('#j_captcha').focus();
				}
				*/
				else{
					
					//提交表单
					$("#login_form").submit();
					
					/*
					var j_remember="-1";
					//判断是否选中“记住登录状态”
					if($('#j_remember').is(':checked')) {
						j_remember="1";
					}
					
					//ajax请求servlet
				    var url="userServlet";
					var data={
							method:"checklogin1",
							user_name:emailStr,
							user_pwd:pwdStr,
							verifyCode:captchaStr,
							j_remember:j_remember
					};
					$.post(url,data,function(response){
						var jsonData=$.parseJSON(response);
						var result=jsonData.status;
						
						if(result=="-1"){
							show_err_msg('帐号或密码错误！');
							changeCode();
						}else if(result=="0"){
							show_err_msg('验证码错误！');
							changeCode();
						}else if(result=="1"){
							show_err_msg('您没有管理员权限！');
							changeCode();
						}else{
							show_msg('登录成功咯！  正在为您跳转...','index.jsp');
						}
		
					});
						*/
				}
			});
		});