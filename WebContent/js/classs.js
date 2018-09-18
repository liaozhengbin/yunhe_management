/**
 * 
 */

$(function() {

	$("#myForm").submit(function() {
		var className = $("input[name='class_name']").val();

		// 验证逻辑
		if (className == '') {
			show_err_msg("请输入班级名称");
			return false;
		} else {
			return true;
		}
	});
});
