<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/bootstrap.min.css" />

<!-- 下拉列表（小箭头） -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 下拉列表（小箭头） -->

<!-- 日期选择器 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css" />
<!------------>

<!-- 提示框 -->
<script type="text/javascript" src="js/tooltips.js"></script>
<!-- 提示框 -->

<script type="text/javascript">
  
  
  function deleteClick(recordId){
		if(confirm("确认删除吗？")){
			location.href="record_controller?method=delete&recordId="+recordId;
		}
	}
  
</script>

<title>管理区域</title>
<style type="text/css">
        .my{
            padding: 16px;
        }
</style>

<script type="text/javascript">
  /**日期选择器**/
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  
  
  /**全选、全不选**/
  $(function() {
	  $("#all_ck").change(function(){
		  if ($(this).is(':checked')) {//全选
			  $("[name=ck]:checkbox").each(function(){
				  this.checked=true;
			  		//$(this).attr("checked",true);
			  });
		  }else{//全不选
			  $("[name=ck]:checkbox").each(function(){
				  this.checked=false;
			  		//$(this).attr("checked",false);
			  });
		  } 
		  
		});
	  	
	});
  
</script>
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


<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px; margin-top:10px" >
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">筛选</span>
		</div>
		<div>
			<form class="navbar-form navbar-left" role="search"  action="record_controller?method=select" method="post">
				<div class="form-group">
					<input type="text" id="datepicker" name="date" class="form-control" placeholder="请选择日期" value="${requestScope.time==null?"":requestScope.time}" />
				</div>
				<select class="form-control" name="stu_id">
			      <option value="" selected="selected">--请选择姓名--</option>
			      <option value="1" ${requestScope.stu1}>黎立</option>
			      <option value="2" ${requestScope.stu2}>肖冉燎</option>
			      <option value="3" ${requestScope.stu3}>何吕盼</option>
			      <option value="4" ${requestScope.stu4}>王明旸</option>
			      <option value="5" ${requestScope.stu5}>池湘鄂</option>
			    </select>
				<button type="submit" class="btn btn-default">查询</button>
			</form>
		</div>
		
		<div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						状态
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="record_controller?method=select&status=1">正常</a></li>
						<li class="divider"></li>
						<li><a href="record_controller?method=select&status=-1">异常</a></li>
						<li class="divider"></li>
						<li><a href="record_controller?method=select&status=0">待处理</a></li>
					</ul>
				</li>
			</ul>
		</div>
		
	</div>
</nav>

<nav class="navbar navbar-default" role="navigation" style="margin-left: 60px;margin-right: 60px">
	<div class="container-fluid"> 
		<div class="navbar-header">
			<span class="navbar-brand">审核</span>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						标记为 
						<b class="caret"></b>
					</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:updateStatus(1)">正常</a></li>
						<li class="divider"></li>
						<li><a href="javascript:updateStatus(-1)">异常</a></li>
						<li class="divider"></li>
						<li><a href="javascript:updateStatus(0)">待处理</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

<div id="content" style="margin-left: 60px;margin-right: 60px">
    <span>共有 <b>${requestScope.zonglines}</b> 条记录</span>
    <table border="1" cellspacing="0" cellpadding="0" class="table table-striped table-hover table-bordered">
        <tr id="theTableTitle">
       		<th>
       		<input type="checkbox" id="all_ck"  />
       		审核
       		</th>
            <th>日期</th>
            <th>姓名</th>
            <th>上班打卡时间</th>
            <th>下班打卡时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        
        
        <c:forEach items="${requestScope.recordList}" var="record" >
        
        

        <tr>
        	<td><input type="checkbox" id="ck" name="ck" value="${record.record_id}" /></td>
            <td>${record.date}</td>
            <td>${record.stu_name}</td>
            <td>${record.start_time}</td>
            <td>${record.end_time}</td>
            <td>
            <c:if test="${record.status==0}">
            	<font color='black'>待处理</font>
            </c:if>
            <c:if test="${record.status==1}">
            	<font color='#00FF00'>正常</font>
            </c:if>
            <c:if test="${record.status==-1}">
            	<font color='red'>异常</font>
            </c:if>
            	
			</td>
            <td>
            <input type="hidden" name="record_Id" value="${record.record_id}" />
            	<a href="javascript:deleteClick(${record.record_id})">[删除]</a>
                <a href="record_controller?method=update2&record_Id=${record.record_id}">[修改]</a>
            </td>
        </tr>
         </c:forEach>
      
       


    </table>
</div>

<div class="footer" style="margin-left: 60px;margin-right: 60px">
    <ul class="pagination pagination myul">
    
    <c:set var="formParam" value="&stu_name=${requestScope.time}&stu_profession=${requestScope.stu_id}&stu_sex=${requestScope.status}&class_id=${requestScope.class_id}" />
		
		<li class='${requestScope.yeshu==1?"disabled":""}'>
		<a href='${requestScope.yeshu==1?"#":"record_controller?method=select&yeshu=1"}${formParam}'>&laquo;首页</a>
		</li>
		<li class='${requestScope.yeshu==1?"disabled":""}'>
		<a href='${requestScope.yeshu==1?"#":"record_controller?method=select&yeshu="}${requestScope.yeshu-1}${formParam}'>上一页</a>
		</li>
		
	<c:set var="hys"  >	
		<c:if test="${requestScope.yeshu%10==0}">
		 	<fmt:formatNumber value="${requestScope.yeshu/10}" pattern="#" />
		</c:if>
		<c:if test="${requestScope.yeshu%10!=0}">
			<fmt:formatNumber value="${requestScope.yeshu/10+0.5}" pattern="#" />
		</c:if>
	</c:set>							
		
		<c:forEach begin="${(hys-1)*10+1 }"  end="${hys*10}"  var="i" step="1">
			<c:if test="${i<=requestScope.zongys }">
			<li class='${i==requestScope.yeshu?"active":"" }'><a href='record_controller?method=select&yeshu=${i }${formParam }'>${i }</a></li>
			</c:if>
		</c:forEach>

		<li class='${requestScope.yeshu==requestScope.zongys?"disabled":""}'>
			<a href='${requestScope.yeshu==requestScope.zongys?"#":"record_controller?method=select&yeshu="}${requestScope.yeshu+1}${formParam}'>下一页 </a>
		</li>
		<li class='${requestScope.yeshu==requestScope.zongys?"disabled":""}'>
			<a href='${requestScope.yeshu==requestScope.zongys?"#":"record_controller?method=select&yeshu="}${requestScope.zongys}${formParam}'>末页 </a>
		</li>
    
    
   
        
        
        
    </ul>
</div>
<script type="text/javascript">

	function updateStatus(status){
		
		var recordArray=new Array();
		
		//获取选中的复选框ck的值
		$("input[name='ck']:checked").each(function(){
			recordArray.push(this.value);
		});
		
		
		if(recordArray.length>0){
			var hobbyStr=recordArray.join("-");
			location.href="record_controller?method=updateStatus&status="+status+"&recordIds="+hobbyStr;
		}else{
			show_err_msg("请至少选择一条记录");
		}
		
		
		
	}
	
</script>




</body>
</html>

