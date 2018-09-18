/**
 * 
 */




// 文档就绪函数
$(function() {

	$("#myForm").submit(function() {
		var typeName = $("select[name='i_type_id']").val();
		var time =$("input[name='i_time']").val();
		var stu_id =$("select[name='i_stu_id']").val();
		var score_contents =$("input[name='i_score_contents']").val();
		var score_value = $("input[name='i_score_value']").val();

		
		// 验证逻辑
		if (typeName == '') {
			show_err_msg("请选择类型");
			return false;
		} else if (time == '') {
			show_err_msg("请选择日期");
			return false;
		} else if (stu_id == '') {
			show_err_msg("请选择姓名");
			return false;
		} else if (score_contents == '') {
			show_err_msg("请输入描述");
			return false;
		} else if (score_value == '') {
			show_err_msg("请输入分值");
			return false;
		} else {
			return true;
		}
	});
	
	
	$("#uploadForm").submit(function() {
		var stu_no =$("input[name='stu_no']").val();
		var stu_name =$("input[name='stu_name']").val();
		var stu_profession =$("input[name='stu_profession']").val();
		var stu_icno = $("input[name='stu_icno']").val();
		var stu_phone = $("input[name='stu_phone']").val();
		var stu_birth = $("input[name='stu_birth']").val();
		var stu_qq = $("input[name='stu_qq']").val();
		var stu_school = $("input[name='stu_school']").val();

		// 验证逻辑
		if(stu_no == '') {
			show_err_msg("请输入学号");
			return false;
		} else if (stu_name == '') {
			show_err_msg("请输入姓名");
			return false;
		} else if (stu_profession == '') {
			show_err_msg("请输入专业");
			return false;
		} else if (stu_icno == '') {
			show_err_msg("请输入身份证");
			return false;
		}else if (stu_phone == '') {
			show_err_msg("请输入电话");
			return false;
		}else if (stu_birth == '') {
			show_err_msg("请输入生日");
			return false;
		}else if (stu_qq == '') {
			show_err_msg("请输入qq");
			return false;
		}else if (stu_school == '') {
			show_err_msg("请输入学校");
			return false;
		} else {
			return true;
		}
	});
	
	
	
	
});
