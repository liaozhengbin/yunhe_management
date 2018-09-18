/**
 * 
 */


$(function() {

	$("#myForm").submit(function() {
		var start_time = $("input[name='start_time']").val();
		var end_time = $("input[name='end_time']").val();

		// 验证逻辑
		if (start_time == '') {
			show_err_msg("请输入上班打卡时间");
			return false;
		}else if(end_time == '') {
			show_err_msg("请输入下班打卡时间");
			return false;
		} else {
			return true;
		}
	});
});